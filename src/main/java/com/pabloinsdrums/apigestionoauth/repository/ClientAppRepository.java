package com.pabloinsdrums.apigestionoauth.repository;

import com.pabloinsdrums.apigestionoauth.model.entity.security.ClientApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientAppRepository extends JpaRepository<ClientApp, Long> {
    Optional<ClientApp> findByClientId(String clientId);
}
