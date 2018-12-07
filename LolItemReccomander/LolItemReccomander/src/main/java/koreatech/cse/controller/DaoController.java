package koreatech.cse.controller;


import koreatech.cse.domain.championInfo.ChampionInfo;
import koreatech.cse.service.DaoService;
import koreatech.cse.service.NormalizedService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;


@Controller
@RequestMapping("/")
public class DaoController {

    @Value("${champion.gg.apikey}")
    private String apikey;

    @Inject
    private DaoService daoService;

    @Value("${riot.version}")
    private String version;

    @Inject
    private NormalizedService normalizedService;

    @Transactional
    @RequestMapping(value = "/getChampion", method = RequestMethod.GET)
    public String getChampion(Model model, @RequestParam(required = false) String id) {
        daoService.getChampionDAO(Integer.parseInt(id));
        return "lolStaticTest"; // 수정하도록!!***************************************
    }

    @Transactional
    @RequestMapping(value = "/getItem", method = RequestMethod.GET)
    public String getItem(Model model, @RequestParam(required = false) String id) {
        daoService.getItemDAO(Integer.parseInt(id));
        return "lolStaticTest"; // 수정하도록!!***************************************
    }

    @RequestMapping(value = "/normalized", method = RequestMethod.GET)
    public String normalized(Model model, @RequestParam(required = false) String id, @RequestParam(required = false) String elo) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<ChampionInfo[]> championNormalizedResponseEntity = restTemplate.getForEntity(
                    "http://api.champion.gg/v2/champions/" + id + "?elo=" + elo + "&limit=1&champData=normalized&api_key=" + apikey,
                    ChampionInfo[].class
            );
            ChampionInfo[] championInfo = championNormalizedResponseEntity.getBody();

            normalizedService.getNormalizedInfo(id, elo, championInfo[0]);  // service???

        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        }

        return "lolStaticTest"; // 수정하도록!!***************************************
    }
}
