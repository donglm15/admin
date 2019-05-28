package com.unicom.admin.service;

import com.unicom.admin.dao.AnnouncementDao;
import com.unicom.admin.model.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementDao announcementDao;

    public List<Announcement> getAllAnnouncement(){return announcementDao.getAllAnnouncement();}

    //后端分页查询
    public List<Announcement> getAnnouncementByCon(String meetingID, String meetingStatus, String meetingPosition,String department,
                                                   String meetingTheme,String startDateTime,String endDateTime){
        return announcementDao.getAnnouncementByCondition(meetingID,meetingStatus,meetingPosition,department,
                meetingTheme,startDateTime,endDateTime);
    }

    //删除
    public int delete(int id){
        return announcementDao.deleteAnnouncement(id);
    }
    //新增
    public int insertOne(Announcement announcement){
        announcementDao.saveOne(announcement);
//        System.out.println(announcement.getId());
        return announcement.getId();
    }
    //修改delay
//    public int update(int statusid,Announcement announcement){
//        return announcementDao.updateDelay(statusid,announcement);
//    }
    public int update(Announcement announcement){
        return announcementDao.updateDelay(announcement);
    }
}
