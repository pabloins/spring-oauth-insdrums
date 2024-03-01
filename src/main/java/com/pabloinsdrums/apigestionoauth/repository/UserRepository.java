package com.pabloinsdrums.apigestionoauth.repository;

import com.pabloinsdrums.apigestionoauth.model.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
