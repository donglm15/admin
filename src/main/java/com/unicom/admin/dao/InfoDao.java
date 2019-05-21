package com.unicom.admin.dao;

import com.unicom.admin.model.Info;
import com.unicom.admin.model.InfoExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface InfoDao {

    /**
     * 获取全部资讯
     * @return
     */
    @Select("select * from info")
    @Results({
            @Result(column = "infotypeid",
                    property = "infoType",
                    one = @One(select = "com.unicom.admin.dao.InfoTypeDao.getInfoTypeById",
                    fetchType = FetchType.EAGER)
            )
    })
    List<Info> getAllInfo();

    @Select("<script>" +
                "select * from info where 1=1" +
            "<if test='title!=null and title!=\"\"'>" +
                "and title like '%${title}%'" +
            "</if>" +
            "<if test='type!=null and type!=\"\"'>" +
            "and infoTypeId = #{type}" +
            "</if>" +
            "</script>")
    @Results({
            @Result(
                    column = "infoTypeId",
                    property = "infoType",
                    one = @One(select = "com.unicom.admin.dao.InfoTypeDao.getInfoTypeById",
                            fetchType = FetchType.EAGER)
            )
    })
    List<Info> getInfoByCondition(
            @Param("title") String title,
            @Param("type") String type
    );

//    @DeleteProvider(type=InfoSqlProvider.class, method="deleteByExample")
//    int deleteByExample(InfoExample example);
//
//    @Insert({
//        "insert into info (imgUrl, title, ",
//        "date, infoTypeId, read, ",
//        "like, favorite, ",
//        "content)",
//        "values (#{imgUrl,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, ",
//        "#{date,jdbcType=DATE}, #{infoTypeId,jdbcType=TINYINT}, #{read,jdbcType=SMALLINT}, ",
//        "#{like,jdbcType=SMALLINT}, #{favorite,jdbcType=SMALLINT}, ",
//        "#{content,jdbcType=LONGVARCHAR})"
//    })
//    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
//    int insert(Info record);
//
//    @InsertProvider(type=InfoSqlProvider.class, method="insertSelective")
//    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
//    int insertSelective(Info record);
//
//    @SelectProvider(type=InfoSqlProvider.class, method="selectByExampleWithBLOBs")
//    @Results({
//        @Result(column="id", property="id", jdbcType=JdbcType.TINYINT),
//        @Result(column="imgUrl", property="imgUrl", jdbcType=JdbcType.VARCHAR),
//        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
//        @Result(column="date", property="date", jdbcType=JdbcType.DATE),
//        @Result(column="infoTypeId", property="infoTypeId", jdbcType=JdbcType.TINYINT),
//        @Result(column="read", property="read", jdbcType=JdbcType.SMALLINT),
//        @Result(column="like", property="like", jdbcType=JdbcType.SMALLINT),
//        @Result(column="favorite", property="favorite", jdbcType=JdbcType.SMALLINT),
//        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
//    })
//    List<Info> selectByExampleWithBLOBs(InfoExample example);
//
//    @SelectProvider(type=InfoSqlProvider.class, method="selectByExample")
//    @Results({
//        @Result(column="id", property="id", jdbcType=JdbcType.TINYINT),
//        @Result(column="imgUrl", property="imgUrl", jdbcType=JdbcType.VARCHAR),
//        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
//        @Result(column="date", property="date", jdbcType=JdbcType.DATE),
//        @Result(column="infoTypeId", property="infoTypeId", jdbcType=JdbcType.TINYINT),
//        @Result(column="read", property="read", jdbcType=JdbcType.SMALLINT),
//        @Result(column="like", property="like", jdbcType=JdbcType.SMALLINT),
//        @Result(column="favorite", property="favorite", jdbcType=JdbcType.SMALLINT)
//    })
//    List<Info> selectByExample(InfoExample example);
//
//    @UpdateProvider(type=InfoSqlProvider.class, method="updateByExampleSelective")
//    int updateByExampleSelective(@Param("record") Info record, @Param("example") InfoExample example);
//
//    @UpdateProvider(type=InfoSqlProvider.class, method="updateByExampleWithBLOBs")
//    int updateByExampleWithBLOBs(@Param("record") Info record, @Param("example") InfoExample example);
//
//    @UpdateProvider(type=InfoSqlProvider.class, method="updateByExample")
//    int updateByExample(@Param("record") Info record, @Param("example") InfoExample example);
}