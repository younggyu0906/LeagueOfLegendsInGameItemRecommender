package koreatech.cse.controller.rest;


import koreatech.cse.service.RiotApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.Map;

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
