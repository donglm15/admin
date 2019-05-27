package com.unicom.admin.service;

import com.unicom.admin.dao.MemberTypeDao;
import com.unicom.admin.model.MemberType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberTypeService {
    @Autowired
    private static MemberTypeDao memberTypeDao;

    public MemberType getMemberTypeById(int id){
        return memberTypeDao.getMemberTypeById(id);

    }

    public static List<MemberType> getAll(){
        return memberTypeDao.getAllMemberType();

    }

    public int save(String typename){
        return memberTypeDao.insertMemberType(typename);

    }

    public int update(int id,String typename){
        System.out.println(typename);
        return memberTypeDao.updateMemberType(id,typename);

    }

    public int delete(int id){
        return memberTypeDao.deleteMemberType(id);
    }

    public int saveOne(MemberType memberType){
        return memberTypeDao.insertOne(memberType);
    }

}
