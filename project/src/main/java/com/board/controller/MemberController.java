package com.board.controller;

import com.board.entity.Member;
import com.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/post/login")
    public String login(Model model) {
        return "post/MemberLogin";
    }
    @GetMapping("/post/account")
    public String MemberShipAccount(Model model)
    {
        return "post/MembershipAccount";
    }

    @PostMapping("/members")
    public String create(@ModelAttribute Member member) {
        memberService.Save(member);
        return "post/usercreate";
    }
//    @PostMapping("/members/login")
//    //MemberLogin.html에서 로그인 버튼을 누를 경우 post가 올 것.
//    public String check(@ModelAttribute Member member) {
//        if (memberService.login(member))
//            return "post/usercreate";
//        return "/";
//    }

    @GetMapping("/members/login")
    public String login(@ModelAttribute Member member) {
        return "post/MemberLogin";
    }
}
