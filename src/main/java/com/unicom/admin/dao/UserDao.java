package com.unicom.admin.dao;

import com.unicom.admin.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectKey;

/*
* 需求描述：用户管理，用户信息操作类，访问userlist表的操作
* author:liufeng
* time:2019.05.21 14:47
* */

public interface UserDao {
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