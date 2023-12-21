package com.jakegodsall.kanbantaskmanagerbackend.service.security;

import com.jakegodsall.kanbantaskmanagerbackend.entity.security.Authority;
import com.jakegodsall.kanbantaskmanagerbackend.entity.security.User;
import com.jakegodsall.kanbantaskmanagerbackend.repository.security.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(username)
        );

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(convertToGrantedAuthorities(user.getAuthorities()))
                .accountExpired(!user.isAccountNonExpired())
                .accountLocked(!user.isAccountNonLocked())
                .credentialsExpired(!user.isCredentialsNonExpired())
                .build();
    }

    private Set<? extends GrantedAuthority> convertToGrantedAuthorities(Set<Authority> authorities) {

        if (authorities == null || authorities.isEmpty())
            return new HashSet<>();

        return authorities.stream()
                .map(Authority::getPermission)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }
}
