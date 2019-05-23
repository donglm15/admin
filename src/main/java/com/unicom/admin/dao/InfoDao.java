package com.unicom.admin.dao;

import com.unicom.admin.model.Info;
import com.unicom.admin.model.InfoExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface InfoDao {

    /**
     * 获取全部资讯
     * @return
     */
    @Select("select * from info")
    @Results({
            @Result(column = "infotypeid",
                    property = "infoType",
                    one = @One(select = "com.unicom.admin.dao.InfoTypeDao.getInfoTypeById",
                    fetchType = FetchType.EAGER)
            )
    })
    List<Info> getAllInfo();

    /**
     * 获取特定资讯列表
     * @param title
     * @param type
     * @return
     */
    @Select("<script>" +
                "select * from info where 1=1" +
            "<if test='title!=null and title!=\"\"'>" +
                "and title like '%${title}%'" +
            "</if>" +
            "<if test='type!=null and type!=\"\"'>" +
            "and infoTypeId = #{type}" +
            "</if>" +
            "order by id desc" +
            "</script>")
    @Results({
            @Result(
                    column = "infoTypeId",
                    property = "infoType",
                    one = @One(select = "com.unicom.admin.dao.InfoTypeDao.getInfoTypeById",
                            fetchType = FetchType.EAGER)
            )
    })
    List<Info> getInfoByCondition(
            @Param("title") String title,
            @Param("type") String type
    );

    /**
     * 编辑资讯详情时更新数据库
     * @param id
     * @param title
     * @param content
     * @param date
     * @param infoTypeId
     * @return
     */
    @Update("update info set title = #{title} , " +
            "content = #{content} , date = #{date} " +
            ", infoTypeId = #{infoTypeId} " +
            "where id = #{id}")
    int updateInfoByEdit(
            @Param("id") int id,
            @Param("title") String title,
            @Param("content") String content,
            @Param("date") String date,
            @Param("infoTypeId") int infoTypeId
    );

    /**
     * 根据id删除一条资讯
     * @param id
     * @return
     */
    @Delete("delete from info where id=#{id}")
    int deleteInfoByd(int id);

    /**
     * 根据id获取一条资讯
     * @param id
     * @return
     */
    @Select("select * from info where id=#{id}")
    @Results({
            @Result(column = "infoTypeId",
                    property = "infoType",
                    one = @One(select = "com.unicom.admin.dao.InfoTypeDao.getInfoTypeById",
                                fetchType = FetchType.EAGER)
            )
    })
    Info getInfoById(int id);

    /**
     * 根据id将该资讯浏览量加一
     * @param id
     * @return
     */
    @Update("update info set `read` = `read`+1 " +
            "where id = #{id}")
    int updateRead(
            @Param("id") int id
    );

    /**
     * 点赞数、收藏数的增减
     * @param id
     * @param likeFlag
     * @param flag
     * @return
     */
    @Update("<script>" +
            "update info set " +
            "<if test='likeFlag == true'>" +
            "`like` = `like`" +
            "</if>" +
            "<if test='likeFlag == false'>" +
            "favorite = favorite" +
            "</if>" +
            "<if test='flag == true'>" +
            "+" +
            "</if>" +
            "<if test='flag == false'>" +
            "-" +
            "</if>" +
            "1 where id = #{id}" +
            "</script>")
    int updateLikeFavo(
            @Param("id") int id,
            @Param("likeFlag") boolean likeFlag,
            @Param("flag") boolean flag
    );

    /**
     * 新增一条资讯（post）
     * @param info
     * @return
     */
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    @Insert("insert into info" +
            "(date,infoTypeId,title,content,`read`,imgUrl,`like`,favorite) values" +
            "(#{date},#{infoType.id},#{title},#{content},#{read},#{imgUrl},#{like},#{favorite})")
    int insert(Info info);
}