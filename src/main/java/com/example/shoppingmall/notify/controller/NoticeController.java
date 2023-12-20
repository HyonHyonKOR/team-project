package com.example.shoppingmall.notify.controller;

import com.example.shoppingmall.notify.dto.NoticeAddDTO;
import com.example.shoppingmall.notify.dto.NoticeDeleteDTO;
import com.example.shoppingmall.notify.dto.NoticeListDTO;
import com.example.shoppingmall.notify.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notice")//절대경로
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    /*공지사항 리스트 출력*/
    @GetMapping("/admin")
    public String showNoticeList(Model model){
        model.addAttribute("noticeListDTOList", noticeService.findAllNotice());
        return "admins/notice/admins-notice";
    }
    /*공지사항 디테일*/
    @GetMapping("/admin/{noticeNo}")
    public String showNoticeDetail(@PathVariable(name="noticeNo")Integer noticeNo, Model model){
        return "admins/notice/admins-notice-detail";
    }
    /*공지사항 작성페이지 이동*/
    @GetMapping("/admin/add")
    public String goToRegisterNoticePage(){
        return "admins/notice/admins-notice-add";
    }
    /*공지사항 작성실행*/

    @PostMapping("/admin/add")
    public String registerNotice(@RequestParam("adminNo") Long adminNo, @ModelAttribute NoticeAddDTO noticeAddDTO){
        noticeService.addNotice(adminNo, noticeAddDTO);
        return "redirect:/notice/admin";
    }
    /*공지사항 수정페이지*/
    @GetMapping("/admin/{noticeNo}/update")
    public String goToUpdateNoticePage(@PathVariable(name="noticeNo")Long noticeNo, Model model){
        return "admins/notice/admins-notice-modify";
    }
    /*공지사항 수정실행*/
    @PostMapping("/admin/{noticeNo}/update")
    public String updateNotice(@PathVariable(name= "noticeNo") Long noticeNo, Model model){
        return "admins/notice/admins-notice-modify";
    }
    /*공지사항 삭제*/
    @PostMapping("/admin/{noticeNo}/delete")
    public String deleteNotice(@PathVariable(name= "noticeNo") Long noticeNo, NoticeDeleteDTO noticeDeleteDTO, Model model){

        return "admins/notice";
    }
}
