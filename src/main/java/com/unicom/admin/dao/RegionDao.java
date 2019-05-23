package com.unicom.admin.dao;


import com.unicom.admin.model.RegionType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RegionDao {

    @Select("select * from region where id=#{id}")
    RegionType getRegionById(int id);
}