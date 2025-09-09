package com.ohgiraffers.hulahoopblue.usehistory.controller;

import com.ohgiraffers.hulahoopblue.usehistory.model.dto.UseHistoryDTO;
import com.ohgiraffers.hulahoopblue.usehistory.model.service.UseHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/useHistory")
public class UseHistoryController {

    private final UseHistoryService useHistoryService;

    public UseHistoryController(UseHistoryService useHistoryService) {
        this.useHistoryService = useHistoryService;
    }

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<UseHistoryDTO> paging = useHistoryService.findAllMenu1(page);
        model.addAttribute("paging", paging);
        return "useHistory/list";
    }

    @GetMapping("/regist")
    public void registPage() {}

    @PostMapping("/regist")
    public String registMenu(UseHistoryDTO newMenu, RedirectAttributes rttr) {

        useHistoryService.registNewMenu(newMenu);
        rttr.addFlashAttribute("successMessage", "신규 메뉴 등록에 성공하였습니다.");

        return "redirect:/useHistory/list";
    }

    @GetMapping("/modify")
    public String getModifyPage() {
        return "useHistory/modify";
    }

    @PostMapping("/modify")
    public String modifyMenu(@ModelAttribute UseHistoryDTO newMenu, RedirectAttributes rttr) {
        useHistoryService.modifyMenu(newMenu);
        rttr.addFlashAttribute("successMessage", "메뉴 수정에 성공하였습니다.");

        return "redirect:/useHistory/list";
    }

    @GetMapping(value = "name", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<String> findAllName() {

        List<String> menuNames = useHistoryService.findAllName();

        return menuNames;
    }

    @GetMapping("/delete")
    public String getDeletePage() {
        return "useHistory/delete";
    }

    @PostMapping("/delete")
    public String DeleteMenu(@ModelAttribute UseHistoryDTO newMenu, RedirectAttributes rttr) {
        useHistoryService.deleteMenu(newMenu);
        rttr.addFlashAttribute("successMessage", "메뉴 삭제에 성공하였습니다.");

        return "redirect:/useHistory/list";
    }
}
