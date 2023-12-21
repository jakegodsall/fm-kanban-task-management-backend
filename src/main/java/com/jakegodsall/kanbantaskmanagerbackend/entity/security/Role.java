package com.jakegodsall.kanbantaskmanagerbackend.entity.security;

import com.jakegodsall.kanbantaskmanagerbackend.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(
        name = "role"
)
public class Role extends BaseEntity {

    @Column(length = 100, unique = true, nullable = false)
    private String name;

    @Singular
    @ManyToMany
    @JoinTable(
            name = "role_authority",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<Authority> authorities;

    @Override
    public String toString() {
        return name;
    }
}
