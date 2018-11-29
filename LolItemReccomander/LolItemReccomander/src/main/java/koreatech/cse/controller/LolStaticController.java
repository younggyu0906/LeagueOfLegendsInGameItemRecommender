package koreatech.cse.controller;

import koreatech.cse.domain.champion.Champions;
import koreatech.cse.domain.champion.Data;
import koreatech.cse.domain.item.Items;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
@RequestMapping("/")
public class LolStaticController {

    @RequestMapping("/Champion")
    public String championStaticLoad(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        //Champions 안에  Map<String, Data> 안에 챔피언 정보가 담겨서 온다.
        //키값은 Champion의 이름이다.
        try {
            ResponseEntity<Champions> championResponseEntity = restTemplate.getForEntity(
                    "http://ddragon.leagueoflegends.com/cdn/6.24.1/data/en_US/champion.json", Champions.class);
            Map<String, Data> champions = championResponseEntity.getBody().getData();
            model.addAttribute("champions",champions);

            System.out.println(champions.entrySet());

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