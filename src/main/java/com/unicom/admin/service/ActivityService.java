package com.unicom.admin.service;

import com.unicom.admin.dao.ActivityDao;
import com.unicom.admin.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
public class ActivityService {

    @Autowired
    private ActivityDao activityDao;


    public List<Activity> getAllActivity(){
        return activityDao.getAllActivity();
    }


    public List<Activity> getCon(String title, String type, String startTime, String endTime, String order){
        updateDo();
        updateDone();
        updateDoing();
        return activityDao.getActivityByCondition(title,type,startTime,endTime,order);
    }

    public int deleteActivity(int id){
        return activityDao.deleteActivity(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertActivity(Activity activity){
        activityDao.insertActivity(activity);
    }

    public int updateActivity(String people, String prize, String title, String content, Date startTime, Date endTime, int id){
        return activityDao.updateActivity(people,prize,title,content,startTime,endTime,id);
    }

    public void updateDo(){
        activityDao.updateDo();
    }

    public void updateDoing(){
        activityDao.updateDoing();
    }

    public void updateDone(){
        activityDao.updateDone();
    }
}
