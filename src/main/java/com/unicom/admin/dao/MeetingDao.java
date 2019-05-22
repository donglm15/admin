package com.unicom.admin.dao;

import com.unicom.admin.model.Meeting;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//告诉mybatis此接口包含访问数据库的操作
@Mapper
public interface MeetingDao {
    @Select("select * from meeting")
        //显示全部数据
    List<Meeting> getAllMeeting();
    //新增（get）
    @Insert({
        "insert into meeting (meetingName, meetingPosition, ",
        "peopleNum, ifMoreid, ",
        "ifOpenid)",
        "values (#{meetingName,jdbcType=VARCHAR}, #{meetingPosition,jdbcType=VARCHAR}, ",
        "#{peopleNum,jdbcType=SMALLINT}, #{ifMoreid,jdbcType=TINYINT}, ",
        "#{ifOpenid,jdbcType=TINYINT})"
    })
    int create(
           @Param("meetingName") String meetingName,
           @Param("meetingPosition") String meetingPosition,
           @Param("peopleNum") int peopleNum,
           @Param("ifMoreid") int ifMoreid,
           @Param("ifOpenid") int ifOpenid
    );

    @Select("<script>" +
            "select * from meeting where 1=1" +
            "<if test='meetingName!=null and meetingName!=\"\"'>" +
            " and meetingName like '%${meetingName}%'" +
            "</if>" +
            "<if test='peopleNum!=null and peopleNum!=\"\"'>" +
            " and peopleNum &gt;= #{peopleNum}" +
            "</if>" +
            "<if test='sort!=null and sort==\"+id\"'>" +
            " order by id asc" +
            "</if>" +
            "<if test='sort!=null and sort==\"-id\"'>" +
            " sort by id desc" +
            "</if>" +
            "</script>")
    List<Meeting> getMeetingByCondition(
            @Param("meetingName") String meetingName,
            @Param("peopleNum") String peopleNum,
            @Param("sort") String sort
    );

//    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
//    int insert(Meeting record);
//
//    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
//    int insertSelective(Meeting record);
}