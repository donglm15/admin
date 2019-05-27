package com.unicom.admin.service;

import com.unicom.admin.dao.MemberDao;
import com.unicom.admin.dao.MemberTypeDao;
import com.unicom.admin.model.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;

    @Autowired
    private MemberTypeDao memberTypeDao;

    public List<Member> getAllMember(){
        return memberDao.getAllMember();
    }

    public int insert(String date,int membertypeid,
                      String title,String content,String author,int readings){
        return memberDao.save(date,membertypeid,title,content,author,readings);
    }
    public int insert(Member member){
        memberDao.saveOne(member);

        return member.getId();

    }

  public Member getMemberById(int id){
        return memberDao.getMemberById(id);
  }
  public List<Member> getMemeberByCon(String title,String type,String order){
      return memberDao.getMemberByCondition(title,type,order);
  }

//    @Transactional(propagation = Propagation.REQUIRED)
//    public void insertMember(Member member){
//      memberTypeDao.insertOne(member.getMemberType());
//      memberDao.saveOne(member);
//    }

//    public int deleteMember(int id) {
//        return memberDao.deleteMemberById(id);
//    }

    public int deleteMemberById(int id) {
        return memberDao.deleteMemberById(id);
    }

    public int updateMember(Member member){
        return memberDao.updateMember(member);
    }

    public int update(int id,String typename){
        return memberDao.updateMemberType(id,typename);
    }

    public int insertMember(Member member){
        return memberDao.insertMember(member);


    }
}
