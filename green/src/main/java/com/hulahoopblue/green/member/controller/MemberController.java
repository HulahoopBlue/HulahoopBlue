package com.hulahoopblue.green.member.controller;

import com.hulahoopblue.green.member.model.dto.MemberDTO;
import com.hulahoopblue.green.member.model.service.MemberService;
import com.hulahoopblue.green.merchant.model.dto.MerchantDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원관리 페이지
    @GetMapping("/memberSelect")
    public String memberPage() {
        return "member/memberSelect"; // templates/member/memberSelect.html
    }

    // 회원 조회 (JSON)
    @GetMapping(value = "/search", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<MemberDTO> searchMembers(
            @RequestParam(required = false) String categoryCd,
            @RequestParam(required = false) String merchantNum,
            @RequestParam(required = false) String searchText
    ) {
        return memberService.getMembers(categoryCd, merchantNum, searchText);
    }

    // 카테고리 조회 (JSON)
    @GetMapping(value = "/categories", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<String> categories() {
        return memberService.getCategoryList();
    }

    // 가맹점 조회 (JSON)
    @GetMapping(value = "/merchants", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<MerchantDTO> merchants() {
        return memberService.getMerchantList();
    }
}
