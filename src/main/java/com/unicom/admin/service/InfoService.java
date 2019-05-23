package com.unicom.admin.service;

import com.unicom.admin.dao.InfoDao;
import com.unicom.admin.model.Info;
import org.apache.ibatis.annotations.Param;
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

    public int updateInfoByEdit(int id,String title,String content,String date,int infoTypeId){
        return infoDao.updateInfoByEdit(id,title,content,date,infoTypeId);
    }

    public int deleteInfoByd(int id){
        return infoDao.deleteInfoByd(id);
    }

    public Info getInfoById(int id){
        return infoDao.getInfoById(id);
    }

    public int updateRead(int id){
        return infoDao.updateRead(id);
    }

    public int updateLikeFavo(int id,boolean likeFlag,boolean flag){
        return infoDao.updateLikeFavo(id,likeFlag,flag);
    }

    public int insert(Info info){
        infoDao.insert(info);
        return info.getId();
    }
}
