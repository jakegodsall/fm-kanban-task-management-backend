package com.jakegodsall.kanbantaskmanagerbackend.repository.security;

import com.jakegodsall.kanbantaskmanagerbackend.entity.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
