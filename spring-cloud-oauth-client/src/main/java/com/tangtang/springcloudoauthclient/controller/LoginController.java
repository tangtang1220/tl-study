package com.tangtang.springcloudoauthclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {


    @RequestMapping("/oauth2")
    public String oauth2() {
        return "oauth2";
    }
}
