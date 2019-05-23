package com.unicom.admin.service;

import com.unicom.admin.dao.PageProduceDao;
import com.unicom.admin.model.PageProduce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageProduceService {

    @Autowired
    private PageProduceDao pageProduceDao;

    public List<PageProduce> getAllPageProduce(){
        return pageProduceDao.getAllPageProduce();
    }

    //后端分页查询
    public List<PageProduce> getPageProduceByCon(String produce_name, int produce_importance, String produce_type, String order
    ){
        return pageProduceDao.getPageProduceByCondition(produce_name,produce_importance,produce_type,order);
    }

    //新增（get）
    public int insert(int produce_id, String produce_datatime,
                      String produce_type, String produce_name, String produce_team_name,
                      int produce_importance, String produce_details){
        return pageProduceDao.save(produce_id, produce_datatime, produce_type, produce_name, produce_team_name, produce_importance, produce_details);
    }

    //新增（post）
    public int insert(PageProduce pageProduce){
        pageProduceDao.saveOne(pageProduce);
        System.out.println(pageProduce.getProduce_id());
        return pageProduce.getProduce_id();
    }

    public PageProduce getPageProduceById(int produce_id){
        return pageProduceDao.getPageProduceById(produce_id);
    }



//    @Transactional(propagation = Propagation.REQUIRED)
//    public void insertPageProduce(PageProduce pageProduce){
//        //1、插入新的新闻类别数据
//        newsTypeDao.insertOne(pageProduce.getNewsType());
//        // int i=1/0;
//        //2、插入该类别下的新的新闻数据
//        pageProduceDao.saveOne(pageProduce);
//    }
}

//      PageProduce
//      pageProduce