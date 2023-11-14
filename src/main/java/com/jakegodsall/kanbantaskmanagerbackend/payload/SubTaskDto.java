package com.jakegodsall.kanbantaskmanagerbackend.payload;

import java.time.LocalDateTime;
import java.util.Objects;

public class SubTaskDto {
    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private String title;
    private Boolean isCompleted;

    public SubTaskDto() {
    }

    public SubTaskDto(String title, Boolean isCompleted) {
        this.title = title;
        this.isCompleted = isCompleted;
    }

    public SubTaskDto(Long id,
                      LocalDateTime createdDate,
                      LocalDateTime lastModifiedDate,
                      String title,
                      Boolean isCompleted) {
        this.id = id;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.title = title;
        this.isCompleted = isCompleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubTaskDto that = (SubTaskDto) o;
        return Objects.equals(id, that.id) && Objects.equals(createdDate, that.createdDate) && Objects.equals(lastModifiedDate, that.lastModifiedDate) && Objects.equals(title, that.title) && Objects.equals(isCompleted, that.isCompleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate, lastModifiedDate, title, isCompleted);
    }

    @Override
    public String toString() {
        return isCompleted ?
                "(COMPLETE) " + title
                :
                "( ) " + title;
    }
}
