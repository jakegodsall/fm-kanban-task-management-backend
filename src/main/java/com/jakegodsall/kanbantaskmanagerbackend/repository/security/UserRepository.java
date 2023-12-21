package com.jakegodsall.kanbantaskmanagerbackend.repository.security;

import com.jakegodsall.kanbantaskmanagerbackend.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
