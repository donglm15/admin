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

}
