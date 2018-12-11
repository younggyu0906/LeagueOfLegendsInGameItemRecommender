package koreatech.cse.service;

import koreatech.cse.domain.match.FinishedMatch;
import koreatech.cse.domain.staticData.ChampionDAO;
import koreatech.cse.domain.staticData.ItemDAO;
import koreatech.cse.repository.ChampionMapper;
import koreatech.cse.repository.FinishedMatchMapper;
import koreatech.cse.repository.ItemMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class DaoService {

    @Inject
    private ChampionMapper championMapper;

    @Inject
    private ItemMapper itemMapper;

    @Inject
    private FinishedMatchMapper finishedMatchMapper;

    public ChampionDAO getChampionDAO(int id) {
        ChampionDAO championDAO = championMapper.findChampionById(id);
        System.out.println("get champion:" + championDAO);
        return championDAO;
    }

    public ItemDAO getItemDAO(int id) {
        ItemDAO itemDAO = itemMapper.findItemById(id);
        System.out.println("get item:" + itemDAO);
        return itemDAO;
    }

    //finishedMatch를 챔피언 아이디로 검색해서 리스트로 가져오는 함수.
    public ArrayList<FinishedMatch> getFinishedMatches(int championId){
        ArrayList<FinishedMatch> finishedMatches = finishedMatchMapper.findFinishedMatchByChampionId(championId);
//        System.out.println(finishedMatches);
        return finishedMatches;
    }
}
