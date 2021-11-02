package com.tangtang.springcloudoauthserver.security;

public interface GrantType {

    String AUTHORIZATION_CODE = "authorization_code";

    String REFRESH_TOKEN = "refresh_token";

    String CLIENT_CREDENTIALS = "client_credentials";

    String PASSWORD = "password";
}
