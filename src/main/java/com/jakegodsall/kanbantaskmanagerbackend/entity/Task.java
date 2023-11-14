package com.jakegodsall.kanbantaskmanagerbackend.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Task extends BaseEntity {
    private String title;

    private String description;

    @Enumerated(EnumType.ORDINAL)
    private CompletionStatus status;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SubTask> subtasks;

    public Task() {
    }


}
