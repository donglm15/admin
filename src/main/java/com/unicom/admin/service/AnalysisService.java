package com.unicom.admin.service;


import com.unicom.admin.dao.AnalysisDao;
import com.unicom.admin.model.Analysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisService {
    @Autowired
    private AnalysisDao analysisDao;

    public List<Analysis> getAll(){
        return analysisDao.getAll();
    }

    public int insert(String product,String date,int region,int person,float billing,float tratio,float hratio){
        return analysisDao.save(product,date,region,person,billing,tratio,hratio);
    }

    public int update(Analysis analysis){
        return analysisDao.updateByPrimaryKey(analysis);
    }

    public int delete(int id){
        return analysisDao.deleteByPrimaryKey(id);
    }

    public List<Analysis> getByCon(
            String startDate,String endDate,String region,String product
    ){
        return analysisDao.getByCondition(startDate,endDate,region,product);
    }
}
