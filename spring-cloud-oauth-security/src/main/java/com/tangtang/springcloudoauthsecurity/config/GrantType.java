package com.tangtang.springcloudoauthsecurity.config;

public interface GrantType {

    String PASSWORD = "password";

    String AUTHORIZATION_CODE = "authorization_code";

    String CLIENT_CREDENTIALS = "client_credentials";

    String REFRESH_TOKEN = "refresh_token";
}
