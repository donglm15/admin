package com.unicom.admin.dao;

import com.unicom.admin.model.PositionType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectKey;

/*
* 需求描述：用户管理，用户职位类别操作类，访问positiontype表的操作
* author:liufeng
* time:2019.05.21 14:47
* */

public interface PositionTypeDao {
    @Insert({
        "insert into positiontype (positionName)",
        "values (#{positionName,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    int insert(PositionType record);
}