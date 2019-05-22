package com.unicom.admin.dao;


import com.unicom.admin.model.ActivityType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ActivityTypeDao {

    @Select("select * from activitystatus where id=#{id}")
    ActivityType getActivityTypeById(int id);
}