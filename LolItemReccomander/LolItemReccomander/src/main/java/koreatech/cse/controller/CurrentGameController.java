package koreatech.cse.controller;

import koreatech.cse.domain.rest.ChampionInfoRestOut;
import koreatech.cse.domain.rest.CurrentGameRestOut;
import koreatech.cse.domain.rest.MatchInfoRestOut;
import koreatech.cse.service.CurrentGameService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
@RequestMapping("/currentGame")
public class CurrentGameController {
    // league of legends patch version. Declared in config.properties
    @Value("${riot.version}")
    private String version;

    @Inject
    private CurrentGameService currentGameService;

    // The method that returns the value of rest for the current game
    @Transactional
    @RequestMapping(value="/information/{summonerName}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<MatchInfoRestOut> currentGameInformation(@PathVariable("summonerName") String summoerName) {
        // return information :
        // ally champions, ally champions tag, ally champions stats
        // enemy champions, enemy champions tag, enemy champions stats
        MatchInfoRestOut matchInfoRestOut = currentGameService.setMatchInfoRestOut(summoerName);
        if (matchInfoRestOut.getIsProgress()) {
            System.out.println("ok");
            return new ResponseEntity<MatchInfoRestOut>(matchInfoRestOut, HttpStatus.OK);
        }

        else {
            System.out.println("\"" + summoerName + "\"소환사 님은 현재 게임 진행 중이 아닙니다.");
            return new ResponseEntity<MatchInfoRestOut>(HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    @RequestMapping(value="statistics/{summonerName}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ChampionInfoRestOut> CurrentGameStatistics(@PathVariable("summonerName") String summoerName) {
        // return information :
        // my champion name, my champion tag, my champion stat
        // my champion statistics
        ChampionInfoRestOut championInfoRestOut = currentGameService.setChampionInfoRestOut(summoerName);
        if (championInfoRestOut.getIsProgress()) {
            System.out.println("ok");
            return new ResponseEntity<ChampionInfoRestOut>(championInfoRestOut, HttpStatus.OK);
        }

        else {
            System.out.println("\"" + summoerName + "\"소환사 님은 현재 게임 진행 중이 아닙니다.");
            return new ResponseEntity<ChampionInfoRestOut>(HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    @RequestMapping(value="ItemRecommendation/{summonerName}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<CurrentGameRestOut> CurrentGameItemRec(@PathVariable("summonerName") String summoerName) {
//        아이템 추천
        return null;
    }
}
