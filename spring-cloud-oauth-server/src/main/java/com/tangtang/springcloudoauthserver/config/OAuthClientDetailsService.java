package com.tangtang.springcloudoauthserver.config;

import com.tangtang.springcloudoauthserver.security.GrantType;
import com.tangtang.springcloudoauthserver.security.ScopeType;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

//@Component
public class OAuthClientDetailsService implements ClientDetailsService {

    private ClientDetailsService clientDetailsService;

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

    private static final List<Client> clients =
            Arrays.asList(
                    new Client("client-1", "client-secret-1", new String[]{ScopeType.BROWSER}, new String[]{GrantType.PASSWORD, GrantType.REFRESH_TOKEN}),
                    new Client("client-2", "client-secret-2", new String[]{ScopeType.SERVICE}, new String[]{GrantType.CLIENT_CREDENTIALS}),
                    new Client("client-3", "client-secret-3", new String[]{ScopeType.SERVICE}, new String[]{GrantType.CLIENT_CREDENTIALS})
            );


    @PostConstruct
    public void init() throws Exception {
        InMemoryClientDetailsServiceBuilder builder = new InMemoryClientDetailsServiceBuilder();
        clients.forEach(client -> {
            builder.withClient(client.clientId)
                    .secret(client.clientSecret)
                    .authorizedGrantTypes(client.grantTypes)
                    .scopes(client.scopes);
        });
        clientDetailsService = builder.build();
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return clientDetailsService.loadClientByClientId(clientId);
    }


}
