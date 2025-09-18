package com.hulahoopblue.white.member.model.service;

import com.hulahoopblue.white.member.model.dao.MemberDAO;
import com.hulahoopblue.white.member.model.dto.MemberDTO;
import com.hulahoopblue.white.SHA256Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    private final MemberDAO memberMapper;

    public MemberService(MemberDAO memberMapper) { this.memberMapper = memberMapper; }

    public List<MemberDTO> findAllMember() { return memberMapper.findAllMember(); }

    // 로그인용 조회
    public MemberDTO findById(String id) {
        return memberMapper.selectMemberById(id);
    }
}
