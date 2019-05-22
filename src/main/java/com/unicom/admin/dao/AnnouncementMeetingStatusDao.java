package com.unicom.admin.dao;

import com.unicom.admin.model.AnnouncementMeetingStatus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;

public interface AnnouncementMeetingStatusDao {
    @Insert({
        "insert into announcementmeetingstatus (meetingStatus)",
        "values (#{meetingStatus,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    int insert(AnnouncementMeetingStatus record);

    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    int insertSelective(AnnouncementMeetingStatus record);
}