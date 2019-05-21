package com.unicom.admin.dao;

import com.unicom.admin.model.Meeting;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;

public interface MeetingDao {
    @Insert({
        "insert into meeting (meetingName, meetingPosition, ",
        "peopleNum, ifMoreid, ",
        "ifOpenid)",
        "values (#{meetingName,jdbcType=VARCHAR}, #{meetingPosition,jdbcType=VARCHAR}, ",
        "#{peopleNum,jdbcType=SMALLINT}, #{ifMoreid,jdbcType=TINYINT}, ",
        "#{ifOpenid,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    int insert(Meeting record);

    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    int insertSelective(Meeting record);
}