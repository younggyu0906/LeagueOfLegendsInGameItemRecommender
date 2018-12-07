package koreatech.cse.controller;

import koreatech.cse.domain.champion.Champions;
import koreatech.cse.domain.champion.Data;
import koreatech.cse.domain.item.Items;
import koreatech.cse.service.StaticDataService;
import org.springframework.beans.factory.annotation.Value;
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
public class LolStaticController {
    @Inject
    private StaticDataService staticDataService;

    // league of legends patch version. Declared in config.properties
    @Value("${riot.version}")
    private String version;

    // Update Champions Information
    @Transactional
    @RequestMapping("/championUpdate")
    public String championStaticLoad(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        // The Data object in the Champion object is a hash map. It contains champion information.
        // The key is the champion name and The value is the champion data.
        try {
            ResponseEntity<Champions> championResponseEntity = restTemplate.getForEntity(
                    "http://ddragon.leagueoflegends.com/cdn/" + version + ".1/data/en_US/champion.json", Champions.class);
            Map<String, Data> championData = championResponseEntity.getBody().getData();

            // Initialize the ChampionDAOS of the staticDataService.
            staticDataService.setChampionDAOS(championData);
            // Insert into DB
            staticDataService.insertChampionDAOS();

            // Send to jsp
            model.addAttribute("champions",staticDataService.getChampionDAOS());

        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        }

        return "lolStaticTest";
    }

    //Item Information Update
    @Transactional
    @RequestMapping("/itemUpdate")
    public String itemStaticLoad(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        // The Data object in the Item object is a hash map. It contains item information.
        // The key is the item ID and The value is the item data.
        try {
            ResponseEntity<Items> itemResponseEntity = restTemplate.getForEntity(
                    "http://ddragon.leagueoflegends.com/cdn/" + version + ".1/data/en_US/item.json", Items.class);
            Map<Integer, koreatech.cse.domain.item.Data> items = itemResponseEntity.getBody().getData();

            // Initialize the ItemDAOS of the staticDataService.
            staticDataService.setItemDAOS(items);
            // insert into DB
            staticDataService.insertItemDAOS();

            // Send to jsp
            model.addAttribute("items",staticDataService.getItemDAOS());

        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        }

        return "lolStaticTest";
    }
}
