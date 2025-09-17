package com.hulahoopblue.blue.model.service;

import com.hulahoopblue.blue.SHA256Util;
import com.hulahoopblue.blue.model.dao.MemberDAO;
import com.hulahoopblue.blue.model.dto.MemberDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    private final MemberDAO memberMapper;

    public MemberService(MemberDAO memberMapper) { this.memberMapper = memberMapper; }

    public List<MemberDTO> findAllMember() { return memberMapper.findAllMember(); }

    @Transactional
    public void insertNewMember(MemberDTO newMember) {
        String encryptedPw = SHA256Util.encrypt(newMember.getPw());
        newMember.setPw(encryptedPw);
        memberMapper.insertNewMember(newMember);
    }

    @Transactional
    public void updateNewMember(MemberDTO updateMember) { memberMapper.updateNewMember(updateMember); }

    @Transactional
    public void deleteNewMember(MemberDTO newMember) { memberMapper.deleteNewMember(newMember); }

    // 로그인용 조회
    public MemberDTO findById(String id) {
        return memberMapper.selectMemberById(id);
    }

    // 아이디 중복 확인
    public boolean isIdDuplicate(String id) {
        return memberMapper.countById(id) > 0;
    }

}
