package com.tangtang.springcloudoauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringCloudOauthServerApplication {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        SpringApplication.run(SpringCloudOauthServerApplication.class, args);
    }



    @RequestMapping("/app")
    public String app(){
        return "app";
    }
}
