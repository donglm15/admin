package com.unicom.admin.dao;

import com.unicom.admin.model.Notice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Mapper
public interface NoticeDao {
    @Select("<script>" +
            "select * from notice where 1=1" +
            "<if test='noticeTitle!=null and noticeTitle!=\"\"'>" +
            "and noticeTitle like '%${noticeTitle}%'"+
            "</if>"+
            "<if test='noticePublish!=null and noticePublish!=\"\"'>" +
            "and noticePublish like '%${noticePublish}%'"+
            "</if>"+
            "<if test='noticeStatus!=null and noticeStatus!=\"\"'>" +
            "and noticeStatus like '%${noticeStatus}%'"+
            "</if>"+
            "<if test='order!=null and order==\"+id\"'>" +
            "order by noticeId asc"+
            "</if>"+
            "<if test='order!=null and order==\"-id\"'>" +
            "order by noticeId desc"+
            "</if>"+
            "</script>")
    List<Notice> getAllNotice(
            @Param("noticeTitle") String noticeTitle,
            @Param("noticePublish") String noticePublish,
            @Param("order") String order,
            @Param("noticeStatus") String noticeStatus
    );

    @Select("select distinct noticePublish from notice")
    ArrayList<String> getAllPublish();

    @Delete("delete from notice where noticeId=#{noticeId}")
    int deleteNotice(int noticeId);

    @Insert({"insert into notice (noticeDate, noticePublish, noticeTitle, noticeContent, noticeReadNum, noticeStatus)",
            "values (#{noticeDate}, #{noticePublish}, #{noticeTitle}, #{noticeContent}, #{noticeReadNum}, #{noticeStatus})"})
    int insertNotice(Notice notice);

    @Select("select * from notice where noticeId=#{noticeId}")
    Notice getOneNotice(int noticeId);

    @Update({
            "update notice",
            "set noticeDate = #{noticeDate},",
            "noticePublish = #{noticePublish},",
            "noticeTitle = #{noticeTitle},",
            "noticeContent = #{noticeContent},",
            "noticeReadNum = #{noticeReadNum},",
            "noticeStatus = #{noticeStatus}",
            "where noticeId = #{noticeId}"
    })
    int updateNotice(Notice notice);

    @Update("update notice set noticeStatus=#{noticeStatus} where noticeId=#{noticeId}")
    int updateStatus(@Param("noticeId") int noticeId,
                     @Param("noticeStatus") String noticeStatus);
}
