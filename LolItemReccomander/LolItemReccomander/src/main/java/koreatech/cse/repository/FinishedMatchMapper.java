package koreatech.cse.repository;

import koreatech.cse.domain.FinishedMatchSearchable;
import koreatech.cse.domain.match.FinishedMatch;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinishedMatchMapper {
    @Insert("INSERT INTO LEAGUEOFLEGENDS.FINISHEDMATCH (NAME, EMAIL, PASSWORD, AGE) VALUES (#{name}, #{email}, #{password}, #{age})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = int.class)
    void insert(FinishedMatch finishedMatch);

    @Update("UPDATE WSC.USERS SET NAME = #{name}, EMAIL = #{email}, PASSWORD = #{password}, AGE = #{age} WHERE ID = #{id}")
    void update(FinishedMatch finishedMatch);

    @Select("SELECT * FROM WSC.USERS WHERE ID = #{id}")
    FinishedMatch findOne(@Param("id") int id);

    @Select("SELECT * FROM WSC.USERS WHERE EMAIL = #{email}")
    FinishedMatch findByEmail(@Param("email") String email);

    @Delete("DELETE FROM WSC.USERS WHERE ID = #{id}")
    void delete(@Param("id") int id);

    //@formatter off
    @Select("<script>"
            + "SELECT * FROM WSC.USERS"
            + "<if test='name != null'> WHERE NAME = #{name}</if>"
            + "<if test='name != null and email != null'> OR EMAIL = #{email}</if>"
            + "<if test='orderParam != null'>ORDER BY ${orderParam} DESC</if>"
            + "</script>")
    //@formatter on
    List<FinishedMatch> findByScript(FinishedMatchSearchable searchable);

    //@formatter off
    @Select("<script>"
            + "SELECT * FROM WSC.USERS"
            + "<choose>"
            + "<when test='name != null and email != null'> WHERE NAME = #{name} OR EMAIL = #{email}</when>"
            + "<when test='name != null'> WHERE NAME = #{name}</when>"
            + "<otherwise> </otherwise>"
			+ "</choose>"
            + "<if test='orderParam != null'>ORDER BY ${orderParam} DESC</if>"
            + "</script>")
    //@formatter on
    List<FinishedMatch> findByScript2(FinishedMatchSearchable searchable);

    //@formatter off
    @Select("<script>"
            + "SELECT * FROM WSC.USERS"
            + "<if test='stringList != null and !stringList.empty'> WHERE NAME IN <foreach item='item' collection='stringList' open='(' separator=',' close=')'>#{item}</foreach></if>"
            + "</script>")
    //@formatter on
    List<FinishedMatch> findByList(@Param("stringList") List<String> stringList);
}
