package com.hulahoopblue.white.member.model.dao;


import com.hulahoopblue.white.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberDAO {

    List<MemberDTO> findAllMember();

    MemberDTO selectMemberById(@Param("id") String id);
}
