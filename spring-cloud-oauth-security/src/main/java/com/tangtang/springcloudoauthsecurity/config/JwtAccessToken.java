package com.tangtang.springcloudoauthsecurity.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.jwt.crypto.sign.Signer;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAccessToken extends JwtAccessTokenConverter {

    public JwtAccessToken(@Qualifier("myUserDetailsService") UserDetailsService userDetailsService) {
        DefaultUserAuthenticationConverter converter = new DefaultUserAuthenticationConverter();
        converter.setUserDetailsService(userDetailsService);
        ((DefaultAccessTokenConverter) getAccessTokenConverter()).setUserTokenConverter(converter);
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Authentication user = authentication.getUserAuthentication();
        if (user != null) {
            String[] authorities = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toArray(String[]::new);
            Map<String, Object> payLoad = new HashMap<>();
            payLoad.put("authorities", authorities);
            payLoad.put("username", user.getName());
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(payLoad);
        }
        return super.enhance(accessToken, authentication);
    }

    @Override
    public void setAccessTokenConverter(AccessTokenConverter tokenConverter) {
        super.setAccessTokenConverter(tokenConverter);
    }
}
