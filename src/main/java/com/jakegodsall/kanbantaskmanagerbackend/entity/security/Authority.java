package com.jakegodsall.kanbantaskmanagerbackend.entity.security;

import com.jakegodsall.kanbantaskmanagerbackend.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(
        name = "authority"
)
public class Authority extends BaseEntity {

    @Column(length = 100, unique = true, nullable = false)
    private String permission;

    @Override
    public String toString() {
        return permission;
    }
}
