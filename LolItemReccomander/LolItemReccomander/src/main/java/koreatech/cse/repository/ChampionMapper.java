package koreatech.cse.repository;

import koreatech.cse.domain.ChampionSearchable;
import koreatech.cse.domain.staticData.ChampionDAO;
import koreatech.cse.repository.provider.UserSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChampionMapper {
    @Insert("INSERT INTO LEAGUEOFLEGENDS.CHAMPIONS (" +
            "ID, NAME, ATTACK, MAGIC, DEFENSE, DIFFICULTY, ASSASSIN, FIGHTER, MAGE, SUPPORT, TANK, MARKSMAN" +
            ")" +
            "VALUES (" +
            "#{id}, #{name}, " +
            "#{attack}, #{magic}, #{defense}, #{difficulty}, " +
            "#{assassin}, #{fighter}, #{mage}, #{support}, #{tank}, #{marksman}" +
            ")"
    )
    void insert(ChampionDAO champion);

    @Update("UPDATE LEAGUEOFLEGENDS.CHAMPIONS SET " +
            "NAME = #{name}, " +
            "ATTACK = #{attack}, MAGIC = #{magic}, DEFENSE = #{defense}, DIFFICULTY = #{difficulty}, " +
            "ASSASSIN = #{assassin}, FIGHTER = #{fighter}, MAGE = #{mage}, " +
            "SUPPORT = #{support}, TANK = #{tank}, MARKSMAN = #{marksman} " +
            "WHERE ID = #{id}"
    )
    void update(ChampionDAO champion);

    @Select("SELECT * FROM LEAGUEOFLEGENDS.CHAMPIONS WHERE ID = #{id}")
    ChampionDAO findChampionById(@Param("id") int id);

    @Delete("DELETE FROM LEAGUEOFLEGENDS.CHAMPIONS WHERE ID = #{id}")
    void delete(@Param("id") int id);
}
