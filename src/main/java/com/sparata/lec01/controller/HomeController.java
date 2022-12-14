package com.sparata.lec01.controller;


import com.sparata.lec01.model.UserRoleEnum;
import com.sparata.lec01.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());
        if (userDetails.getUser().getRole() == UserRoleEnum.ADMIN) {
            model.addAttribute("admin_role", true);
        }
        return "index";
    }
}

//https://kauth.kakao.com/oauth/authorize?client_id=070b993adfd04741da68c6f6906e513f&redirect_uri=http://localhost:8080/user/kakao/callback&response_type=code