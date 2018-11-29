package koreatech.cse.service;

import koreatech.cse.domain.champion.Data;
import koreatech.cse.domain.staticData.ChampionDAO;
import koreatech.cse.repository.ChampionMapper;
import koreatech.cse.repository.ItemMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import koreatech.cse.domain.staticData.ItemDAO;
import java.util.ArrayList;
import java.util.Map;

@Service
public class StaticDataService {

    @Inject
    private ChampionMapper championMapper;
    private ArrayList<ChampionDAO> championDAOS = new ArrayList<>();

    @Inject
    private ItemMapper itemMapper;
    private ArrayList<ItemDAO> itemDAOS = new ArrayList<>();    //DB에 업로드 하기 전 itemDAO들이 저장될 리스트.

    public ArrayList<ChampionDAO> getChampionDAOS() {
        return championDAOS;
    }

    //champions맵을 가져와 championDAO를 초기화한다.
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
                    championDAO.setMage(e.getValue().getTags().contains("Mage"));
                    championDAO.setAssassin(e.getValue().getTags().contains("Assassin"));
                    championDAO.setFighter(e.getValue().getTags().contains("Fighter"));
                    championDAO.setMarksman(e.getValue().getTags().contains("Marksman"));
                    championDAO.setTank(e.getValue().getTags().contains("Tank"));
                    championDAO.setSupport(e.getValue().getTags().contains("Support"));
                    //info설정
                    championDAO.setAttack(e.getValue().getInfo().getAttack());
                    championDAO.setDefense(e.getValue().getInfo().getDefense());
                    championDAO.setMagic(e.getValue().getInfo().getMagic());
                    championDAO.setDifficulty(e.getValue().getInfo().getDifficulty());

                    //세팅된 championDAO를 DAOS리스트에 삽입.
                    championDAOS.add(championDAO);
                    championMapper.insert(championDAO);

                    //print log
                    System.out.println(championDAO);
                });
    }

    public ArrayList<ItemDAO> getItemDAOS() {
        return itemDAOS;
    }
    //item맵을 가져와 itemDAO를 초기화한다.
    public void setItemDAOS(Map<Integer, koreatech.cse.domain.item.Data> items) {
        //초기화
        itemDAOS.clear();
        //stream을 통해 반복하면서 itemDao설정 후 DAOS에 반복하여 넣는다.
        items.entrySet().stream()
                .forEach(e-> {
                    //저장할 DAO하나 생성
                    ItemDAO itemDAO = new ItemDAO();
                    itemDAO.setId(e.getKey());
                    itemDAO.setName(e.getValue().getName());

                    //getValue안에 Stat안에 정보를 빼서 저장하는 문장들.
                    //아주 간단한 3항 연산
                    //null일수도 있어서 null이면 0 넣게 하는 것임.
                    itemDAO.setArmor(
                            e.getValue().getStats().getFlatArmorMod() != null
                                    ? e.getValue().getStats().getFlatArmorMod() : 0);
                    itemDAO.setSpellBlock(
                            e.getValue().getStats().getFlatSpellBlockMod() != null
                                    ? e.getValue().getStats().getFlatSpellBlockMod() : 0);

                    itemDAO.setHealth(e.getValue().getStats().getFlatHPPoolMod() != null
                            ? e.getValue().getStats().getFlatHPPoolMod() : 0);

                    itemDAO.setMana(e.getValue().getStats().getFlatMPPoolMod() != null
                            ? e.getValue().getStats().getFlatMPPoolMod() : 0);

                    itemDAO.setPhysicalDamage(e.getValue().getStats().getFlatPhysicalDamageMod() != null
                            ? e.getValue().getStats().getFlatPhysicalDamageMod() : 0);

                    itemDAO.setAttackSpeed(e.getValue().getStats().getPercentAttackSpeedMod() != null
                            ? e.getValue().getStats().getPercentAttackSpeedMod() : 0);

                    itemDAO.setCritChance(e.getValue().getStats().getFlatCritChanceMod() != null
                            ? e.getValue().getStats().getFlatCritChanceMod() : 0);

                    itemDAO.setMagicDamage(e.getValue().getStats().getFlatMagicDamageMod() != null
                            ? e.getValue().getStats().getFlatMagicDamageMod() : 0);

                    //완제품인지 into(업그레이드 할 수 있는 아이템) 이 없으면 true
                    itemDAO.setFinished(e.getValue().getInto().isEmpty());

                    //세팅된 itemDAO를 DAOS리스트에 삽입.
                    itemDAOS.add(itemDAO);
                    itemMapper.insert(itemDAO);

                    //print log
                    System.out.println(itemDAO);
                });
    }
}
