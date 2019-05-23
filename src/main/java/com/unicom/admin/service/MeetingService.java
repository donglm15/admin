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

    //会议室地点数据封装
    public List<String> getMeetingPlace(){
        return meetingDao.getMeetingPlace();
    }


    //后端分页查询
    public List<Meeting> getMeetingByCon(String meetingName,String peopleNum,String order){
        return meetingDao.getMeetingByCondition(meetingName,peopleNum,order);
    }

    //删除
    public int delete(int id){
        return meetingDao.deleteMeetig(id);
    }
    //新增
    public int insertOne(Meeting meeting){
        meetingDao.saveOne(meeting);
        System.out.println(meeting.getId());
        return meeting.getId();
    }
    //修改
//    public int update(int id,String meetingName,String meetingPosition,int peopleNum,int ifMore,int ifOpen){
//        return meetingDao.updateMeeting(id,meetingName,meetingPosition,peopleNum,ifMore,ifOpen);
//    }
    public int update(Meeting meeting){
        return meetingDao.updateMeeting(meeting);
    }

}
