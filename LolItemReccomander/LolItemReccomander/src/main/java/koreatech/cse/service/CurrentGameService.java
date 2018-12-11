package koreatech.cse.service;

import koreatech.cse.domain.championInfo.ChampionInfo;
import koreatech.cse.domain.rest.RestOutMatch;
import org.springframework.stereotype.Service;

@Service
public class CurrentGameService {

    public RestOutMatch setRestOutMatch(String summoerName) {
        RestOutMatch restOutMatch = new RestOutMatch();


        return  null;
    }
}

    // Search current game by summoner name and initialize to currentGameRestOut
    CurrentGameRestOut currentGameRestOut = new CurrentGameRestOut();
    currentGameRestOut.setCurrentMatch(riotApiService.getCurrentMatchBySummonerName(summoerName));

            // If the game is not in progress, currentMach is null. send NOT_FOUND.
            if (currentGameRestOut.getCurrentMatch() == null) {
            System.out.println("현재 게임 진행 중 아님.");
            return new ResponseEntity<CurrentGameRestOut>(HttpStatus.NOT_FOUND);
    }

    // If not null, check the item frequency.
    else {
    currentGameRestOut.setItemFeq(itemAnalysisService.getItemsFromCurrentMatch(currentGameRestOut.getCurrentMatch()));
    // return to rest
    return new ResponseEntity<CurrentGameRestOut>(currentGameRestOut, HttpStatus.OK);
    }