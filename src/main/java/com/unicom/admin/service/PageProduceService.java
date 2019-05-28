package com.unicom.admin.service;

import com.unicom.admin.dao.PageProduceDao;
import com.unicom.admin.model.Notice;
import com.unicom.admin.model.PageProduce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageProduceService {

    @Autowired
    private PageProduceDao pageProduceDao;

    public List<PageProduce> getAll(){
        return pageProduceDao.getAll();
    }

    //后端分页查询
    public List<PageProduce> getAllPageProduce(String produce_name, int produce_importance,  String order,String produce_type
    ){
        return pageProduceDao.getAllPageProduce(produce_name,produce_importance,order,produce_type);
    }

//    //新增（get）
//    public int insert(int produce_id, String produce_datatime,
//                      String produce_type, String produce_name, String produce_team_name,
//                      int produce_importance, String produce_details){
//        return pageProduceDao.save(produce_id, produce_datatime, produce_type, produce_name, produce_team_name, produce_importance, produce_details);
//    }

    //新增（post）
    public int insertPageProduce(PageProduce pageProduce){
        return pageProduceDao.insertPageProduce(pageProduce);
    }



    //删
    public int deletePageProduce(int produce_id){
        return pageProduceDao.deletePageProduce(produce_id);
    }

    //获取产品详情
    public PageProduce getOnePageProduce(int produce_id){
        return pageProduceDao.getOnePageProduce(produce_id);
    }

    //更新产品信息
    public int updatePageProduce(PageProduce pageProduce){
        return pageProduceDao.updatePageProduce(pageProduce);
    }


//    pageProduce
//            PageProduce

}

//      PageProduce
//      pageProduce