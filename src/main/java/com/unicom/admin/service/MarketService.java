package com.unicom.admin.service;

import com.unicom.admin.dao.MarketDao;
import com.unicom.admin.model.Market;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {
    @Autowired
    private MarketDao marketDao;
    public List<Market> getAllMarket(){

        return marketDao.getAllMarket();
    }
}
