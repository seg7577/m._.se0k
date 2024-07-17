package com.board.controller;

import com.board.entity.Member;
import com.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;



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
        return "post/sucess";
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

    @GetMapping("/members/login/check")
    public String login(@RequestParam String email, @RequestParam String password){
        Optional<Member> member_email = memberService.getMemberByemail(email);
        Optional<Member> member_password = memberService.getmemberBypassword(password);
        if (member_email.isPresent() && member_password.isPresent())
            return "post/sucess";
        else
            return "post/fail";
    }

//    @PostMapping("/members/login/check")
//    public String login_p(@RequestParam String email, @RequestParam String password){
//        Optional<Member> member_email = memberService.getMemberByemail(email);
//        Optional<Member> member_password = memberService.getmemberBypassword(password);
//        if (member_email.isPresent() && member_password.isPresent())
//            return "post/success";
//        else
//            return "post/fail";
//    }


}
