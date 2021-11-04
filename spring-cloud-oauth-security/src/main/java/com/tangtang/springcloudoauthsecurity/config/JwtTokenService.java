package com.tangtang.springcloudoauthsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JwtTokenService extends DefaultTokenServices {


    public JwtTokenService(RedisConnectionFactory redisConnectionFactory,JwtAccessToken token, OAuthClientDetailsService clientDetails, Optional<AuthenticationManager> authenticationManager) {

//        setTokenStore(new JwtTokenStore(token));
        setTokenStore(new RedisTokenStore(redisConnectionFactory));

        setClientDetailsService(clientDetails);

        setAuthenticationManager(authenticationManager.orElseGet(() -> {
            OAuth2AuthenticationManager manager = new OAuth2AuthenticationManager();
            manager.setClientDetailsService(clientDetails);
            manager.setTokenServices(this);
            return manager;
        }));
        setTokenEnhancer(token);
        setSupportRefreshToken(true);
        setReuseRefreshToken(true);
    }
}
