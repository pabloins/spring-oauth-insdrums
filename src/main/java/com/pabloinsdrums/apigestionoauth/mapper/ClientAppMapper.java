package com.pabloinsdrums.apigestionoauth.mapper;

import com.pabloinsdrums.apigestionoauth.model.entity.security.ClientApp;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Collectors;

public class ClientAppMapper {

    public static RegisteredClient toRegisteredClient(ClientApp clientApp){
        return RegisteredClient.withId(clientApp.getClientId())
                .clientId(clientApp.getClientId())
                .clientSecret(clientApp.getClientSecret())
                .clientIdIssuedAt(new Date(System.currentTimeMillis()).toInstant())
                .clientAuthenticationMethods(clientAuthenticationMethods -> {
                    clientApp.getClientAuthenticationMethods().stream()
                            .map(method -> new ClientAuthenticationMethod(method))
                            .forEach(clientAuthenticationMethods::add);
                })
                .authorizationGrantTypes(authorizationGrantTypes -> {
                    clientApp.getAuthorizationGrantTypes().stream()
                            .map(grantTypes ->  new AuthorizationGrantType(grantTypes))
                            .forEach(authorizationGrantTypes::add);
                })
                .redirectUris(redirectUris ->
                        clientApp.getRedirectUris().stream().forEach(redirectUris::add))
                .scopes(scopes -> clientApp.getScopes().stream().forEach(scopes::add))
                .tokenSettings(TokenSettings.builder()
                        .accessTokenTimeToLive(Duration.ofMinutes(clientApp.getDurationInMinutes()))
                        .refreshTokenTimeToLive(Duration.ofMinutes(clientApp.getDurationInMinutes() * 4))
                        .build())
                .clientSettings(ClientSettings.builder()
                        .requireProofKey(clientApp.isRequiredProofKey())
                        .build())
                .build();
    }
}
