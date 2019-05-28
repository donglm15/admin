package com.unicom.admin.dao;

import com.unicom.admin.model.Notice;
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
    List<PageProduce> getAll();

    //分页查询
    @Select("<script>" +
            "select * from pageProduce where 1=1" +
            "<if test='produce_name!=null and produce_name!=\"\"'>" +
            "and produce_name like '%${produce_name}%'"+
            "</if>"+
            "<if test='produce_importance!=null and produce_importance!=\"\"'>" +
            "and produce_importance like '%${produce_importance}%'"+
            "</if>"+
            "<if test='produce_type!=null and produce_type!=\"\"'>" +
            "and produce_type like '%${produce_type}%'"+
            "</if>"+
            "<if test='order!=null and order==\"+id\"'>" +
            "order by produce_id asc"+
            "</if>"+
            "<if test='order!=null and order==\"-id\"'>" +
            "order by produce_id desc"+
            "</if>"+
            "</script>")
    List<PageProduce> getAllPageProduce(
    @Param("produce_name") String produce_name,
    @Param("produce_importance") int produce_importance,
    @Param("produce_type") String produce_type,
    @Param("order") String order
    );

    //增
    @Insert({"insert into pageProduce (produce_datatime,produce_type,produce_name,produce_team_name,produce_importance,produce_details) ",
            "(#{produce_datatime},#{produce_type},#{produce_name},#{produce_team_name},#{produce_importance},#{produce_details})"})
    int insertPageProduce(PageProduce pageProduce);


    //删
    @Delete("delete from pageProduce where produce_id=#{produce_id}")
    int deletePageProduce(int produce_id);

    //获取产品详情
    @Select("select * from pageProduce where produce_id=#{produce_id}")
    PageProduce getOnePageProduce(int produce_id);

    //更新产品信息
    @Update({
            "update pageProduce",
            "produce_datatime = #{produce_datatime},",
            "produce_name = #{produce_name},",
            "produce_importance = #{produce_importance},",
            "produce_type = #{produce_type},"
    })
    int updatePageProduce(PageProduce pageProduce);

//    pageProduce
//    PageProduce



//    @Select("<script>" +
//            "select * from pageProduce where 1=1" +
//            "<if test='produce_name!=null and produce_name!=\"\"'>" +
//            "and produce_name like '%${produce_name}%'"+
//            "</if>"+
//            "<if test='produce_importance!=null and produce_importance!=\"\"'>" +
//            " and produce_importance = #{produce_importance}"+
//            "</if>"+
//            "<if test='produce_type!=null and produce_type!=\"\"'>" +
//            " and produce_type = #{produce_type}"+
//            "</if>"+
//            "<if test='order!=null and order==\"+id\"'>" +
//            " order by id asc"+
//            "</if>"+
//            "<if test='order!=null and order==\"-id\"'>" +
//            " order by id desc"+
//            "</if>"+
//            "</script>")
//    @Results({
//            @Result(column = "produce_id",
//                    property = "produce_id",
//                    one = @One(select = "com.unicom.admin.dao.PageProduceDao.getPageProduceById",
//                            fetchType = FetchType.EAGER)
//            )
//    })
//    List<PageProduce> getPageProduceByCondition(
//            @Param("produce_name") String produce_name,
//            @Param("produce_importance") int produce_importance,
//            @Param("produce_type") String produce_type,
//            @Param("order") String order
//    );

}

