package com.unicom.admin.dao;

import com.unicom.admin.model.Meeting;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//告诉mybatis此接口包含访问数据库的操作
@Mapper
public interface MeetingDao {
    @Select("select * from meeting")
        //显示全部数据
    List<Meeting> getAllMeeting();

    @Select("<script>" +
            "select * from meeting where 1=1" +
            "<if test='meetingName!=null and meetingName!=\"\"'>" +
            " and meetingName like '%${meetingName}%'" +
            "</if>" +
            "<if test='peopleNum!=null and peopleNum!=\"\"'>" +
            " and peopleNum &gt;= #{peopleNum}" +
            "</if>" +
            "<if test='order!=null and order==\"+id\"'>" +
            " order by id asc" +
            "</if>" +
            "<if test='order!=null and order==\"-id\"'>" +
            " order by id desc" +
            "</if>" +
            "</script>")
    List<Meeting> getMeetingByCondition(
            @Param("meetingName") String meetingName,
            @Param("peopleNum") String peopleNum,
            @Param("order") String order
    );
    //删除
    @Delete("delete from meeting where id=#{id}")
    int deleteMeetig(int id);
    //新增
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    @Insert("insert into meeting" +
            "(meetingName, meetingPosition,peopleNum, ifMore,ifOpen) values" +
            "(#{meetingName},#{meetingPosition},#{peopleNum},#{ifMore},#{ifOpen})")
    int saveOne(Meeting meeting);
    //修改(get)
//    @Update("update meeting set meetingName=#{meetingName},meetingPosition=#{meetingPosition},peopleNum=#{peopleNum},ifMore=#{ifMore},ifOpen=#{ifOpen}" +
//            " where id=#{id}")
//    int updateMeeting(
//            @Param("id") int id,
//            @Param( "meetingName") String meetingName,
//            @Param( "meetingPosition") String meetingPosition,
//            @Param( "peopleNum") int peopleNum,
//            @Param( "ifMore") int ifMore,
//            @Param( "ifOpen") int ifOpen
//    );
    //修改post
    @Update("update meeting set meetingName=#{meetingName},meetingPosition=#{meetingPosition},peopleNum=#{peopleNum},ifMore=#{ifMore},ifOpen=#{ifOpen}" +
            " where id=#{id}")
    int updateMeeting(Meeting meeting);



//    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
//    int insert(Meeting record);
//
//    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
//    int insertSelective(Meeting record);
}