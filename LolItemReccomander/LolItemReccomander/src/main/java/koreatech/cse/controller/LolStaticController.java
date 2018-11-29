package koreatech.cse.controller;

import koreatech.cse.domain.champion.Champions;
import koreatech.cse.domain.champion.Data;
import koreatech.cse.domain.item.Items;
import koreatech.cse.domain.staticData.ChampionDAO;
import koreatech.cse.service.StaticDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;

@Controller
@RequestMapping("/")
public class LolStaticController {
    @Inject
    private StaticDataService staticDataService;

    @Transactional
    @RequestMapping("/championUpdate")
    public String championStaticLoad(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        //Champions 안에  Map<String, Data> 안에 챔피언 정보가 담겨서 온다.
        //키값은 Champion의 이름이다.
        try {
            ResponseEntity<Champions> championResponseEntity = restTemplate.getForEntity(
                    "http://ddragon.leagueoflegends.com/cdn/6.24.1/data/en_US/champion.json", Champions.class);
            Map<String, Data> champions = championResponseEntity.getBody().getData();

            staticDataService.setChampionDAOS(champions);

            model.addAttribute("champions",staticDataService.getChampionDAOS());

        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        }

        return "lolStaticTest";
    }

    @RequestMapping("/Item")
    public String itemStaticLoad(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        //Items 안에  Map<Integer, Data> 안에 아이템 정보가 담겨서 온다.
        //키값은 Item code.
        try {
            ResponseEntity<Items> itemResponseEntity = restTemplate.getForEntity(
                    "http://ddragon.leagueoflegends.com/cdn/6.24.1/data/en_US/item.json", Items.class);
            Map<Integer, koreatech.cse.domain.item.Data> items = itemResponseEntity.getBody().getData();
            model.addAttribute("items",items);

            System.out.println(items.entrySet());

        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        }

        return "lolStaticTest";
    }

}
