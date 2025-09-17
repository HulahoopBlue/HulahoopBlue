package com.hulahoopblue.blue.model.dao;


import com.hulahoopblue.blue.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberDAO {

    List<MemberDTO> findAllMember();

    void insertNewMember(MemberDTO newMember);

    void updateNewMember(MemberDTO updateMember);

    void deleteNewMember(MemberDTO deleteMember);

    MemberDTO selectMemberById(@Param("id") String id);

    // ✅ 아이디 중복 확인용 메서드
    int countById(@Param("id") String id);

}
