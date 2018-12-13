package koreatech.cse.controller;

import koreatech.cse.domain.rest.ChampionInformationDTO;
import koreatech.cse.domain.rest.MatchInformationDTO;
import koreatech.cse.domain.rest.RecommendedItemDTO;
import koreatech.cse.service.CurrentGameService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

@Controller
@RequestMapping("/currentGame")
public class CurrentGameController {
    // league of legends patch version. Declared in config.properties
    @Value("${riot.version}")
    private String version;

    @Inject
    private CurrentGameService currentGameService;

    // The method that returns the value of rest for the current game
    @Transactional
    @RequestMapping(value="/teamInformation", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<MatchInformationDTO> currentGameInformation(@RequestParam String summonerName) {
        // return information :
        // ally champions, ally champions tag, ally champions stats
        // enemy champions, enemy champions tag, enemy champions stats
        MatchInformationDTO matchInformationDTO = currentGameService.setMatchInfoRestOut(summonerName);
        if (matchInformationDTO.getIsProgress()) {
            System.out.println("ok");
            return new ResponseEntity<MatchInformationDTO>(matchInformationDTO, HttpStatus.OK);
        }

        else {
            System.out.println("\"" + summonerName + "\"소환사 님은 현재 게임 진행 중이 아닙니다.");
            return new ResponseEntity<MatchInformationDTO>(HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    @RequestMapping(value="myChampionInformation", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ChampionInformationDTO> currentGameMyChampion(@RequestParam String summonerName) {
        // return information :
        // my champion name, my champion tag, my champion stat
        // my champion statistics
        ChampionInformationDTO championInformationDTO = currentGameService.setChampionInfoRestOut(summonerName);
        if (championInformationDTO.getIsProgress()) {
            System.out.println("ok");
            return new ResponseEntity<ChampionInformationDTO>(championInformationDTO, HttpStatus.OK);
        }

        else {
            System.out.println("\"" + summonerName + "\"소환사 님은 현재 게임 진행 중이 아닙니다.");
            return new ResponseEntity<ChampionInformationDTO>(HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    @RequestMapping(value="recommendedItem", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<RecommendedItemDTO> currentGameRecItem(@RequestParam String summonerName) {
//        아이템 추천
        RecommendedItemDTO recommendedItemDTO = currentGameService.setRecommendedItemRestOut(summonerName);

        if (recommendedItemDTO.getIsProgress()) {
            System.out.println("ok");
            return new ResponseEntity<RecommendedItemDTO>(recommendedItemDTO, HttpStatus.OK);
        }

        else {
            System.out.println("\"" + summonerName + "\"소환사 님은 현재 게임 진행 중이 아닙니다.");
            return new ResponseEntity<RecommendedItemDTO>(HttpStatus.NOT_FOUND);
        }
    }
}
