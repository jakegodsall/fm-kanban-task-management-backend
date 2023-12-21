package com.jakegodsall.kanbantaskmanagerbackend.repository.security;

import com.jakegodsall.kanbantaskmanagerbackend.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
