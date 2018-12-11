package koreatech.cse.service;

import koreatech.cse.domain.match.CurrentMatch;
import koreatech.cse.domain.rest.RestOutMatch;
import koreatech.cse.domain.staticData.ChampionDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CurrentGameService {

    // 챔피언정보를 해쉬맵에 넣는 함수, 중복
    private HashMap<String, ArrayList<String>> IntoHashMap(ChampionDAO championDAO) {
        HashMap<String, ArrayList<String>> championInfo = new HashMap<>();
        ArrayList<String> stats = new ArrayList<>();

        if (championDAO.isAssassin()) stats.add("Assassin");
        if (championDAO.isFighter()) stats.add("Fighter");
        if (championDAO.isMage()) stats.add("Mage");
        if (championDAO.isMarksman()) stats.add("Marksman");
        if (championDAO.isSupport()) stats.add("Support");
        if (championDAO.isTank()) stats.add("Tank");

        championInfo.put(championDAO.getName(), stats);
        return championInfo;
    }

    // return to json
    public RestOutMatch setRestOutMatch(String summoerName) {
        RiotApiService riotApiService = new RiotApiService();
        RestOutMatch restOutMatch = new RestOutMatch();
        CurrentMatch currentMatch = new CurrentMatch();

        ArrayList<ChampionDAO> championDAOS;

        System.out.println(summoerName + 1);
        currentMatch = riotApiService.getCurrentMatchBySummonerName(summoerName);
        System.out.println(summoerName + 2);
        if (currentMatch == null) restOutMatch.setProgress(false);

        else {
            restOutMatch.setProgress(true);

            championDAOS = currentMatch.getTeamChampions();
            championDAOS.stream().forEach(e -> {
                restOutMatch.addAllyChampions(IntoHashMap(e));
                restOutMatch.addAndPutAllyStats("attack", e.getAttack());
                restOutMatch.addAndPutAllyStats("defense", e.getDefense());
                restOutMatch.addAndPutAllyStats("magic", e.getMagic());
            });

            championDAOS = currentMatch.getEnemyChampions();
            championDAOS.stream().forEach(e -> {
                restOutMatch.addEnemyChmapions(IntoHashMap(e));
                restOutMatch.addAndPutEnemyStats("attack", e.getAttack());
                restOutMatch.addAndPutEnemyStats("defense", e.getDefense());
                restOutMatch.addAndPutEnemyStats("magic", e.getMagic());
            });
        }
        return restOutMatch;
    }
}