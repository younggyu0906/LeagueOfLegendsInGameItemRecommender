package koreatech.cse.service;

import koreatech.cse.domain.championInfo.ChampionInfo;
import org.springframework.stereotype.Service;

@Service
public class NormalizedService {

    public void getNormalizedInfo(String id, String elo, ChampionInfo championInfo) {
        System.out.println("championId:" + id + ", elo:" + elo +
                ", winRate:" + Double.toString(championInfo.getWinRate()) +
                ", playRate:" + Double.toString(championInfo.getPlayRate()) +
                ", banRate:" + Double.toString(championInfo.getBanRate())
        );
    }
}