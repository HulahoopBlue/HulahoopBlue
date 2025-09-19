package com.hulahoopblue.white.member.model.service;

import com.hulahoopblue.white.member.model.dao.MemberMapper;
import com.hulahoopblue.white.member.model.dto.MemberDTO;
import com.hulahoopblue.white.merchant.model.dto.MerchantDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    // 전체 회원 조회
    public List<MemberDTO> getAllMembers() {
        return memberMapper.selectAllMembers();
    }

    // 조건별 회원 조회
    public List<MemberDTO> getMembers(String categoryCd, String merchantNum, String searchText) {
        return memberMapper.selectMembersByCriteria(categoryCd, merchantNum, searchText);
    }

    // ID로 회원 조회
    public MemberDTO findById(String id) {
        return memberMapper.selectMemberById(id);
    }

    // 가맹점 목록 조회 (MemberController API용)
    public List<MerchantDTO> getMerchantList() {
        return memberMapper.selectMerchantList();
    }

    // 카테고리 목록 조회
    public List<String> getCategoryList() {
        return memberMapper.selectCategoryList();
    }
}
