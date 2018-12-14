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
    private ArrayList<ChampionDAO> championDAOS = new ArrayList<>();    // List where daos will be saved

    @Inject
    private ItemMapper itemMapper;
    private ArrayList<ItemDAO> itemDAOS = new ArrayList<>();            // List where daos will be saved

    public ArrayList<ChampionDAO> getChampionDAOS() {
        return championDAOS;
    }

    // Get the champions map and set the championDAO.
    public void setChampionDAOS( Map<String, Data> champions) {
        // clear
        championDAOS.clear();
        // Loop using stream. After setting championDAO, append it repeatedly in DAOS.
        champions.entrySet().stream().forEach(e-> {
            // Declare DAO to save
            ChampionDAO championDAO = new ChampionDAO();
            championDAO.setName(e.getValue().getName());
            championDAO.setId(e.getValue().getKey());
            // Set true if the string corresponding to the tag is included
            championDAO.setMage(e.getValue().getTags().contains("Mage"));
            championDAO.setAssassin(e.getValue().getTags().contains("Assassin"));
            championDAO.setFighter(e.getValue().getTags().contains("Fighter"));
            championDAO.setMarksman(e.getValue().getTags().contains("Marksman"));
            championDAO.setTank(e.getValue().getTags().contains("Tank"));
            championDAO.setSupport(e.getValue().getTags().contains("Support"));
            // Setting info
            championDAO.setAttack(e.getValue().getInfo().getAttack());
            championDAO.setDefense(e.getValue().getInfo().getDefense());
            championDAO.setMagic(e.getValue().getInfo().getMagic());
            championDAO.setDifficulty(e.getValue().getInfo().getDifficulty());

            // Append the set champion DAO into the DAOS list.
            championDAOS.add(championDAO);
        });
    }
    // Insert champion information into DB.
    public void insertChampionDAOS() {
        championDAOS.stream().forEach(e->championMapper.insert(e));
    }

    public ArrayList<ItemDAO> getItemDAOS() {
        return itemDAOS;
    }

    // Get the items map and set the itemDAO.
    public void setItemDAOS(Map<Integer, koreatech.cse.domain.item.Data> items) {
        // clear
        itemDAOS.clear();
        // Loop using stream. After setting itemDao, append it repeatedly in DAOS.
        items.entrySet().stream().forEach(e-> {
            // Declare the dao object to save
            ItemDAO itemDAO = new ItemDAO();
            itemDAO.setId(e.getKey());
            itemDAO.setName(e.getValue().getName());

            // Save the item's stats in itemDAO
            // If the stat is not null, get the value. If it is null, 0 is saved.
            // ternary operator (3항 연산자)
            itemDAO.setArmor(
                    e.getValue().getStats().getFlatArmorMod() != null
                    ? e.getValue().getStats().getFlatArmorMod() : 0
            );

            itemDAO.setSpellBlock(
                    e.getValue().getStats().getFlatSpellBlockMod() != null
                    ? e.getValue().getStats().getFlatSpellBlockMod() : 0
            );

            itemDAO.setHealth(
                    e.getValue().getStats().getFlatHPPoolMod() != null
                    ? e.getValue().getStats().getFlatHPPoolMod() : 0
            );

            itemDAO.setMana(
                    e.getValue().getStats().getFlatMPPoolMod() != null
                    ? e.getValue().getStats().getFlatMPPoolMod() : 0
            );

            itemDAO.setPhysicalDamage(
                    e.getValue().getStats().getFlatPhysicalDamageMod() != null
                    ? e.getValue().getStats().getFlatPhysicalDamageMod() : 0
            );

            itemDAO.setAttackSpeed(
                    e.getValue().getStats().getPercentAttackSpeedMod() != null
                    ? e.getValue().getStats().getPercentAttackSpeedMod() : 0
            );

            itemDAO.setCritChance(
                    e.getValue().getStats().getFlatCritChanceMod() != null
                    ? e.getValue().getStats().getFlatCritChanceMod() : 0
            );

            itemDAO.setMagicDamage(
                    e.getValue().getStats().getFlatMagicDamageMod() != null
                    ? e.getValue().getStats().getFlatMagicDamageMod() : 0
            );

            // If into is null, it is finished item. into is the top item list of the current item.
            itemDAO.setFinished(e.getValue().getInto() == null);

            // Insert itemDAO into itemDAOS list.
            itemDAOS.add(itemDAO);
        });
    }

    // insert itemDAOS into DB
    public void insertItemDAOS() {
        itemDAOS.stream().forEach(e-> itemMapper.insert(e));
    }
}
