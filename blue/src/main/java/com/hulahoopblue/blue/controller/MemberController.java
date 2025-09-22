package com.hulahoopblue.blue.controller;

import com.hulahoopblue.blue.config.AddressConfig;
import com.hulahoopblue.blue.model.dto.MemberDTO;
import com.hulahoopblue.blue.model.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return "member/MemberInsert";
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

    @GetMapping("/mypage")
    public String myPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loginMember") == null) {
            return "redirect:/login";
        }

        MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
        model.addAttribute("loginMember", loginMember);

        return "member/mypage";
    }

    @PostMapping("/login")
    public String login(@RequestParam String id, @RequestParam String pw, HttpSession session, RedirectAttributes rttr) {
        MemberDTO loginMember = memberService.login(id, pw);
        if (loginMember != null) {
            session.setAttribute("loginMember", loginMember);
            return "redirect:/member/mypage"; // ✅ 명확한 리다이렉트 경로
        } else {
            rttr.addFlashAttribute("error", "로그인 실패");
            return "redirect:/login";
        }
    }

    // `void` 메서드를 `String` 타입으로 변경하여 뷰를 명시적으로 반환
    @GetMapping("/MemberUpdate")
    public String updatePage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("loginMember") != null) {
            MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
            model.addAttribute("loginMember", loginMember);
        }
        return "member/MemberUpdate";
    }

    // MemberUpdate.html에서 폼 제출 시 사용하도록 변경 (JSON 응답)
    @PostMapping("/MemberUpdate")
    @ResponseBody
    public Map<String, String> memberUpdate(@RequestBody MemberDTO memberDTO, HttpServletRequest request) {

        // ✅ 실제 회원 정보 업데이트 로직 추가
        memberService.updateMember(memberDTO);

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.setAttribute("loginMember", memberDTO);
        }

        Map<String, String> response = new HashMap<>();
        response.put("redirectUrl", "/member/mypage");
        return response;
    }

    @GetMapping("/MemberDelete")
    public String deletePage() {
        return "member/MemberDelete";
    }

    @PostMapping("/MemberDelete")
    public String deleteMember(MemberDTO memberDTO, RedirectAttributes rttr) {
        memberService.deleteMember(memberDTO); // ✅ 메서드명 변경 (deleteMember가 더 명확함)
        rttr.addFlashAttribute("successMessage", "회원 삭제에 성공하였습니다.");
        return "redirect:/login";
    }
}