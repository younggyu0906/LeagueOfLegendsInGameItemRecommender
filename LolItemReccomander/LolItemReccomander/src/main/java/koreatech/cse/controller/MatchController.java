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

    // currentGameTest
    @RequestMapping("/currentGameTest")
    @ResponseBody
    public String currentGameInfo(@RequestParam String summonerName) {
        System.out.println(riotApiService.testPrintCurrentGameInfo(summonerName));
        return riotApiService.testPrintCurrentGameInfo(summonerName);
    }

    // The method that returns the value of rest for the current game
    @Transactional
    @RequestMapping(value="/currentGame/{summonerName}", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<CurrentGameRestOut> CurrentGameRestOut(@PathVariable("summonerName") String summoerName) {

        // Search current game by summoner name and initialize to currentGameRestOut
        CurrentGameRestOut currentGameRestOut = new CurrentGameRestOut();
        currentGameRestOut.setCurrentMatch(riotApiService.getCurrentMatchBySummonerName(summoerName));

        // If the game is not in progress, currentMach is null. send NOT_FOUND.
        if (currentGameRestOut.getCurrentMatch() == null) {
            System.out.println("현재 게임 진행 중 아님.");
            return new ResponseEntity<CurrentGameRestOut>(HttpStatus.NOT_FOUND);
        }

        // If not null, check the item frequency.
        else {
            currentGameRestOut.setItemFeq(itemAnalysisService.getItemsFromCurrentMatch(currentGameRestOut.getCurrentMatch()));
            // return to rest
            return new ResponseEntity<CurrentGameRestOut>(currentGameRestOut, HttpStatus.OK);
        }
    }
}
