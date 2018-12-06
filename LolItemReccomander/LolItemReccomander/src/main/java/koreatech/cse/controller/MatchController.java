package koreatech.cse.controller;


import koreatech.cse.domain.rest.CurrentGameRestOut;
import koreatech.cse.service.ItemAnalysisService;
import koreatech.cse.service.RiotApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.inject.Inject;


@RestController
@RequestMapping("/")
public class MatchController {

    @Inject
    private RiotApiService riotApiService;
    @Inject
    private ItemAnalysisService itemAnalysisService;

    @RequestMapping("/matchList")
    public String matchList(Model model) {
        riotApiService.getMatchList();
        return "lolStaticTest";
    }

    //currentGameTest
    @RequestMapping("/currentGameTest")
    @ResponseBody
    public String currentGameInfo(@RequestParam String summonerName) {
        System.out.println(riotApiService.testPrintCurrentGameInfo(summonerName));
        return riotApiService.testPrintCurrentGameInfo(summonerName);
    }

    //Rest로 값을 내보내는 틀을 만들자.
    @Transactional
    @RequestMapping(value="/currentGame/{summonerName}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<CurrentGameRestOut> CurrentGameRestOut(@PathVariable("summonerName") String summoerName) {

        //currentGameRestOut을 소환사 이름으로 초기화
        CurrentGameRestOut currentGameRestOut = new CurrentGameRestOut();
        currentGameRestOut.setCurrentMatch(riotApiService.getCurrentMatchBySummonerName(summoerName));

        //게임이 진행중이 아니면 currentMatch가 null이니까 notfound보낸다.
        if (currentGameRestOut.getCurrentMatch() == null) {
            System.out.println("현재 게임 진행 중 아님.");
            return new ResponseEntity<CurrentGameRestOut>(HttpStatus.NOT_FOUND);
        }

        //null이 아니면 아이템 빈도수도 확인해서 넣는다.
        currentGameRestOut.setItemFeq(itemAnalysisService.getItemsFromCurrentMatch(currentGameRestOut.getCurrentMatch()));
        //rest로 return
        return new ResponseEntity<CurrentGameRestOut>(currentGameRestOut, HttpStatus.OK);
    }

}
