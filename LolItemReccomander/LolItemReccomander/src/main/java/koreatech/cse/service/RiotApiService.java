package koreatech.cse.service;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.match.dto.Match;
import net.rithms.riot.api.endpoints.match.dto.MatchList;
import net.rithms.riot.api.endpoints.match.dto.MatchReference;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
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
                summoner = api.getSummonerByName(Platform.KR, e);
                MatchList matchList = api.getMatchListByAccountId(Platform.KR, summoner.getAccountId());

                if (matchList.getMatches() != null) {
                    for (MatchReference match : matchList.getMatches()) {
                        Match thisMatch = api.getMatch(Platform.KR,match.getGameId());
                        System.out.println(thisMatch.getParticipants().get(1).getStats().getItem0());
                    }
                }
            } catch (RiotApiException e1) {
                e1.printStackTrace();
            }
        });

    }

}
