package com.unicom.admin.dao;

import com.unicom.admin.model.MarketStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MarketStatusDao {
       @Select("select * from marketStatus where id =#{id}")
       @Results({
            @Result(column = "status",property = "status")
       })
       MarketStatus getMarketStatusById(int id);
}