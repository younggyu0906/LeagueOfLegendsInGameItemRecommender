package koreatech.cse.service;

import koreatech.cse.domain.championInfo.ChampionInfo;
import koreatech.cse.domain.match.CurrentMatch;
import koreatech.cse.domain.rest.ChampionInformationDTO;
import koreatech.cse.domain.rest.MatchInformationDTO;
import koreatech.cse.domain.rest.RecommendedItemDTO;
import koreatech.cse.domain.staticData.ChampionDAO;
import koreatech.cse.domain.staticData.ItemDAO;
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

    @Inject
    ItemAnalysisService itemAnalysisService;

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

    // return MatchInformationDTO object to return to json
    public MatchInformationDTO setMatchInfoRestOut(String summoerName) {
        MatchInformationDTO matchInformationDTO = new MatchInformationDTO();
        ArrayList<ChampionDAO> championDAOS;

        // get current game information by summoerName.
        CurrentMatch currentMatch = riotApiService.getCurrentMatchBySummonerName(summoerName);

        // if the game is not progress
        if (currentMatch == null) matchInformationDTO.setIsProgress(false);

        // if the game is progress
        else {
            matchInformationDTO.setIsProgress(true);

            // get ally champions
            championDAOS = currentMatch.getTeamChampions();
            championDAOS.stream().forEach(e -> {
                // add ally champions tag hash map to ArrayList
                matchInformationDTO.addAllyChampions(championTagsIntoHashMap(e));
                // add ally champions stats to ArrayList
                matchInformationDTO.addAndPutAllyStats("attack", e.getAttack());
                matchInformationDTO.addAndPutAllyStats("defense", e.getDefense());
                matchInformationDTO.addAndPutAllyStats("magic", e.getMagic());
            });

            // get enemy champions
            championDAOS = currentMatch.getEnemyChampions();
            championDAOS.stream().forEach(e -> {
                // add enemy champions tag hash map to ArrayList
                matchInformationDTO.addEnemyChmapions(championTagsIntoHashMap(e));
                // add enemy champions stats to ArrayList
                matchInformationDTO.addAndPutEnemyStats("attack", e.getAttack());
                matchInformationDTO.addAndPutEnemyStats("defense", e.getDefense());
                matchInformationDTO.addAndPutEnemyStats("magic", e.getMagic());
            });
        }
        return matchInformationDTO;
    }

    // get champion information by champion.gg api. return championInformationDTO object
    public ChampionInformationDTO getChampionGg(ChampionInformationDTO championInformationDTO, String url) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<ChampionInfo[]> championNormalizedResponseEntity = restTemplate.getForEntity(
                    url, ChampionInfo[].class
            );
            ChampionInfo[] championInfo = championNormalizedResponseEntity.getBody();

            // put rates
            championInformationDTO.putWinRate(championInfo[0].getElo(), championInfo[0].getWinRate());
            championInformationDTO.putPlayRate(championInfo[0].getElo(), championInfo[0].getPlayRate());
            championInformationDTO.putBanRate(championInfo[0].getElo(), championInfo[0].getBanRate());
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
            championInformationDTO.putWinRate("error", 0);
            championInformationDTO.putPlayRate("error", 0);
            championInformationDTO.putBanRate("error", 0);
        }
        return championInformationDTO;
    }

    // return ChampionInformationDTO object to return to json
    public ChampionInformationDTO setChampionInfoRestOut(String summoerName) {
        ChampionInformationDTO championInformationDTO = new ChampionInformationDTO();
        ChampionDAO championDAO;

        String[] eloList = {"BRONZE", "SILVER", "GOLD", "PLATINUM"};

        // get current game information by summoerName.
        CurrentMatch currentMatch = riotApiService.getCurrentMatchBySummonerName(summoerName);

        // if the game is not progress
        if (currentMatch == null) championInformationDTO.setIsProgress(false);

        // if the game is progress
        else {
            championInformationDTO.setIsProgress(true);

            championDAO = currentMatch.getMyChampion();
            String id = String.valueOf(championDAO.getId());

            // set champion name
            championInformationDTO.setChampionName(championDAO.getName());

            // set champion tags
            HashMap<String, ArrayList<String>> championTags = championTagsIntoHashMap(championDAO);
            championInformationDTO.setTag(championTags.get(championDAO.getName()));

            // set champion stats
            championInformationDTO.putStats("attack", championDAO.getAttack());
            championInformationDTO.putStats("defense", championDAO.getDefense());
            championInformationDTO.putStats("magic", championDAO.getMagic());
            championInformationDTO.putStats("difficulty", championDAO.getDifficulty());

            // get champion information by champion.gg api.
            // elo = "BRONZE", "SILVER", "GOLD", "PLATINUM"
            for (String elo : eloList) {

                String url = "http://api.champion.gg/v2/champions/" + id +
                        "?elo=" + elo + "&limit=1&champData=normalized&api_key=" + championGgApiKey;
                getChampionGg(championInformationDTO, url);
            }

            // elo = "PLATINUM,DIAMOND,MASTER,CHALLENGER" default value.
            String url = "http://api.champion.gg/v2/champions/" + id +
                    "?limit=1&champData=normalized&api_key=" + championGgApiKey;
            getChampionGg(championInformationDTO, url);
        }
        System.out.println(championInformationDTO.getWinRate().toString());
        return championInformationDTO;
    }

    //RecommendedItemREstOut클래스 세팅.
    public RecommendedItemDTO setRecommendedItemRestOut(String summoerName) {
        RecommendedItemDTO recommendedItemDTO = new RecommendedItemDTO();

        // get current game information by summoerName.
        CurrentMatch currentMatch = riotApiService.getCurrentMatchBySummonerName(summoerName);

        // if the game is not progress
        if (currentMatch == null) recommendedItemDTO.setIsProgress(false);
        else {
            recommendedItemDTO.setIsProgress(true);
            recommendedItemDTO.setChampionName(currentMatch.getMyChampion().getName());
            HashMap<ItemDAO,Double> recedItem = itemAnalysisService.recommendItemCurrentMatch(currentMatch);

            ItemDAO maxItemDAO;
            //recedItem이 빌 때 까지
            while(!recedItem.isEmpty()) {
                maxItemDAO = null;
                //제일 가중치가 높은 것일 maxItemDAO에 저장.
                for (ItemDAO e : recedItem.keySet()) {
                    if (maxItemDAO == null) {
                        maxItemDAO = e;
                    }
                    if (recedItem.get(e) > recedItem.get(maxItemDAO)) {
                        maxItemDAO = e;
                    }
                }
                //가장 추천도가 높은 것 add한다.
                recommendedItemDTO.addItemNames(maxItemDAO.getName());
                //추천된 아이템이 5개가 넘어가면 break한다.
                if (recommendedItemDTO.getRecommendedItems().size()>5) break;
                recedItem.remove(maxItemDAO);
            }
        }
        return recommendedItemDTO;
    }
}