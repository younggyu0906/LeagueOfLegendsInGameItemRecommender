package koreatech.cse.service;

import koreatech.cse.domain.champion.Data;
import koreatech.cse.domain.staticData.ChampionDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class StaticDataService {
    private ArrayList<ChampionDAO> championDAOS = new ArrayList<>();

    public ArrayList<ChampionDAO> getChampionDAOS() {
        return championDAOS;
    }

    public void setChampionDAOS( Map<String, Data> champions) {
        //초기화
        championDAOS.clear();
        //stream을 통해 반복하면서 championDAO설정 후 DAOS에 반복하여 넣는다.
        champions.entrySet().stream()
                .forEach(e-> {
                    //저장할 DAO하나 생성
                    ChampionDAO championDAO = new ChampionDAO();
                    championDAO.setName(e.getValue().getName());
                    championDAO.setId(e.getValue().getKey());
                    //Tags .3항연산. Tags에 해당 문자열이 포함되면 boolean true 세팅
                    championDAO.setMage(e.getValue().getTags().contains("Mage") ? true : false);
                    championDAO.setAssassin(e.getValue().getTags().contains("Assassin") ? true : false);
                    championDAO.setFighter(e.getValue().getTags().contains("Fighter") ? true : false);
                    championDAO.setMarksman(e.getValue().getTags().contains("Marksman") ? true : false);
                    championDAO.setTank(e.getValue().getTags().contains("Tank") ? true : false);
                    championDAO.setSupport(e.getValue().getTags().contains("Support") ? true : false);
                    //info설정
                    championDAO.setAttack(e.getValue().getInfo().getAttack());
                    championDAO.setDefense(e.getValue().getInfo().getDefense());
                    championDAO.setMagic(e.getValue().getInfo().getMagic());
                    championDAO.setDifficulty(e.getValue().getInfo().getDifficulty());

                    //세팅된 championDAO를 DAOS리스트에 삽입.
                    championDAOS.add(championDAO);

                    //print log
                    System.out.println(championDAO);
                });
    }
}
