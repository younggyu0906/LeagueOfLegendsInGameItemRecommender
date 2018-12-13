package koreatech.cse.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value="home")
    public String exPage1() {
        return "currentGameExPage";
    }

    //RecommendedItem보여주기 위해 사용
    @RequestMapping(value="requestRecommendedItem")
    public String requestRecommendedItem(HttpServletRequest request) {
        String summonerName = request.getParameter("summonerName");
        System.out.println(summonerName);
        String encodedSummonerName=summonerName;
        try {
            encodedSummonerName = URLEncoder.encode(summonerName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "redirect:/currentGame/recommendedItem?summonerName="+encodedSummonerName;
    }

    //championInformation 위해 사용
    @RequestMapping(value="requestChampionInformation")
    public String requestChampionInformation(HttpServletRequest request) {
        String summonerName = request.getParameter("summonerName");
        System.out.println(summonerName);
        String encodedSummonerName=summonerName;
        try {
            encodedSummonerName = URLEncoder.encode(summonerName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "redirect:/currentGame/championInformation?summonerName="+encodedSummonerName;
    }

    //matchinfo 보여주기 위해 사용
    @RequestMapping(value="requestMatchInfo")
    public String requestMatchInfo(HttpServletRequest request) {
        String summonerName = request.getParameter("summonerName");
        System.out.println(summonerName);
        String encodedSummonerName=summonerName;
        try {
            encodedSummonerName = URLEncoder.encode(summonerName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "redirect:/currentGame/matchInformation?summonerName="+encodedSummonerName;
    }

    @RequestMapping
    public String home() {
        return "redirect:document";
    }

    @RequestMapping("/document")
    public String document() {
        return "document";
    }
}
