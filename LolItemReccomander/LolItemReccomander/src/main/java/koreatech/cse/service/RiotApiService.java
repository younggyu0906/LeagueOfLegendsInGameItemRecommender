package koreatech.cse.service;

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
import org.omg.CORBA.Current;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;

//라이엇 게임즈 api사용하여 끝난 게임 저장.
@Service
public class RiotApiService {
    @Inject
    private FinishedMatchMapper finishedMatchMapper;

//    //config파일에서 가져온 api키
//    @Value("${riot.apikey}")
//    private String apiKey;

    private ApiConfig config = new ApiConfig().setKey("RGAPI-3209559f-3607-400a-9fc6-4539b9d02435");
    private RiotApi api = new RiotApi(config);

    public void getMatchList() {

        //매치 검색의 대상이 될 소환사 이름들
        ArrayList<String> summonerName = new ArrayList<>();
        summonerName.add("hide on bush");

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
                            finishedMatch.setChampionId(thisMatch.getParticipants().get(i).getChampionId());
                            finishedMatch.setItem0Id(thisMatch.getParticipants().get(i).getStats().getItem0());
                            finishedMatch.setItem1Id(thisMatch.getParticipants().get(i).getStats().getItem1());
                            finishedMatch.setItem2Id(thisMatch.getParticipants().get(i).getStats().getItem2());
                            finishedMatch.setItem3Id(thisMatch.getParticipants().get(i).getStats().getItem3());
                            finishedMatch.setItem4Id(thisMatch.getParticipants().get(i).getStats().getItem4());
                            finishedMatch.setItem5Id(thisMatch.getParticipants().get(i).getStats().getItem5());
                            finishedMatch.setItem6Id(thisMatch.getParticipants().get(i).getStats().getItem6());

//                            finishedMatch.setChampionId(1);
//                            finishedMatch.setItem0Id(0);
//                            finishedMatch.setItem1Id(0);
//                            finishedMatch.setItem2Id(0);
//                            finishedMatch.setItem3Id(0);
//                            finishedMatch.setItem4Id(0);
//                            finishedMatch.setItem5Id(0);
//                            finishedMatch.setItem6Id(0);

                            System.out.println(finishedMatch);

                            //DB에 업로드하는 코드.
                            finishedMatchMapper.insert(finishedMatch);
                        }
                    }
                }
            } catch (RiotApiException e1) {
                e1.printStackTrace();
            }
        });
    }

//사용자 이름을 통해 CurrentGameInfo 가져오는 함수.
    public CurrentGameInfo findCurrentGameInfoBySummonerName(String summonerName) {
        Summoner summoner = null;
        CurrentGameInfo currentGameInfo = null;
        try {
            summoner = api.getSummonerByName(Platform.KR,summonerName);
            System.out.println(summoner);
            //여기서 진행중이 아니면 오류 발생 체크할것
            currentGameInfo = api.getActiveGameBySummoner(Platform.KR,summoner.getId());
            System.out.println(currentGameInfo);
        } catch (RiotApiException e) {
            e.printStackTrace();
        }
        return currentGameInfo;
    }
    //currentGameInfo 테스트~~
    public String testPrintCurrentGameInfo (String summonerName) {
        CurrentGameInfo currentGameInfo = findCurrentGameInfoBySummonerName(summonerName);
        return currentGameInfo.getPlatformId() +
                currentGameInfo.getParticipants().toString();
    }
}
