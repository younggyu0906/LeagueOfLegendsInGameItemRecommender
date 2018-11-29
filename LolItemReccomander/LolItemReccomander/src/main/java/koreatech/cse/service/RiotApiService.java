package koreatech.cse.service;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.match.dto.MatchList;
import net.rithms.riot.api.endpoints.match.dto.MatchReference;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;
import org.springframework.stereotype.Service;

@Service
public class RiotApiService {

    public void getMatchList() {
        ApiConfig config = new ApiConfig().setKey("RGAPI-7d329056-bb35-4c5f-b6bd-aafe27f5a25a");
        RiotApi api = new RiotApi(config);

        MatchList matchList = null;

        try {
            // First we need to request the summoner because we will need it's account ID
            Summoner summoner = api.getSummonerByName(Platform.KR, "작은염소");

            // Then we can use the account ID to request the summoner's match list
            matchList = api.getMatchListByAccountId(Platform.NA, summoner.getAccountId());
        } catch (RiotApiException e) {
            e.printStackTrace();
        }

        System.out.println("Total Games in requested match list: " + matchList.getTotalGames());

        // We can now iterate over the match list to access the data
        if (matchList.getMatches() != null) {
            for (MatchReference match : matchList.getMatches()) {
                System.out.println("GameID: " + match.getGameId());
            }
        }
    }

}
