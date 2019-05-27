package com.unicom.admin.dao;

import com.unicom.admin.model.InfoType;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface InfoTypeDao {

    /**
     * 根据ID查询资讯类别
     * @param id
     * @return
     */
   @Select("select * from infoType where id=#{id}")
    InfoType getInfoTypeById(int id);
}