package koreatech.cse.service;

import koreatech.cse.domain.match.FinishedMatch;
import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.match.dto.Match;
import net.rithms.riot.api.endpoints.match.dto.MatchList;
import net.rithms.riot.api.endpoints.match.dto.MatchReference;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

//라이엇 게임즈 api사용하여 끝난 게임 저장.
@Service
public class RiotApiService {

    public void getMatchList() {
        //API키
        ApiConfig config = new ApiConfig().setKey("RGAPI-7d329056-bb35-4c5f-b6bd-aafe27f5a25a");
        RiotApi api = new RiotApi(config);

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

                            System.out.println(finishedMatch);

                            //DB에 업로드하는 코드.

                        }

                    }
                }
            } catch (RiotApiException e1) {
                e1.printStackTrace();
            }
        });

    }

}
