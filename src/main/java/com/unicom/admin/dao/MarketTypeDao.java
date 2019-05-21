package com.unicom.admin.dao;

import com.unicom.admin.model.MarketType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MarketTypeDao {
       @Select("select * from marketType where id = #{id}")
       @Results({
               @Result(column = "typeName",property = "typeName")
       })
       MarketType getMarketTypeById(int id);
}