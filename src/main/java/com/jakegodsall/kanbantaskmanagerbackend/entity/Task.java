package com.jakegodsall.kanbantaskmanagerbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(
        name = "task"
)
public class Task extends BaseEntity {

    @Column(length = 200, nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.ORDINAL)
    private CompletionStatus status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private List<SubTask> subtasks = new ArrayList<>();

    @Override
    public String toString() {
        return title;
    }
}
