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

//라이엇 게임즈 api사용하여 끝난 게임 저장.
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
                //소환사 이름으로 정보를 가져옴
                summoner = api.getSummonerByName(Platform.KR, e);
                //매치 리스트를 가져옴
                MatchList matchList = api.getMatchListByAccountId(Platform.KR, summoner.getAccountId());

                //아래 for문에서 사용될 변수들.
                Match thisMatch = null;
                FinishedMatch finishedMatch = new FinishedMatch();

                //matchlist가 null이 아니면 매치들을 가져와서 DB에 저장
                if (matchList.getMatches() != null) {
                    for (MatchReference match : matchList.getMatches()) {
                        thisMatch = api.getMatch(Platform.KR,match.getGameId());
                        //소환사 10명에 대한 아이템들을 DB에 저장한다.
                        for(int i = 0 ; i < 10 ; i++){
                            //게임 버전이 8.24이었던 게임만 DB에 추가한다.(버전 때문에 왜래 키 걸림)
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

                                //DB에 업로드하는 코드.
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

//사용자 이름을 통해 CurrentGameInfo 가져오는 함수.
    private CurrentGameInfo findCurrentGameInfoBySummonerName(String summonerName) {
        ApiConfig config = new ApiConfig().setKey(apiKeyYG);
        RiotApi api = new RiotApi(config);

        Summoner summoner = null;
        CurrentGameInfo currentGameInfo = null;
        try {
            summoner = api.getSummonerByName(Platform.KR,summonerName);
            System.out.println(summoner);
            //여기서 진행중이 아니면 오류 발생 체크할것
            currentGameInfo = api.getActiveGameBySummoner(Platform.KR,summoner.getId());

        } catch (RiotApiException e) {
            e.printStackTrace();
        }
        //만약 게임중이 아니라면 null이 반환되어요
        return currentGameInfo;
    }
    //currentGame을 받아 와서 새로운 CurrentGame정보를 세팅하는 함수.

    public CurrentMatch getCurrentMatchBySummonerName(String summonerName) {
        //summonerName으로 일단 currentGameInfo받아옴.
        CurrentGameInfo currentGameInfo = findCurrentGameInfoBySummonerName(summonerName);
        //null이면 현재 게임 진행중이 아님.
        if(currentGameInfo == null) return null;

        CurrentMatch currentMatch = new CurrentMatch();

        //이름 세팅
        currentMatch.setSummonerName(summonerName);

        //전체 참여 정보를 삭 훑어본 후 소환사 이름이 현재 내 사용자라면 내 챔피언에 추가.
        currentGameInfo.getParticipants().stream().forEach(e->{
            if (e.getSummonerName().equals(summonerName)) {
                currentMatch.setMyChampion(daoService.getChampionDAO(e.getChampionId()));
                currentMatch.setMyTeamId(e.getTeamId());
            }
        });

        currentGameInfo.getParticipants().stream().forEach(e->{
            //팀 아이디가 내 팀 아이디와 같으면 아군
            if (e.getTeamId() == currentMatch.getMyTeamId()) {
                currentMatch.addTeamChampions(daoService.getChampionDAO(e.getChampionId()));
            }
            //아니면 적군
            else {
                currentMatch.addEnemyChampions(daoService.getChampionDAO(e.getChampionId()));
            }
        });

        return currentMatch;
    }

    //currentGameInfo 테스트~~
    public String testPrintCurrentGameInfo (String summonerName) {
        itemAnalysisService.getItemsFromCurrentMatch(getCurrentMatchBySummonerName(summonerName));
        return "DONE";
    }
}
