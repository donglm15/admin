package com.unicom.admin.dao;

import com.unicom.admin.model.Announcement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;

public interface AnnouncementDao {
    @Insert({
        "insert into announcement (meetingID, meetingTheme, ",
        "department, meetingDate, ",
        "meetingStatusid, meetingPosition, ",
        "delayDate, meetingType, ",
        "user, meetingPeople, ",
        "dateLong, Presenter, ",
        "Data, meetingContent, ",
        "msg)",
        "values (#{meetingID,jdbcType=VARCHAR}, #{meetingTheme,jdbcType=VARCHAR}, ",
        "#{department,jdbcType=VARCHAR}, #{meetingDate,jdbcType=TIMESTAMP}, ",
        "#{meetingStatusid,jdbcType=TINYINT}, #{meetingPosition,jdbcType=VARCHAR}, ",
        "#{delayDate,jdbcType=TIMESTAMP}, #{meetingType,jdbcType=VARCHAR}, ",
        "#{user,jdbcType=VARCHAR}, #{meetingPeople,jdbcType=VARCHAR}, ",
        "#{dateLong,jdbcType=TINYINT}, #{presenter,jdbcType=VARCHAR}, ",
        "#{data,jdbcType=VARCHAR}, #{meetingContent,jdbcType=VARCHAR}, ",
        "#{msg,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    int insert(Announcement record);

    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    int insertSelective(Announcement record);
}