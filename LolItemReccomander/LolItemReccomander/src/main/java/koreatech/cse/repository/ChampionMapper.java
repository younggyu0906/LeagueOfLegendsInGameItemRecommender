package koreatech.cse.repository;

import koreatech.cse.domain.staticData.ChampionDAO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionMapper {
    // Insert champion information into DB
    @Insert(
                "INSERT INTO leagueOfLegends.champions (" +
                "ID, NAME, ATTACK, MAGIC, DEFENSE, DIFFICULTY, ASSASSIN, FIGHTER, MAGE, SUPPORT, TANK, MARKSMAN" +
                ")" +
                "VALUES (" +
                "#{id}, #{name}, " +
                "#{attack}, #{magic}, #{defense}, #{difficulty}, " +
                "#{assassin}, #{fighter}, #{mage}, #{support}, #{tank}, #{marksman}" +
                ")"
            )
    void insert(ChampionDAO champion);

    // Ubdata champion information in DB
    @Update(
                "UPDATE leagueOfLegends.champions SET " +
                "NAME = #{name}, " +
                "ATTACK = #{attack}, MAGIC = #{magic}, DEFENSE = #{defense}, DIFFICULTY = #{difficulty}, " +
                "ASSASSIN = #{assassin}, FIGHTER = #{fighter}, MAGE = #{mage}, " +
                "SUPPORT = #{support}, TANK = #{tank}, MARKSMAN = #{marksman} " +
                "WHERE ID = #{id}"
            )
    void update(ChampionDAO champion);

    // Search by champion id.
    @Select("SELECT * FROM leagueOfLegends.champions WHERE ID = #{id}")
    ChampionDAO findChampionById(@Param("id") int id);

    // Delete
    @Delete("DELETE FROM leagueOfLegends.champions WHERE ID = #{id}")
    void delete(@Param("id") int id);
}
