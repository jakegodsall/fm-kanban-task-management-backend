package com.jakegodsall.kanbantaskmanagerbackend.bootstrap.security;

import com.jakegodsall.kanbantaskmanagerbackend.entity.security.Authority;
import com.jakegodsall.kanbantaskmanagerbackend.entity.security.Role;
import com.jakegodsall.kanbantaskmanagerbackend.repository.security.AuthorityRepository;
import com.jakegodsall.kanbantaskmanagerbackend.repository.security.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Order(1)
@Component
public class SecurityBootstrap implements CommandLineRunner {

    private final AuthorityRepository authorityRepository;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        bootstrapAuthoritiesAndRolesForAdminUser();
    }

    private void bootstrapAuthoritiesAndRolesForAdminUser() {

        // User authorities
        Authority getUser = Authority.builder().permission("GET_USER").build();
        Authority createUser = Authority.builder().permission("CREATE_USER").build();
        Authority updateUser = Authority.builder().permission("UPDATE_USER").build();
        Authority deleteUser = Authority.builder().permission("DELETE_USER").build();

        // Task authorities
        Authority getTask = Authority.builder().permission("GET_TASK").build();
        Authority createTask = Authority.builder().permission("CREATE_TASK").build();
        Authority updateTask = Authority.builder().permission("UPDATE_TASK").build();
        Authority deleteTask = Authority.builder().permission("DELETE_TASK").build();

        // Subtask authorities
        Authority getSubTask = Authority.builder().permission("GET_SUB_TASK").build();
        Authority createSubTask = Authority.builder().permission("CREATE_SUB_TASK").build();
        Authority updateSubTask = Authority.builder().permission("UPDATE_SUB_TASK").build();
        Authority deleteSubTask = Authority.builder().permission("DELETE_SUB_TASK").build();

        // Admin role
        Role adminRole = Role.builder()
                .name("ADMIN")
                .authority(getUser).authority(createUser).authority(updateUser).authority(deleteUser)
                .authority(getTask).authority(createTask).authority(updateTask).authority(deleteTask)
                .authority(getSubTask).authority(createSubTask).authority(updateSubTask).authority(deleteSubTask)
                .build();

        if (!roleRepository.existsByName("ADMIN")) {
            roleRepository.save(adminRole);
            System.out.println("Default admin role saved to the database");
        }
    }
}
