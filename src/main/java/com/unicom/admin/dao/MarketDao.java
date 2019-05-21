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
              @Result(column = "marketTypeId",
                      property = "marketType",
                      one = @One(select = "com.unicom.admin.dao.MarketTypeDao.getMarketTypeById",
                      fetchType = FetchType.EAGER)
              )
      })
       List<Market> getAllMarket();
    //后端分页
    @Select("<script>" +
            "select * from market where 1=1" +
            "<if test='title!=null and title!=\"\"'>" +
            "and title like '%${title}%'" +
            "</if>" +
            "<if test='importance!=null'>" +
            "and importance=#{importance}" +
            "</if>" +
            "<if test='marketType!=null and marketType!=\"\"'>" +
            "and marketTypeId=#{marketType}" +
            "</if>" +
            "<if test='sort!=null and sort==\"+id\"'>" +
            "sort by id asc" +
            "</if>" +
            "<if test='sort!=null and sort==\"-id\"'>" +
            "sort by id desc" +
            "</if>" +
            "</script>")
    @Results({
            @Result(column = "marketTypeId",
                    property = "marketType",
                    one = @One(select = "com.unicom.news.dao.MarketTypeDao.getMarketTypeById",
                    fetchType = FetchType.EAGER)
            )
    })
     List<Market> getMarketByCondition(
            @Param("title") String title,
            @Param("importance") int importance,
            @Param("marketType") String marketType,
            @Param("sort") String sort
    );
}