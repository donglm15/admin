package com.unicom.admin.service;


import com.unicom.admin.dao.RegionDao;
import com.unicom.admin.model.RegionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    @Autowired
    private RegionDao regionDao;

    public RegionType getRegionById(int id){
        return regionDao.getRegionById(id);
    }

}
