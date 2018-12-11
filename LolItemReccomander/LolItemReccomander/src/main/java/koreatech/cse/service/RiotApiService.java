package koreatech.cse.service;

import koreatech.cse.domain.match.CurrentMatch;
import koreatech.cse.domain.match.FinishedMatch;
import koreatech.cse.repository.FinishedMatchMapper;
import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.match.dto.Match;
import net.rithms.riot.api.endpoints.match.dto.MatchList;
import net.rithms.riot.api.endpoints.match.dto.MatchReference;
import net.rithms.riot.api.endpoints.spectator.dto.CurrentGameInfo;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;

// Save finished game information using riot api
@Service
public class RiotApiService {
    @Inject
    private FinishedMatchMapper finishedMatchMapper;
    @Inject
    private DaoService daoService;
    @Inject
    private ItemAnalysisService itemAnalysisService;

    // api key
    @Value("${riot.apikey.jy}")
    private String apiKeyJY;

    @Value("${riot.apikey.yg}")
    private String apiKeyYG;

    @Value("${riot.version}")
    private String version;

//    //기존 방식
//    private ApiConfig config = new ApiConfig().setKey("RGAPI-6228d5ab-afc0-449f-a1ab-3cd1085cb96c");
//    private RiotApi api = new RiotApi(config);

    @Transactional
    public void getMatchList() {
        ApiConfig config = new ApiConfig().setKey(apiKeyJY);
        RiotApi api = new RiotApi(config);

        //매치 검색의 대상이 될 소환사 이름들
        ArrayList<String> summonerName = new ArrayList<>();
        summonerName.add("망고링고망");

        summonerName.stream().forEach(e->{
            Summoner summoner = null;
            try {
                // Get information to the summoner name.
                summoner = api.getSummonerByName(Platform.KR, e);
                // Get match list
                MatchList matchList = api.getMatchListByAccountId(Platform.KR, summoner.getAccountId());

                // Variable to be used in for loop.
                Match thisMatch = null;
                FinishedMatch finishedMatch = new FinishedMatch();

                // if MatchList is not null, get match and insert into DB.
                if (matchList.getMatches() != null) {
                    for (MatchReference match : matchList.getMatches()) {
                        thisMatch = api.getMatch(Platform.KR,match.getGameId());
                        // Save items for 10 Summoners to DB.
                        for(int i = 0 ; i < 10 ; i++){
                            // Only save match information for game version 8.24 because of the foreign key.
                            if(thisMatch.getGameVersion().contains(version)) {
                                finishedMatch.setChampionId(thisMatch.getParticipants().get(i).getChampionId());
                                finishedMatch.setItem0Id(thisMatch.getParticipants().get(i).getStats().getItem0());
                                finishedMatch.setItem1Id(thisMatch.getParticipants().get(i).getStats().getItem1());
                                finishedMatch.setItem2Id(thisMatch.getParticipants().get(i).getStats().getItem2());
                                finishedMatch.setItem3Id(thisMatch.getParticipants().get(i).getStats().getItem3());
                                finishedMatch.setItem4Id(thisMatch.getParticipants().get(i).getStats().getItem4());
                                finishedMatch.setItem5Id(thisMatch.getParticipants().get(i).getStats().getItem5());
                                finishedMatch.setItem6Id(thisMatch.getParticipants().get(i).getStats().getItem6());

//                                System.out.println(finishedMatch);

                                // insert into DB.
                                finishedMatchMapper.insert(finishedMatch);
                            }
                        }
                    }
                }
            } catch (RiotApiException e1) {
                e1.printStackTrace();
            }
        });
    }


    // Get the current game information to the summoner name.
    public CurrentGameInfo findCurrentGameInfoBySummonerName(String summonerName) {

        ApiConfig config = new ApiConfig().setKey(apiKeyYG);
        RiotApi api = new RiotApi(config);

        Summoner summoner = null;
        CurrentGameInfo currentGameInfo = null;
        try {
            summoner = api.getSummonerByName(Platform.KR,summonerName);
            System.out.println(summoner);
            // 여기서 진행중이 아니면 오류 발생 체크할것
            currentGameInfo = api.getActiveGameBySummoner(Platform.KR,summoner.getId());

        } catch (RiotApiException e) {
            e.printStackTrace();
        }
        // If the game is not progress, return null.
        return currentGameInfo;
    }

    // The current game information received from api is processed with necessary information only.
    // class 이름 변경?? CurrentMatch? CurrentGameInfo? 헷갈려요ㅠ
//    -> currentGameInfo는 riotApi자체에 소속된 것입니다. currentMatch는 우리가 만든것입니다.
    public CurrentMatch getCurrentMatchBySummonerName(String summonerName) {
        // Get currentGameInfo with summonerName.
        CurrentGameInfo currentGameInfo = findCurrentGameInfoBySummonerName(summonerName);
        // If null, the game is not in progress.
        if(currentGameInfo == null) return null;

        CurrentMatch currentMatch = new CurrentMatch();

        // set summoner name
        currentMatch.setSummonerName(summonerName);

        // If the summoner name is my name, add it to my champion.
        currentGameInfo.getParticipants().stream().forEach(e->{
            if (e.getSummonerName().equals(summonerName)) {
                currentMatch.setMyChampion(daoService.getChampionDAO(e.getChampionId()));
                currentMatch.setMyTeamId(e.getTeamId());
            }
        });

        currentGameInfo.getParticipants().stream().forEach(e->{
            // If the participant's team ID and my team ID are the same, it is a ally.
            if (e.getTeamId() == currentMatch.getMyTeamId()) {
                currentMatch.addTeamChampions(daoService.getChampionDAO(e.getChampionId()));
            }
            // else enemy
            else {
                currentMatch.addEnemyChampions(daoService.getChampionDAO(e.getChampionId()));
            }
        });

        return currentMatch;
    }

    // currentGameInfo test
    public String testPrintCurrentGameInfo (String summonerName) {
        itemAnalysisService.getItemsFromCurrentMatch(getCurrentMatchBySummonerName(summonerName));
        return "DONE";
    }
}
