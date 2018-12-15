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
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
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

    @Value("${riot.apikey.yg}")
    private String apiKeyYG;

    @Value("${riot.version}")
    private String version;

    //api 전역변수
    //또 자동으로 매치 정보 넣을거라서 그것도 전역변수로 해보자 하나의 매치 정보를 일단 가져와야 함.
    private ApiConfig config = null;
    private RiotApi apiYG = null;

    //스프링 시작 시 자동으로 실행되는 초기화 함수
    //여기서 api키 초기화 및 매치 정보를 하나 가져온다.
    @PostConstruct
    public void init() {
        config = new ApiConfig().setKey(apiKeyYG);
        apiYG = new RiotApi(config);
        System.out.println("init RiotApiService");
    }


    //get Match data and input DB
    @Transactional
    public void getMatchList() {

        //매치 검색의 대상이 될 소환사 이름들
        ArrayList<String> summonerName = new ArrayList<>();
        summonerName.add("망고링고망");

        summonerName.stream().forEach(e->{
            Summoner summoner = null;
            try {
                // Get information to the summoner name.
                summoner = apiYG.getSummonerByName(Platform.KR, e);
                // Get match list
                MatchList matchList = apiYG.getMatchListByAccountId(Platform.KR, summoner.getAccountId());

                // Variable to be used in for loop.
                // if MatchList is not null, get match and insert into DB.
                if (matchList.getMatches() != null) {
                    for (MatchReference match : matchList.getMatches()) {
                        insertFinishedMatch(apiYG.getMatch(Platform.KR,match.getGameId()));
                    }
                }
            } catch (RiotApiException e1) {
                e1.printStackTrace();
            }
        });
    }

    //match를 finishedMatch로 초기화 후 DB에 넣는 함수를 따로 뺌.
    public void insertFinishedMatch(Match match) {
        FinishedMatch finishedMatch = new FinishedMatch();
        // Save items for 10 Summoners to DB.
        for(int i = 0 ; i < 10 ; i++){
            // Only save match information for game version 8.24 because of the foreign key.
            if(match.getGameVersion().contains(version)) {
                finishedMatch.setChampionId(match.getParticipants().get(i).getChampionId());
                finishedMatch.setItem0Id(match.getParticipants().get(i).getStats().getItem0());
                finishedMatch.setItem1Id(match.getParticipants().get(i).getStats().getItem1());
                finishedMatch.setItem2Id(match.getParticipants().get(i).getStats().getItem2());
                finishedMatch.setItem3Id(match.getParticipants().get(i).getStats().getItem3());
                finishedMatch.setItem4Id(match.getParticipants().get(i).getStats().getItem4());
                finishedMatch.setItem5Id(match.getParticipants().get(i).getStats().getItem5());
                finishedMatch.setItem6Id(match.getParticipants().get(i).getStats().getItem6());

                System.out.println(finishedMatch);
                // insert into DB.
                finishedMatchMapper.insert(finishedMatch);
            }
        }
    }

    //특정 matchId를 가져온다.
    public Long getOneMatchId() {

        //게임 아이디 하나 랜덤하게 가져온다 이말이야.
        try {
            Summoner summoner = apiYG.getSummonerByName(Platform.KR,"망고링고망");
            MatchList matchList = apiYG.getMatchListByAccountId(Platform.KR, summoner.getAccountId());
            if (matchList.getMatches() != null) {
                MatchReference match = matchList.getMatches().get(1);
                return match.getGameId();
            }

        } catch (RiotApiException e) {
            e.printStackTrace();
        }
        return null;
    }


    // Get the current game information to the summoner name.
    private CurrentGameInfo findCurrentGameInfoBySummonerName(String summonerName) {

        Summoner summoner;
        CurrentGameInfo currentGameInfo = null;
        try {
            summoner = apiYG.getSummonerByName(Platform.KR,summonerName);
            System.out.println(summoner);
            // 여기서 진행중이 아니면 오류 발생 체크할것
            currentGameInfo = apiYG.getActiveGameBySummoner(Platform.KR,summoner.getId());

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
