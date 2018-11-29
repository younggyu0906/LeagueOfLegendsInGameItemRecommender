package koreatech.cse.repository;

import koreatech.cse.domain.FinishedMatchSearchable;
import koreatech.cse.domain.match.FinishedMatch;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinishedMatchMapper {
    @Insert(
                "INSERT INTO LEAGUEOFLEGENDS.FINISHEDMATCH " +
                "(CHAMPIONID, ITEM0ID, ITEM1ID, ITEM2ID, ITEM3ID, ITEM4ID, ITEM5ID, ITEM6ID) " +
                "VALUES " +
                "(#{championId}, #{item0Id}, #{item1Id}, #{item2Id}, #{item3Id}, #{item4Id}, #{item5Id}, #{item6Id})"
            )
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    void insert(FinishedMatch finishedMatch);

    @Update(
                "UPDATE LEAGUEOFLEGENDS.FINISHEDMATCH " +
                "SET CHAMPIONID = #{championId}, " +
                "ITEM0ID = #{item0Id}, ITEM1ID = #{item1Id}, ITEM2ID = #{item2Id}, ITEM3ID = #{item3Id}, " +
                "ITEM4ID = #{item4Id}, ITEM5ID = #{item5Id}, ITEM6ID = #{item6Id} WHERE ID = #{id}"
            )
    void update(FinishedMatch finishedMatch);

    @Select("SELECT * FROM LEAGUEOFLEGENDS.FINISHEDMATCH WHERE ID = #{id}")
    FinishedMatch findFinishedMatchById(@Param("id") int id);

    @Select("SELECT * FROM LEAGUEOFLEGENDS.FINISHEDMATCH WHERE CHAMPIONID = #{championId}")
    FinishedMatch findFinishedMatchByChampionId(@Param("championId") String championId);

    @Delete("DELETE FROM WSC.USERS WHERE ID = #{id}")
    void delete(@Param("id") int id);
}
