package com.unicom.admin.dao;


import com.unicom.admin.model.Activity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface ActivityDao {

    @Select("select * from activity")
    @Results(
            @Result(
                    column = "activityStatusId",
                    property = "activityType",
                    one = @One(
                            select = "com.unicom.admin.dao.ActivityTypeDao.getActivityTypeById",
                            fetchType = FetchType.EAGER
                    )
            )
    )
    List<Activity> getAllActivity();


//            if (startTime && new Date(items.startTime) < new Date(startTime)) return false
//            if (endTime && new Date(items.endTime) >= new Date(endTime)) return false

    @Select("<script>" +
            "select * from activity where 1=1" +
            "<if test='title != null and title != \"\"'>" +
            "and title like '%${title}%'"+
            "</if>"+
            "<if test='type != null and type != \"\"'>" +
            "and activityStatusId = #{type}"+
            "</if>"+
            "<if test='startTime != null and startTime != \"\"'>" +
            "and startTime &gt;= #{startTime}"+
            "</if>"+
            "<if test='endTime != null and endTime != \"\"'>" +
            "and endTime &lt;= #{endTime}"+
            "</if>"+
            "</script>")
    @Results(
            @Result(
                    column = "activityStatusId",
                    property = "activityType",
                    one = @One(
                            select = "com.unicom.admin.dao.ActivityTypeDao.getActivityTypeById",
                            fetchType = FetchType.EAGER
                    )
            )
    )
    List<Activity> getActivityByCondition(
            @Param("title") String title,
            @Param("type") String type,
            @Param("startTime") String startTime,
            @Param("endTime") String endTime
    );


    @Delete("delete from activity where id=#{id}")
    int deleteActivity(int id);
}