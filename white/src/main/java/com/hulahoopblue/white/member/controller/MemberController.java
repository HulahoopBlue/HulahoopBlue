package com.hulahoopblue.white.member.controller;

import com.hulahoopblue.white.member.model.dto.MemberDTO;
import com.hulahoopblue.white.member.model.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/MemberSelect")
    public String findMemberList(Model model) {

        List<MemberDTO> memberList = memberService.findAllMember();

        for (MemberDTO members : memberList) {
            System.out.println(members);
        }

        model.addAttribute("memberList", memberList);

        return "member/MemberSelect";
    }

    @GetMapping("/MemberInsert")
    public void memberInsertPage() {
    }




}
