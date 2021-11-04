package com.tangtang.springcloudoauthsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringCloudOauthSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOauthSecurityApplication.class, args);
    }

    @RequestMapping("/app")
    public String app() {
        return "app";
    }
}
