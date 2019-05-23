package com.unicom.admin.dao;


import com.unicom.admin.model.Market;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MarketDao {
    //前端列表
      @Select("select * from market")
      @Results({
              @Result(
                      column = "marketTypeId",
                      property = "marketType",
                      one = @One(select = "com.unicom.admin.dao.MarketTypeDao.getMarketTypeById",
                      fetchType = FetchType.EAGER)
              ),
              @Result(
                      column = "statusId",
                      property ="marketStatus",
                      one = @One(select = "com.unicom.admin.dao.MarketStatusDao.getMarketStatusById")
              )
      })
       List<Market> getAllMarket();
    //后端分页
    @Select("<script>" +
            "select * from market where 1=1" +
            "<if test='title!=null and title!=\"\"'>" +
            "and title like '%${title}%'" +
            "</if>" +
            "<if test='importance!=null and  importance!=\"\"'>" +
            "and importance=#{importance}" +
            "</if>" +
            "<if test='marketType!=null and marketType!=\"\"'>" +
            "and marketTypeId=#{marketType}" +
            "</if>" +
            "<if test='sort!=null and sort==\"+id\"'>" +
            "order by id asc" +
            "</if>" +
            "<if test='sort!=null and sort==\"-id\"'>" +
            "order by id desc" +
            "</if>" +
            "</script>")
    @Results({
            @Result(
                    column = "marketTypeId",
                    property = "marketType",
                    one = @One(select = "com.unicom.admin.dao.MarketTypeDao.getMarketTypeById",
                    fetchType = FetchType.EAGER)
            ),
            @Result(
                    column = "statusId",
                    property = "marketStatus",
                    one = @One(select="com.unicom.admin.dao.MarketStatusDao.getMarketStatusById")
            )

    })
     List<Market> getMarketByCondition(
            @Param("title") String title,
            @Param("importance") String importance,
            @Param("marketType") String marketType,
            @Param("sort") String sort
    );
    //新增
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    @Insert("insert into market" +
            "(title,endDate,marketTypeId,employName,jobPlace,statusId,importance,content,reviewer) values" +
            "(#{title},#{endDate},#{marketType.id},#{employName},#{jobPlace},#{marketStatus.id},#{importance},#{content},#{reviewer})")
    int create(Market market);
    //查看
    @Select("select * from market where id = #{id}")
    @Results({
            @Result(
                    column = "marketTypeId",
                    property = "marketType",
                    one = @One(select = "com.unicom.admin.dao.MarketTypeDao.getMarketTypeById",
                    fetchType = FetchType.EAGER)
            ),
            @Result(
                    column = "statusId",
                    property = "marketStatus",
                    one = @One(select = "com.unicom.admin.dao.MarketStatusDao.getMarketStatusById",
                    fetchType = FetchType.EAGER)
            )
    })
    Market getMarketById(int id);
    //编辑
    @Update("update market set endDate=#{endDate},marketTypeId=#{marketType.id},statusId=#{marketStatus.id}," +
            "title=#{title},employName=#{employName},jobPlace=#{jobPlace},importance=#{importance},content=#{content},reviewer=#{reviewer} where id=#{id}")
    int updateMarket(Market market);
    //删除
    @Delete("delete from market where id = #{id}")
    int deleteMarket(int id);
}