package com.jakegodsall.kanbantaskmanagerbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(
        name = "sub_task"
)
public class SubTask extends BaseEntity {

    @Column(length = 200, nullable = false)
    private String title;

    @Builder.Default
    private Boolean isCompleted = false;

    @Override
    public String toString() {
        return title;
    }
}
