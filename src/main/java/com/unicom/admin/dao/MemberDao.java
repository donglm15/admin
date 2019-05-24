package com.unicom.admin.dao;

import com.unicom.admin.model.Member;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberDao {

    @Select("select * from member")
    @Results({
            @Result(column = "membertypeid",
                    property = "memberType",
                    one = @One(select = "com.unicom.admin.dao.MemberTypeDao.getMemberTypeById",
                            fetchType = FetchType.EAGER)
            )
    })
    List<Member> getAllMember();

    @Insert("insert into member" +
            "(date,membertypeid,title,content,author,`readings`)values" +
            "(#{date},#{membertypeid},#{title},#{content},#{author},#{readings})")
    int save(
            @Param("date") String date,
            @Param("membertypeid") int membertypeid,
            @Param("title") String title,
            @Param("content") String content,
            @Param("author") String author,
            @Param("readings") int readings
    );

    @Select("select * from member where id =#{id}")
    @Results({
            @Result(column = "membertypeid",
                    property = "memberType",
                    one = @One(select = "com.unicom.admin.dao.MemberTypeDao.getMemberTypeById",
                            fetchType = FetchType.EAGER)
            )
    })
    Member getMemberById(int id);

    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @Insert("insert into member" +
            "(date,membertypeid,title,content,author,`readings`) values" +
            "(#{date},#{membertypeid},#{title},#{content},#{author},#{readings})")
    int saveOne(Member member);


    @Select("<script>" +
            "select * from member where 1=1" +
            "<if test='title!=null and title!=\"\"'>" +
            "and title like '%${title}%'" +
            "</if>" +
            "<if test='type!=null and type!=\"\"'>" +
            "and membertypeid like '%${type}%'" +
            "</if>" +
            "<if test='sort!=null and sort==\"+id\"'>" +
            "order by id asc" +
            "</if>" +
            "<if test='sort!=null and sort==\"-id\"'>" +
            "order by id desc" +
            "</if>" +
            "</script>")
    @Results({
            @Result(column = "membertypeid",
                    property = "memberType",
                    one = @One(select = "com.unicom.admin.dao.MemberTypeDao.getMemberTypeById",
                            fetchType = FetchType.EAGER)
            )
    })
    List<Member> getMemberByCondition(
            @Param("title") String title,
            @Param("type") String type,
            @Param("sort") String sort
    );

    @Delete("delete from member where id=#{id}")
    int deleteMemberById(int id);


    @Update("update member set date=#{date},membertypeid=#{memberType.id}," +
            "title=#{title},content=#{content},`readings`=#{readings} where id=#{id}")
    int updateMember(Member member);

    @Update("update membertype set typename=#{typename}"+"where id=#{id}")
    int updateMemberType(
            @Param("id") int id,
            @Param("typename") String typename
    );

    @Insert({"insert into member (date,id,title,membertypeid,content,author,readings)",
            "(#{date},#{id},#{title},#{membertypeid},#{content},#{author},#{readings})"})
    int insertMember(Member member);

    @Insert("insert into membertype (typename) value (#{typename})")
    int insertMemberType(String typename);

}
