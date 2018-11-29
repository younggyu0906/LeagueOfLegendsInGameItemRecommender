package koreatech.cse.controller;


import koreatech.cse.service.RiotApiService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


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


}
