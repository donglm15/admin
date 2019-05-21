package com.unicom.admin.dao;

import com.unicom.admin.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* 需求描述：用户管理，用户信息数据库表操作类（Dao），访问userlist表的操作
* author:liufeng
* time:2019.05.21 14:47
* */

//访问userlist表的操作，数据访问的对象
@Repository  //告诉MyBatis此接口包含访问数据库的操作
@Mapper   //注解
public interface UserDao {

    //查询userlist表所有数据（没有后端分页的）
    @Select("select * from userlist") //数据库查询操作，getAllNews方法中的具体执行的查询语句
    @Results({
            @Result(column = "position",//数据库表列名
                    property = "position",//User类中的属性名
                    one = @One(select = "com.unicom.admin.dao.PositionTypeDao.getPositionTypeById",
                            fetchType = FetchType.EAGER)
            )
    }) //返回结果值(每一个结果项)的映射关系(一个@Rlt对应一个数据列)
    List<User> getAllUser();  //返回类型为List<User>（元素为User的List）的方法


    @Insert({
        "insert into userlist (account, userName, ",
        "Organization, positiontypeid, ",
        "employeeNumber, phone, ",
        "lastLoginTime, profileAddress, ",
        "introduction, speciality, ",
        "activity)",
        "values (#{account,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{organization,jdbcType=VARCHAR}, #{positiontypeid,jdbcType=TINYINT}, ",
        "#{employeeNumber,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{lastLoginTime,jdbcType=TIMESTAMP}, #{profileAddress,jdbcType=VARCHAR}, ",
        "#{introduction,jdbcType=VARCHAR}, #{speciality,jdbcType=VARCHAR}, ",
        "#{activity,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    int insert(User record);
}