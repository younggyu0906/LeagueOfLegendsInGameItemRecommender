package koreatech.cse.service;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.match.dto.Match;
import net.rithms.riot.constant.Platform;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

//일정 시간마다 실행되야할 코드들.
// enableSheduling -> 일정 시간마다 실행되는 스케쥴 사용을 위한 어노테이션
@EnableScheduling
@Service
public class ScheduledService {

    @Inject
    private RiotApiService riotApiService;

    // api key
    @Value("${riot.apikey.jy}")
    private String apiKeyJY;

    private Long matchId = null;
    private ApiConfig config = null;
    private RiotApi apiJY = null;

    @PostConstruct
    public void init() {
        config = new ApiConfig().setKey(apiKeyJY);
        matchId = riotApiService.getOneMatchId();
        apiJY = new RiotApi(config);
        System.out.println("init scheduledService");
    }

    //일정 초 마다 일정 주기로 실행되는 함수. (DB에 데이터 넣기)
    @Scheduled(fixedDelay = 60*(1000))
    private void getFinishedMatch() {
        try {
            //riotApiService의 matchId로 매치 정보를 가져온 후 끝나면 1 증가.
            Match match = apiJY.getMatch(Platform.KR,matchId++);
            riotApiService.insertFinishedMatch(match);
        } catch (RiotApiException e) {
            e.printStackTrace();
        }
    }

}
