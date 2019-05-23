package com.unicom.admin.dao;

import com.unicom.admin.model.MemberType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberTypeDao {

    @Select("select * from memberType where id=#{id}")
    @Results({
            @Result(column = "typename",property = "type"),
            @Result(column = "typename",property = "typename")
    })
    MemberType getMemberTypeById(int id);

    @Select("select * from memberType")
    List<MemberType> getAllMemberType();

    @Delete("delete from memberType where id=#{id}")
    int deleteMemberType(int id);

    @Insert("insert into memberType (typename) value (#{typename})")
    int insertMemberType(String typename);

    @Update("update memberType set typename=#{typename}"+ "where id=#{id}")
    int updateMemberType(
            @Param("id") int id,
            @Param("typename") String typename
    );

    @Insert("insert into memberType(typename) value (#{typeName})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insertOne(MemberType memberType);
//    @Insert({
//        "insert into membertype (membertypename)",
//        "values (#{membertypename,jdbcType=VARCHAR})"
//    })
//    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
//    int insert(MemberType record);
//
//    @InsertProvider(type=MemberTypeSqlProvider.class, method="insertSelective")
//    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
//    int insertSelective(MemberType record);
}