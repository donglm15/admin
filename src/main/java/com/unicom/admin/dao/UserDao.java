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


    //后端分页（查询符合条件的用户数据）
    @Select("<script>" +
            "select * from userlist where 1=1" +
            "<if test='account!=null and account!=\"\"'>" +
            " and account like '%${account}%'" +
            "</if>" +
            "<if test='userName!=null and userName!=\"\"'>" +
            " and userName like '%${userName}%'" +
            "</if>" +
            "<if test='Organization!=null and Organization!=\"\"'>" +
            " and Organization like '%${Organization}%'" +
            "</if>" +
            "<if test='employeeNumber!=null and employeeNumber!=\"\"'>" +
            " and employeeNumber like '%${employeeNumber}%'" +
            "</if>" +
            "<if test='phone!=null and phone!=\"\"'>" +
            " and phone like '%${phone}%'" +
            "</if>" +

            "<if test='position!=null and position!=\"\"'>" +
            " and position = #{position}" +
            "</if>" +

            "<if test='startDateTime!=null and startDateTime!=\"\"'>" +
            " and lastLoginTime &gt; #{startDateTime}" +
            "</if> " +

            "<if test='endDateTime!=null and endDateTime!=\"\"'>" +
            " and lastLoginTime &lt;= #{endDateTime}" +
            "</if> " +

            "<if test='order!=null and order==\"+id\"'>" +
            " order by id asc" +
            "</if>" +
            "<if test='order!=null and order==\"-id\"'>" +
            " order by id desc" +
            "</if>" +

            "</script>")
    @Results({
            @Result(column = "position",//数据库表列名
                    property = "position",//User类中的属性名
                    one = @One(select = "com.unicom.admin.dao.PositionTypeDao.getPositionTypeById",
                            fetchType = FetchType.EAGER)
            )
    }) //返回结果值(每一个结果项)的映射关系(一个@Rlt对应一个数据列)
    List<User> getUserByCondition(
            @Param("account") String account, //用户名
            @Param("userName") String userName,  //姓名
            @Param("Organization") String Organization, //组织机构
            @Param("position") String position,  //职位
            @Param("employeeNumber") String employeeNumber,  //员工号
            @Param("phone") String phone,  //电话
            @Param("startDateTime") String startDateTime, //最后登录时间(开始)
            @Param("endDateTime") String endDateTime, //最后登录时间(截止)
            @Param("order") String order  //排序
    );

    //新增用户数据（get方式）
    @Insert("insert into userlist " +
            "(account,userName,Organization,position,employeeNumber,phone,lastLoginTime) values" +
            "(#{account},#{userName},#{Organization},#{position},#{employeeNumber},#{phone},#{lastLoginTime})")
    int save(
            @Param("account") String account,
            @Param("userName") String userName,
            @Param("Organization") String Organization,
            @Param("position") int position,
            @Param("employeeNumber") String employeeNumber,
            @Param("phone") String phone,
            @Param("lastLoginTime") String lastLoginTime
    );

    //新增用户数据(post方式)
    @Options(useGeneratedKeys =  true, keyColumn = "id",keyProperty = "id") //useGeneratedKeys:主键是否为自增
    @Insert("insert into userlist " +
            "(account,userName,Organization,position,employeeNumber,phone,lastLoginTime) values" +
            "(#{account},#{userName},#{Organization},#{position.id},#{employeeNumber},#{phone},#{lastLoginTime})")
    int saveOne(User user);

    //由id获取用户数据详情
    @Select("select * from userlist where id = #{id}")
    @Results({
            @Result(column = "position",//数据库表列名
                    property = "position",//User类中的属性名
                    one = @One(select = "com.unicom.admin.dao.PositionTypeDao.getPositionTypeById",
                            fetchType = FetchType.EAGER)
            )
    }) //返回结果值(每一个结果项)的映射关系(一个@Rlt对应一个数据列)
    User getUserById(int id);

    //由id修改一条用户信息（post方式）
    @Update({"update userlist set account=#{account},userName=#{userName},Organization=#{Organization},position=#{position.id},employeeNumber=#{employeeNumber},phone=#{phone},lastLoginTime=#{lastLoginTime}" +
            "where id=#{id}"})
    //以实体类（post）形式传递参数
    int updateUser(User user);

//    //由id修改一条用户信息（get方式）
//    @Update({"update userlist set account=#{account},userName=#{userName},Organization=#{Organization},position=#{position.id},employeeNumber=#{employeeNumber},phone=#{phone},lastLoginTime=#{lastLoginTime}" +
//            "where id=#{id}"})
//    int updateUser(@Param("id") int id,
//                   @Param("account") String account,
//                   @Param("userName") String userName,
//                   @Param("Organization") String Organization,
//                   @Param("position") int position,
//                   @Param("employeeNumber") String employeeNumber,
//                   @Param("phone") String phone,
//                   @Param("lastLoginTime") String lastLoginTime
//                   );

    //根据id删除一条用户信息
    @Delete("delete from userlist where id = #{id}")
    int deleteUser(int id);

}