package com.unicom.admin.dao;

import com.unicom.admin.model.Market;
import com.unicom.admin.model.MarketExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MarketDao {
    @DeleteProvider(type=MarketSqlProvider.class, method="deleteByExample")
    int deleteByExample(MarketExample example);

    @Delete({
        "delete from market",
        "where id = #{id,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(tinyint id);

    @Insert({
        "insert into market (title, startDate, ",
        "endDate, employName, ",
        "importance, jobPlace, ",
        "content, marketTypeId, ",
        "statusId)",
        "values (#{title,jdbcType=VARCHAR}, #{startDate,jdbcType=TIMESTAMP}, ",
        "#{endDate,jdbcType=TIMESTAMP}, #{employName,jdbcType=VARCHAR}, ",
        "#{importance,jdbcType=TINYINT}, #{jobPlace,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=VARCHAR}, #{marketTypeId,jdbcType=TINYINT}, ",
        "#{statusId,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=tinyint.class)
    int insert(Market record);

    @InsertProvider(type=MarketSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=tinyint.class)
    int insertSelective(Market record);

    @SelectProvider(type=MarketSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="employName", property="employName", jdbcType=JdbcType.VARCHAR),
        @Result(column="importance", property="importance", jdbcType=JdbcType.TINYINT),
        @Result(column="jobPlace", property="jobPlace", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="marketTypeId", property="marketTypeId", jdbcType=JdbcType.TINYINT),
        @Result(column="statusId", property="statusId", jdbcType=JdbcType.TINYINT)
    })
    List<Market> selectByExample(MarketExample example);

    @Select({
        "select",
        "id, title, startDate, endDate, employName, importance, jobPlace, content, marketTypeId, ",
        "statusId",
        "from market",
        "where id = #{id,jdbcType=TINYINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="startDate", property="startDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="endDate", property="endDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="employName", property="employName", jdbcType=JdbcType.VARCHAR),
        @Result(column="importance", property="importance", jdbcType=JdbcType.TINYINT),
        @Result(column="jobPlace", property="jobPlace", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="marketTypeId", property="marketTypeId", jdbcType=JdbcType.TINYINT),
        @Result(column="statusId", property="statusId", jdbcType=JdbcType.TINYINT)
    })
    Market selectByPrimaryKey(tinyint id);

    @UpdateProvider(type=MarketSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Market record, @Param("example") MarketExample example);

    @UpdateProvider(type=MarketSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Market record, @Param("example") MarketExample example);

    @UpdateProvider(type=MarketSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Market record);

    @Update({
        "update market",
        "set title = #{title,jdbcType=VARCHAR},",
          "startDate = #{startDate,jdbcType=TIMESTAMP},",
          "endDate = #{endDate,jdbcType=TIMESTAMP},",
          "employName = #{employName,jdbcType=VARCHAR},",
          "importance = #{importance,jdbcType=TINYINT},",
          "jobPlace = #{jobPlace,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "marketTypeId = #{marketTypeId,jdbcType=TINYINT},",
          "statusId = #{statusId,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(Market record);
}