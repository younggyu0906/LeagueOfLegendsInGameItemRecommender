package koreatech.cse.repository;

import koreatech.cse.domain.staticData.ItemDAO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMapper {
    // Insert item information into DB
    @Insert(
                "INSERT INTO LEAGUEOFLEGENDS.ITEMS (" +
                "ID, NAME, " +
                "HEALTH, MANA, ARMOR, SPELLBLOCK, ATTACKSPEED, PHYSICALDAMAGE, CRITCHANCE, MAGICDAMAGE, FINISHED" +
                ")" +
                "VALUES (" +
                "#{id}, #{name}, #{health}, #{mana}, #{armor}, #{spellBlock}, " +
                "#{attackSpeed}, #{physicalDamage}, #{critChance}, #{magicDamage}, #{finished}" +
                ")"
            )
    void insert(ItemDAO item);

    // Update item information in DB
    @Update(
                "UPDATE LEAGUEOFLEGENDS.ITEMS SET " +
                "NAME = #{name}, " +
                "HEALTH = #{health}, MANA = #{mana}, ARMOR = #{armor}, SPELLBLOCK = #{spellBlock}, " +
                "ATTACKSPEED = #{attackSpeed}, PHYSICALDAMAGE = #{physicalDamage}, CRITCHANCE = #{critChance}, " +
                "MAGICDAMAGE = #{magicDamage}, FINISHED = #{finished} " +
                "WHERE ID = #{id}"
            )
    void update(ItemDAO item);

    // Search by item id.
    @Select("SELECT * FROM LEAGUEOFLEGENDS.ITEMS WHERE ID = #{id}")
    ItemDAO findItemById(@Param("id") int id);

    // delete
    @Delete("DELETE FROM LEAGUEOFLEGENDS.ITEMS WHERE ID = #{id}")
    void delete(@Param("id") int id);
}
