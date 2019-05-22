package com.unicom.admin.dao;

import com.unicom.admin.model.position;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/*
* 需求描述：用户管理，用户职位类别操作类，访问positiontype表的操作
* author:liufeng
* time:2019.05.21 14:47
* */

@Repository
@Mapper
public interface PositionTypeDao {

    //通过id值找出对应的职位类别名称
    @Select("select * from positiontype where id = #{id}") //#{}占位符
    @Results({
            @Result(column = "positionName",property = "positionName")
    })//数据库中表的字段名，与Java类中的属性名，之间的映射关系的更改
    position getPositionTypeById(int id);  //由id获取职位类别


    @Insert({
        "insert into positiontype (positionName)",
        "values (#{positionName,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    int insert(position record);
}