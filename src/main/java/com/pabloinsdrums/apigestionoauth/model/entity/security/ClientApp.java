package com.pabloinsdrums.apigestionoauth.model.entity.security;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ClientApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientId;
    private String clientSecret;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> clientAuthenticationMethods;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> authorizationGrantTypes;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> redirectUris;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> scopes;
}
