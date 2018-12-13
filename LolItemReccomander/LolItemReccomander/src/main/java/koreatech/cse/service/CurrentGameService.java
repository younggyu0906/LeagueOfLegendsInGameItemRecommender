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

    // 챔피언정보를 해쉬맵에 넣는 함수, championdao를 받아 해쉬맵형태로 반환
    private HashMap<String, ArrayList<String>> championTagsIntoHashMap(ChampionDAO championDAO) {
        HashMap<String, ArrayList<String>> championInfo = new HashMap<>();
        ArrayList<String> tags = new ArrayList<>();

        if (championDAO.isAssassin()) tags.add("Assassin");     // 가끔 여기서 nullpoint exception
        if (championDAO.isFighter()) tags.add("Fighter");
        if (championDAO.isMage()) tags.add("Mage");
        if (championDAO.isMarksman()) tags.add("Marksman");
        if (championDAO.isSupport()) tags.add("Support");
        if (championDAO.isTank()) tags.add("Tank");

        championInfo.put(championDAO.getName(), tags);
        return championInfo;
    }

    // return to json
    public MatchInfoRestOut setMatchInfoRestOut(String summoerName) {
        MatchInfoRestOut matchInfoRestOut = new MatchInfoRestOut();
        ArrayList<ChampionDAO> championDAOS;

        CurrentMatch currentMatch = riotApiService.getCurrentMatchBySummonerName(summoerName);

        if (currentMatch == null) matchInfoRestOut.setIsProgress(false);

        else {
            matchInfoRestOut.setIsProgress(true);

            championDAOS = currentMatch.getTeamChampions();
            championDAOS.stream().forEach(e -> {
                matchInfoRestOut.addAllyChampions(championTagsIntoHashMap(e));
                matchInfoRestOut.addAndPutAllyStats("attack", e.getAttack());
                matchInfoRestOut.addAndPutAllyStats("defense", e.getDefense());
                matchInfoRestOut.addAndPutAllyStats("magic", e.getMagic());
            });

            championDAOS = currentMatch.getEnemyChampions();
            championDAOS.stream().forEach(e -> {
                matchInfoRestOut.addEnemyChmapions(championTagsIntoHashMap(e));
                matchInfoRestOut.addAndPutEnemyStats("attack", e.getAttack());
                matchInfoRestOut.addAndPutEnemyStats("defense", e.getDefense());
                matchInfoRestOut.addAndPutEnemyStats("magic", e.getMagic());
            });
        }
        return matchInfoRestOut;
    }

    public ChampionInfoRestOut setChampionInfoRestOut(String summoerName) {
        ChampionInfoRestOut championInfoRestOut = new ChampionInfoRestOut();
        RestTemplate restTemplate = new RestTemplate();
        ChampionDAO championDAO;
        String[] eloList = championInfoRestOut.getEloList();

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

            for (String elo : eloList) {
                try {
                    ResponseEntity<ChampionInfo[]> championNormalizedResponseEntity = restTemplate.getForEntity(
                            "http://api.champion.gg/v2/champions/" + id +
                                    "?elo=" + elo + "&limit=1&champData=normalized&api_key=" + championGgApiKey,
                            ChampionInfo[].class
                    );
                    ChampionInfo[] championInfo = championNormalizedResponseEntity.getBody();

                    System.out.println("가즈아" + championInfo[0]);
                    // 해당 elo에서 정보를 받아오지 못하면 에러? 플레까진 받아와짐
                    // api에서 다이아 이상부터는 안받아와지는것 같은데..

                    // put rates
                    championInfoRestOut.putWinRate(elo, championInfo[0].getWinRate());
                    championInfoRestOut.putPlayRate(elo, championInfo[0].getPlayRate());
                    championInfoRestOut.putBanRate(elo, championInfo[0].getBanRate());
                } catch (HttpClientErrorException e) {
                    System.out.println(e.getStatusCode() + ": " + e.getStatusText());
                }
            }
        }
        return championInfoRestOut;
    }
}