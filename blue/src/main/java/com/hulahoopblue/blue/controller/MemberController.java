package com.hulahoopblue.blue.controller;

import com.hulahoopblue.blue.config.AddressConfig;
import com.hulahoopblue.blue.model.dto.MemberDTO;
import com.hulahoopblue.blue.model.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final AddressConfig addressConfig;

    public MemberController(MemberService memberService, AddressConfig addressConfig) {
        this.memberService = memberService;
        this.addressConfig = addressConfig;
    }

    @GetMapping("/MemberInsert")
    public String signupForm(Model model) {
        model.addAttribute("apiKey", addressConfig.getApiKey());
        model.addAttribute("apiUrl", addressConfig.getApiUrl());
        return "member/MemberInsert"; // ✅ 디렉토리 명 포함

    }

    @PostMapping("/MemberInsert")
    public String insertMember(MemberDTO newMember, RedirectAttributes rttr) {
        memberService.insertNewMember(newMember);
        return "redirect:/?success=1";
    }

    @GetMapping("/checkId")
    @ResponseBody
    public String checkDuplicateId(@RequestParam String id) {
        boolean isDuplicate = memberService.isIdDuplicate(id);
        return isDuplicate ? "duplicate" : "available";
    }

    @GetMapping("/MemberSelect")
    public String findMemberList(Model model) {
        List<MemberDTO> memberList = memberService.findAllMember();
        model.addAttribute("memberList", memberList);
        return "member/MemberSelect";
    }

    @GetMapping(value = "/ms", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<MemberDTO> findMemberListJson() {
        return memberService.findAllMember();
    }

    @GetMapping(value = "/Nm", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<MemberDTO> findNmList() {
        return memberService.findAllMember();
    }

    @GetMapping("/MemberUpdate")
    public void updatePage() {}

    @PostMapping("/MemberUpdate")
    public String updateMember(MemberDTO newMember, RedirectAttributes rttr) {
        memberService.updateNewMember(newMember);
        rttr.addFlashAttribute("successMessage", "신규 메뉴 수정에 성공하였습니다.");
        return "redirect:/member/MemberSelect";
    }

    @GetMapping("/MemberDelete")
    public void deletePage() {}

    @PostMapping("/MemberDelete")
    public String deleteMember(MemberDTO newMember, RedirectAttributes rttr) {
        memberService.deleteNewMember(newMember);
        rttr.addFlashAttribute("successMessage", "신규 회원 삭제에 성공하였습니다.");
        return "redirect:/member/MemberSelect";
    }
}

