package com.unicom.admin.service;

import com.unicom.admin.dao.InfoTypeDao;
import com.unicom.admin.model.InfoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoTypeService {
    @Autowired
    private InfoTypeDao infoTypeDao;

    public InfoType getInfoTypeById(int id){
        return infoTypeDao.getInfoTypeById(id);
    }
}
