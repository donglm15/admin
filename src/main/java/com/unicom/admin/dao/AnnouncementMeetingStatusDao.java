package com.unicom.admin.dao;

import com.unicom.admin.model.AnnouncementMeetingStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AnnouncementMeetingStatusDao {
    @Select("select * from announcementmeetingstatus where id=#{id}")
    @Results({
            @Result(column = "meetingStatus",property = "meetingStatus")
    })//数据库中表的字段名，与Java类中的属性名，之间的映射关系的更改
    AnnouncementMeetingStatus getAnnouncementMeetingStatusById(int id);



}