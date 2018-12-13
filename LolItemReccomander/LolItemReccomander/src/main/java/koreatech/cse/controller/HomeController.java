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

    @ModelAttribute("name")
    private String getName() {
        return "IamHomeControllerModelAttribute";
    }

    @RequestMapping
    public String home() {
        return "hello";
    }

    @RequestMapping("/jstlTest")
    public String emptyTest(Model model) {
        String a = null;
        String b = "";
        String c = "hello";
        List<String> d = new ArrayList<String>();
        List<String> e = new ArrayList<String>();
        e.add(a);
        e.add(b);

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("c", c);
        model.addAttribute("d", d);
        model.addAttribute("e", e);

        List<String> stringArray = new ArrayList<String>();
        stringArray.add("one");
        stringArray.add("two");
        stringArray.add("three");
        model.addAttribute("stringArray", stringArray);

        Map<Integer, String> stringMap = new HashMap<Integer, String>();
        stringMap.put(1, "one");
        stringMap.put(2, "two");
        stringMap.put(3, "three");
        model.addAttribute("stringMap", stringMap);

        return "jstlTest";
    }

    @RequestMapping("/document")
    public String document() {
        return "document";
    }
}
