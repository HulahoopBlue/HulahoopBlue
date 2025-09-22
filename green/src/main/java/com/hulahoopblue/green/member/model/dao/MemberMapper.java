package com.hulahoopblue.green.member.model.dao;

import com.hulahoopblue.green.member.model.dto.MemberDTO;
import com.hulahoopblue.green.merchant.model.dto.MerchantDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    MemberDTO selectMemberById(String id);

    List<MemberDTO> selectAllMembers();

    List<MemberDTO> selectMembersByCriteria(String categoryCd, String merchantNum, String searchText);

    List<MerchantDTO> selectMerchantList();  // 반환 타입 MerchantDTO

    List<String> selectCategoryList();
}
