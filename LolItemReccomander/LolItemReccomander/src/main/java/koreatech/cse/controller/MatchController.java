package koreatech.cse.controller;


import koreatech.cse.service.RiotApiService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.inject.Inject;


@Controller
@RequestMapping("/")
public class MatchController {

    @Inject
    private RiotApiService riotApiService;

    @Transactional
    @RequestMapping("/matchList")
    public String matchList(Model model) {
        riotApiService.getMatchList();
        return "lolStaticTest";
    }

    //currentGameTest
    @RequestMapping("/currentGameTest")
    @ResponseBody
    public String currentGameInfo(@RequestParam String summonerName) {
        return riotApiService.testPrintCurrentGameInfo(summonerName);
    }
}
