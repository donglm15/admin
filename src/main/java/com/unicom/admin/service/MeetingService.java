package com.unicom.admin.service;

import com.unicom.admin.dao.MeetingDao;
import com.unicom.admin.model.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {
    @Autowired
    private MeetingDao meetingDao;
    //显示全部数据
    public List<Meeting> getAllMeeting(){return meetingDao.getAllMeeting();}
    //新增
//    public int insert(String meetingName,String meetingPosition,String peopleNum,int ifMoreid,int ifOpenid){
//        return meetingDao.create(meetingName,meetingPosition,peopleNum,ifMoreid,ifOpenid);
//    }

    //后端分页查询
    public List<Meeting> getMeetingByCon(String meetingName,String peopleNum,String sort){
        return meetingDao.getMeetingByCondition(meetingName,peopleNum,sort);
    }
}
