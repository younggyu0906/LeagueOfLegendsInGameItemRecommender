package koreatech.cse.service;

import koreatech.cse.domain.championInfo.ChampionInfo;
import koreatech.cse.domain.match.CurrentMatch;
import koreatech.cse.domain.rest.ChampionInfoRestOut;
import koreatech.cse.domain.rest.MatchInfoRestOut;
import koreatech.cse.domain.staticData.ChampionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CurrentGameService {
    @Inject
    RiotApiService riotApiService;

    @Value("${champion.gg.apikey}")
    private String championGgApiKey;

    // return the champion tag hash map
    private HashMap<String, ArrayList<String>> championTagsIntoHashMap(ChampionDAO championDAO) {
        HashMap<String, ArrayList<String>> championInfo = new HashMap<>();
        ArrayList<String> tags = new ArrayList<>();

        // add to ArrayList
        if (championDAO.isAssassin()) tags.add("Assassin");
        if (championDAO.isFighter()) tags.add("Fighter");
        if (championDAO.isMage()) tags.add("Mage");
        if (championDAO.isMarksman()) tags.add("Marksman");
        if (championDAO.isSupport()) tags.add("Support");
        if (championDAO.isTank()) tags.add("Tank");

        // put tags into hash map
        championInfo.put(championDAO.getName(), tags);
        return championInfo;
    }

    // return MatchInfoRestOut object to return to json
    public MatchInfoRestOut setMatchInfoRestOut(String summoerName) {
        MatchInfoRestOut matchInfoRestOut = new MatchInfoRestOut();
        ArrayList<ChampionDAO> championDAOS;

        // get current game information by summoerName.
        CurrentMatch currentMatch = riotApiService.getCurrentMatchBySummonerName(summoerName);

        // if the game is not progress
        if (currentMatch == null) matchInfoRestOut.setIsProgress(false);

        // if the game is progress
        else {
            matchInfoRestOut.setIsProgress(true);

            // get ally champions
            championDAOS = currentMatch.getTeamChampions();
            championDAOS.stream().forEach(e -> {
                // add ally champions tag hash map to ArrayList
                matchInfoRestOut.addAllyChampions(championTagsIntoHashMap(e));
                // add ally champions stats to ArrayList
                matchInfoRestOut.addAndPutAllyStats("attack", e.getAttack());
                matchInfoRestOut.addAndPutAllyStats("defense", e.getDefense());
                matchInfoRestOut.addAndPutAllyStats("magic", e.getMagic());
            });

            // get enemy champions
            championDAOS = currentMatch.getEnemyChampions();
            championDAOS.stream().forEach(e -> {
                // add enemy champions tag hash map to ArrayList
                matchInfoRestOut.addEnemyChmapions(championTagsIntoHashMap(e));
                // add enemy champions stats to ArrayList
                matchInfoRestOut.addAndPutEnemyStats("attack", e.getAttack());
                matchInfoRestOut.addAndPutEnemyStats("defense", e.getDefense());
                matchInfoRestOut.addAndPutEnemyStats("magic", e.getMagic());
            });
        }
        return matchInfoRestOut;
    }

    // get champion information by champion.gg api. return championInfoRestOut object
    public ChampionInfoRestOut getChampionGg(ChampionInfoRestOut championInfoRestOut, String url) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<ChampionInfo[]> championNormalizedResponseEntity = restTemplate.getForEntity(
                    url, ChampionInfo[].class
            );
            ChampionInfo[] championInfo = championNormalizedResponseEntity.getBody();

            // put rates
            championInfoRestOut.putWinRate(championInfo[0].getElo(), championInfo[0].getWinRate());
            championInfoRestOut.putPlayRate(championInfo[0].getElo(), championInfo[0].getPlayRate());
            championInfoRestOut.putBanRate(championInfo[0].getElo(), championInfo[0].getBanRate());
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
            championInfoRestOut.putWinRate("error", 0);
            championInfoRestOut.putPlayRate("error", 0);
            championInfoRestOut.putBanRate("error", 0);
        }
        return championInfoRestOut;
    }

    // return ChampionInfoRestOut object to return to json
    public ChampionInfoRestOut setChampionInfoRestOut(String summoerName) {
        ChampionInfoRestOut championInfoRestOut = new ChampionInfoRestOut();
        ChampionDAO championDAO;

        String[] eloList = {"BRONZE", "SILVER", "GOLD", "PLATINUM"};

        // get current game information by summoerName.
        CurrentMatch currentMatch = riotApiService.getCurrentMatchBySummonerName(summoerName);

        // if the game is not progress
        if (currentMatch == null) championInfoRestOut.setIsProgress(false);

        // if the game is progress
        else {
            championInfoRestOut.setIsProgress(true);

            championDAO = currentMatch.getMyChampion();
            String id = String.valueOf(championDAO.getId());

            // set champion name
            championInfoRestOut.setChampionName(championDAO.getName());

            // set champion tags
            HashMap<String, ArrayList<String>> championTags = championTagsIntoHashMap(championDAO);
            championInfoRestOut.setTag(championTags.get(championDAO.getName()));

            // set champion stats
            championInfoRestOut.putStats("attack", championDAO.getAttack());
            championInfoRestOut.putStats("defense", championDAO.getDefense());
            championInfoRestOut.putStats("magic", championDAO.getMagic());
            championInfoRestOut.putStats("difficulty", championDAO.getDifficulty());

            // get champion information by champion.gg api.
            // elo = "BRONZE", "SILVER", "GOLD", "PLATINUM"
            for (String elo : eloList) {
                String url = "http://api.champion.gg/v2/champions/" + id +
                        "?elo=" + elo + "&limit=1&champData=normalized&api_key=" + championGgApiKey;
                getChampionGg(championInfoRestOut, url);
            }

            // elo = "PLATINUM,DIAMOND,MASTER,CHALLENGER" default value.
            String url = "http://api.champion.gg/v2/champions/" + id +
                    "?limit=1&champData=normalized&api_key=" + championGgApiKey;
            getChampionGg(championInfoRestOut, url);
        }
        return championInfoRestOut;
    }
}