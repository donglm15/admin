package com.unicom.admin.service;

import com.unicom.admin.dao.MarketDao;

import com.unicom.admin.model.Market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {
    //前端显示
    @Autowired
    private MarketDao marketDao;

    public List<Market> getAllMarket(){

        return marketDao.getAllMarket();
    }
    //后端分页
    public List<Market> getMarketByCon(String title, String importance, String marketType, String sort){
        return marketDao.getMarketByCondition(title,importance,marketType,sort);
    }
    //新增
    public int insert(Market market){
        marketDao.create(market);
        return market.getId();
    }

    //查看
    public Market getMarketById(int id){
        return  marketDao.getMarketById(id);
    }
    //编辑
    public int updateMarket(Market market){
        return  marketDao.updateMarket(market);
    }
    //删除
    public int delete(int id){
        return marketDao.deleteMarket(id);
    }
}
