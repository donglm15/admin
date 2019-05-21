package com.unicom.admin.service;

import com.unicom.admin.dao.InfoDao;
import com.unicom.admin.model.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    private InfoDao infoDao;

    public List<Info> getAllInfo(){
        return infoDao.getAllInfo();
    }

    public List<Info> getInfoByCon(String title,String type){
        return infoDao.getInfoByCondition(title,type);
    }
}
