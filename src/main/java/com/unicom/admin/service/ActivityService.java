package com.unicom.admin.service;

import com.unicom.admin.dao.ActivityDao;
import com.unicom.admin.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ActivityService {

    @Autowired
    private ActivityDao activityDao;


    public List<Activity> getAllActivity(){
        return activityDao.getAllActivity();
    }


    public List<Activity> getCon(String title, String type, String startTime, String endTime){
        return activityDao.getActivityByCondition(title,type,startTime,endTime);
    }

    public int deleteActivity(int id){
        return activityDao.deleteActivity(id);
    }
}
