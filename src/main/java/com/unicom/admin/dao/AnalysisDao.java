package com.unicom.admin.dao;

import com.unicom.admin.model.Analysis;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AnalysisDao {

    @Select("select * from dailyreport")
    @Results({
            @Result(column = "region",
                    property = "regionType",
                    one = @One(select = "com.unicom.admin.dao.RegionDao.getRegionById",
                            fetchType = FetchType.EAGER)
            )
    })
    List<Analysis> getAll();

    @Select("<script>"+"select person from dailyreport where 1=1"+
            "<if test='product!=null and product!=\"\"'>" +
            " and product like '%${product}%'" +
            "</if>"+
            "<if test='region!=null and region!=\"\"'>" +
            " and region=#{region}" +
            "</if>"+
            "<if test='startDate!=null and startDate!=\"\" and endDate!=\"\" and endDate!=null'>" +
            " and date between #{startDate} and #{endDate}" +
            "</if>"+
            "</script>")
    String getPerson(
            @Param("startDate") String startDate,
            @Param("endDate")String endDate,
            @Param("region") String region,
            @Param("product") String product
    );

    @Select("<script>"+"select * from dailyreport where 1=1"+
            "<if test='product!=null and product!=\"\"'>" +
            " and product like '%${product}%'" +
            "</if>"+
            "<if test='region!=null and region!=\"\"'>" +
            " and region=#{region}" +
            "</if>"+
            "<if test='startDate!=null and startDate!=\"\" and endDate!=\"\" and endDate!=null'>" +
            " and date between #{startDate} and #{endDate}" +
            "</if>"+
            "order by date desc "+
            "</script>")
    @Results({
            @Result(column = "region",
                    property = "regionType",
                    one = @One(select = "com.unicom.admin.dao.RegionDao.getRegionById",
                            fetchType = FetchType.EAGER)
            )
    })
    List<Analysis> getByCondition(
            @Param("startDate") String startDate,
            @Param("endDate")String endDate,
            @Param("region") String region,
            @Param("product") String product
    );

    @Delete({
        "delete from dailyreport",
        "where id = #{id,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(int id);

    @Insert({
        "insert into dailyreport (product, date, region, ",
        "person, billing, tratio, ",
        "hratio)",
        "values (#{product,jdbcType=VARCHAR}, #{date,jdbcType=VARCHAR}, #{region,jdbcType=TINYINT}, ",
        "#{person,jdbcType=INTEGER}, #{billing,jdbcType=FLOAT}, #{tratio,jdbcType=FLOAT}, ",
        "#{hratio,jdbcType=FLOAT})"
    })
    int save(Analysis analysis);

    @Update({
        "update dailyreport",
        "set date = #{date,jdbcType=VARCHAR},",
            "product = #{product,jdbcType=VARCHAR},",
          "region = #{region,jdbcType=TINYINT},",
          "person = #{person,jdbcType=INTEGER},",
          "billing = #{billing,jdbcType=FLOAT},",
          "tratio = #{tratio,jdbcType=FLOAT},",
          "hratio = #{hratio,jdbcType=FLOAT}",
        "where id = #{id,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(Analysis analysis);
}