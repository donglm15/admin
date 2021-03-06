package com.unicom.admin.dao;


import com.unicom.admin.model.Activity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

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
            "order by id desc"+
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
            @Param("endTime") String endTime,
            @Param("order") String order
    );


    @Delete("delete from activity where id=#{id}")
    int deleteActivity(int id);


    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    @Insert("insert into activity" +
            "(activityStatusId,people,tag,prize,title,content,address,startTime,endTime,uid,master,message,other) values" +
            "(#{activityType.id},#{people},#{tag},#{prize},#{title},#{content},#{address},#{startTime},#{endTime},#{uid},#{master},#{message},#{other})")
    int insertActivity(Activity activity);


    @Update("update activity set people=#{people},prize=#{prize},title=#{title},content=#{content},startTime=#{startTime},endTime=#{endTime}" +
            "where id=#{id}")
    int updateActivity(@Param(value = "people") String people, @Param(value = "prize") String prize, @Param(value = "title") String title, @Param(value = "content") String content, @Param(value = "startTime") Date startTime, @Param(value = "endTime") Date endTime, @Param(value = "id") int id);

    //    update activity set type=1 where startTime >=now() and endTime <now()
//    update activity set type=2 where startTime  <now()
//    update activity set type=3 where endTime >=now()
    @Update("update activity set activityStatusId=3 where startTime > now()")
    void updateDo();

    @Update("update activity set activityStatusId=2 where endTime < now()")
    void updateDone();

    @Update("update activity set activityStatusId=1 where startTime <= now() and endTime >= now()")
    void updateDoing();

}