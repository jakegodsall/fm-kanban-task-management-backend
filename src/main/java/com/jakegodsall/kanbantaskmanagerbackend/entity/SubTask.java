package com.jakegodsall.kanbantaskmanagerbackend.entity;

import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class SubTask extends BaseEntity {
    private String title;
    private Boolean isCompleted;

    public SubTask() {
    }

    public SubTask(String title, boolean isCompleted) {
        this.title = title;
        this.isCompleted = isCompleted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SubTask subTask = (SubTask) o;
        return isCompleted == subTask.isCompleted && Objects.equals(title, subTask.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, isCompleted);
    }

    @Override
    public String toString() {
        return isCompleted ?
                "(COMPLETE) " + title
                :
                "( ) " + title;
    }
}
