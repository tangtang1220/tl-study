package com.tangtang.springcloudoauthsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class OAuthClientDetailsService implements ClientDetailsService {

    @Autowired
    ClientDetailsService clientDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    List<Client> clients = Arrays.asList(
            new Client("browser", "browser", new String[]{Scope.BROWSER}, new String[]{GrantType.AUTHORIZATION_CODE, GrantType.CLIENT_CREDENTIALS, GrantType.PASSWORD, GrantType.REFRESH_TOKEN}),
            new Client("service", "service", new String[]{Scope.SERVICE}, new String[]{GrantType.PASSWORD, GrantType.REFRESH_TOKEN, GrantType.CLIENT_CREDENTIALS})
    );

    public static class Client {

        String clientId;

        String clientSecret;

        String[] scopes;

        String[] grantTypes;

        public Client(String clientId, String clientSecret, String[] scopes, String[] grantTypes) {
            this.clientId = clientId;
            this.clientSecret = clientSecret;
            this.scopes = scopes;
            this.grantTypes = grantTypes;
        }
    }


    @PostConstruct
    void init() throws Exception {
        InMemoryClientDetailsServiceBuilder builder = new InMemoryClientDetailsServiceBuilder();
        for (Client client : clients) {
            builder.withClient(client.clientId)
                    .secret(passwordEncoder.encode(client.clientSecret))
                    .scopes(client.scopes)
                    .authorizedGrantTypes(client.grantTypes);
        }
        clientDetailsService = builder.build();
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return clientDetailsService.loadClientByClientId(clientId);
    }
}
