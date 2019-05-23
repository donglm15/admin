package com.unicom.admin.dao;

import com.unicom.admin.model.PageProduce;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PageProduceDao {


    @Select("select * from pageProduce")
//    @Results({
//            @Result(
//                    column = "produce_id",
//                    property = "pageProduce",
//                    one = @One(select = "com.unicom.admin.dao.PageProduceDao.getPageProduceById",
//                            fetchType = FetchType.EAGER)
//            )
//    })
    List<PageProduce> getAllPageProduce();

    //新增一条产品数据（get）
    @Insert("insert into pageProduce" +
            "(produce_id,produce_datatime,produce_type,produce_name,produce_team_name, produce_importance,produce_details}) values" +
            "(#{produce_id},#{produce_datatime},#{produce_type},#{produce_name},#{produce_team_name},#{produce_importance},#{produce_details})")
    int save(
            @Param("produce_id") int produce_id,
            @Param("produce_datatime") String produce_datatime,
            @Param("produce_type") String produce_type,
            @Param("produce_name") String produce_name,
            @Param("produce_team_name") String produce_team_name,
            @Param("produce_importance") int produce_importance,
            @Param("produce_details") String produce_details
    );

    //根据id获取一条新闻数据
    @Select("select * from pageProduce where produce_id = #{produce_id}")
    @Results({
            @Result(column = "produce_id",
                    property = "produce_id",
                    one = @One(select = "com.unicom.admin.dao.PageProduceDao.getPageProduceById",
                            fetchType = FetchType.EAGER)
            )
    })
    PageProduce getPageProduceById(int produce_id);

    //新增一条产品数据（Post方式）
    @Options(useGeneratedKeys = true,keyColumn = "produce_id",keyProperty = "produce_id")
    @Insert("insert into pageProduce" +
            "(produce_id,produce_datatime,produce_type,produce_name,produce_team_name, produce_importance,produce_details}) values" +
            "(#{produce_id},#{produce_datatime},#{produce_type},#{produce_name},#{produce_team_name},#{produce_importance},#{produce_details})")
    int saveOne(PageProduce pageProduce);


    @Select("<script>" +
            "select * from pageProduce where 1=1" +
            "<if test='produce_name!=null and produce_name!=\"\"'>" +
            "and produce_name like '%${produce_name}%'"+
            "</if>"+
            "<if test='produce_importance!=null and produce_importance!=\"\"'>" +
            " and produce_importance = #{produce_importance}"+
            "</if>"+
            "<if test='produce_type!=null and produce_type!=\"\"'>" +
            " and produce_type = #{produce_type}"+
            "</if>"+
            "<if test='order!=null and order==\"+id\"'>" +
            " order by id asc"+
            "</if>"+
            "<if test='order!=null and order==\"-id\"'>" +
            " order by id desc"+
            "</if>"+
            "</script>")
    @Results({
            @Result(column = "produce_id",
                    property = "produce_id",
                    one = @One(select = "com.unicom.admin.dao.PageProduceDao.getPageProduceById",
                            fetchType = FetchType.EAGER)
            )
    })
    List<PageProduce> getPageProduceByCondition(
            @Param("produce_name") String produce_name,
            @Param("produce_importance") int produce_importance,
            @Param("produce_type") String produce_type,
            @Param("order") String order
    );



//      PageProduce
//      pageProduce
    @Insert({
        "insert into pageproduce (produce_id, produce_datatime, ",
        "produce_type, produce_name, ",
        "produce_team_name, produce_importance, ",
        "produce_details)",
        "values (#{produce_id,jdbcType=TINYINT}, #{produce_datatime,jdbcType=TIMESTAMP}, ",
        "#{produce_type,jdbcType=CHAR}, #{produce_name,jdbcType=CHAR}, ",
        "#{produce_team_name,jdbcType=CHAR}, #{produce_importance,jdbcType=TINYINT}, ",
        "#{produce_details,jdbcType=VARCHAR})"
    })
    int insert(PageProduce record);

    @InsertProvider(type=PageProduceSqlProvider.class, method="insertSelective")
    int insertSelective(PageProduce record);
}

