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
    private ArrayList<ChampionDAO> championDAOS = new ArrayList<>();

    @Inject
    private ItemMapper itemMapper;
    private ArrayList<ItemDAO> itemDAOS = new ArrayList<>();    //DB에 업로드 하기 전 itemDAO들이 저장될 리스트.

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
    public List<FinishedMatch> getFinishedMatches(int championId){
        List<FinishedMatch> finishedMatches = finishedMatchMapper.findFinishedMatchByChampionId(championId);
//        System.out.println(finishedMatches);
        return finishedMatches;
    }
}
