package com.unicom.admin.service;

import com.unicom.admin.dao.NoticeDao;
import com.unicom.admin.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeService {
    @Autowired
    private NoticeDao noticedao;

    public List<Notice> getAllNotices(String noticeTitle,String noticePublish,String order,String noticeStatus){
        return noticedao.getAllNotice(noticeTitle,noticePublish,order,noticeStatus);
    }

    public ArrayList<String> getAllPublish(){
        return noticedao.getAllPublish();
    }

    public int deleteNotice(int noticeId){
        return noticedao.deleteNotice(noticeId);
    }

    public int insertNotice(Notice notice){
        return noticedao.insertNotice(notice);
    }

    public Notice getOneNotice(int noticeId){
        return noticedao.getOneNotice(noticeId);
    }

    public int updateNotice(Notice notice){
        return noticedao.updateNotice(notice);
    }

    public int updateStatus(int noticeId, String noticeStatus){
        return noticedao.updateStatus(noticeId, noticeStatus);
    }
}
