package com.unicom.admin.dao;

import com.unicom.admin.model.Announcement;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AnnouncementDao {
    //前端列表1
    @Select("select * from announcement")
    @Results({
            @Result(column = "meetingStatusid",
                    property = "announcementMeetingStatus",
                    one = @One(select = "com.unicom.admin.dao.AnnouncementMeetingStatusDao.getAnnouncementMeetingStatusById",
                            fetchType = FetchType.EAGER)
            )
    })
    List<Announcement> getAllAnnouncement();

    //分页
    @Select("<script>" +
            "select * from announcement where 1=1" +
            "<if test='meetingID!=null and meetingID!=\"\"'>" +
            " and meetingID like '%${meetingID}%'" +
            "</if>" +

            "<if test='meetingStatus!=null and meetingStatus!=\"\"'>" +
            " and meetingStatusid = #{meetingStatus}" +
            "</if>" +

            "<if test='meetingPosition!=null and meetingPosition!=\"\"'>" +
            " and meetingPosition = #{meetingPosition}" +
            "</if>" +

            "<if test='department!=null and department!=\"\"'>" +
            " and department like '%${department}%'" +
            "</if>" +

            "<if test='meetingTheme!=null and meetingTheme!=\"\"'>" +
            "and meetingTheme like '%${meetingTheme}%'" +
            "</if>" +

           "<if test='startDateTime!=null and startDateTime!=\"\"'>" +
            " and meetingDate &gt; #{startDateTime}" +
            "</if> " +

            "<if test='endDateTime!=null and endDateTime!=\"\"'>" +
            " and meetingDate &lt;= #{endDateTime}" +
            "</if> " +
            "order by id desc"+
            "</script>")
    @Results({
            @Result(column = "meetingStatusid",
                    property = "announcementMeetingStatus",
                    one = @One(select = "com.unicom.admin.dao.AnnouncementMeetingStatusDao.getAnnouncementMeetingStatusById",
                            fetchType = FetchType.EAGER)
            )
    })
    List<Announcement> getAnnouncementByCondition(
            @Param("meetingID") String meetingID,
            @Param("meetingStatus") String meetingStatus,
            @Param("meetingPosition") String meetingPosition,
            @Param("department") String department,
            @Param("meetingTheme") String meetingTheme,
            @Param("startDateTime") String startDateTime,
            @Param("endDateTime") String endDateTime
    );

    //删除
    @Delete("delete from announcement where id=#{id}")
    int deleteAnnouncement(int id);
    //新增
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    @Insert({
            "insert into announcement (meetingID, meetingTheme, ",
            "department, meetingDate, ",
            "meetingStatusid, meetingPosition, ",
            "meetingType, ",
            "user, meetingPeople, ",
            "dateLong, Presenter, ",
            "Data, meetingContent, ",
            "msg)",
            "values (#{meetingID,jdbcType=VARCHAR}, #{meetingTheme,jdbcType=VARCHAR}, ",
            "#{department,jdbcType=VARCHAR}, #{meetingDate,jdbcType=TIMESTAMP}, ",
            "#{announcementMeetingStatus.id,jdbcType=TINYINT}, #{meetingPosition,jdbcType=VARCHAR}, ",
            "#{meetingType,jdbcType=VARCHAR}, ",
            "#{user,jdbcType=VARCHAR}, #{meetingPeople,jdbcType=VARCHAR}, ",
            "#{dateLong,jdbcType=TINYINT}, #{presenter,jdbcType=VARCHAR}, ",
            "#{data,jdbcType=VARCHAR}, #{meetingContent,jdbcType=VARCHAR}, ",
            "#{msg,jdbcType=VARCHAR})"
    })
    int saveOne(Announcement announcement);

////    meetingDate=#{announcement.delayDate},
//    修改延迟post
//    @Update("<script>" +
//            "update announcement set meetingStatusid=#{statusid}" +
//
//            "<if test='announcement.delayDate!=null and announcement.delayDate!=\"\"'>" +
//                ",meetingDate=#{announcement.delayDate}" +
//            "</if>" +
//
//            " where id=#{announcement.id}" +
//
//            "</script>")
//    int updateDelay(
//            @Param(value = "statusid") int statusid,
//            @Param(value = "announcement") Announcement announcement);

    @Update("update announcement set meetingStatusid=#{meetingStatusid},meetingDate=#{delayDate}" +
            " where id=#{id}")
    int updateDelay(
//            @Param(value = "statusid") int statusid,
//            @Param(value = "announcement") Announcement announcement
            Announcement announcement);

}