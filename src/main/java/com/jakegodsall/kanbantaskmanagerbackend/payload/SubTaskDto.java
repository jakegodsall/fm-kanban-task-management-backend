package com.jakegodsall.kanbantaskmanagerbackend.payload;

import java.time.LocalDateTime;
import java.util.Objects;

public class SubTaskDto extends BaseDto {
    private String title;
    private Boolean isCompleted;

    public SubTaskDto() {
    }

    public SubTaskDto(String title, Boolean isCompleted) {
        this.title = title;
        this.isCompleted = isCompleted;
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
        return Objects.equals(title, that.title) && Objects.equals(isCompleted, that.isCompleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, isCompleted);
    }

    @Override
    public String toString() {
        return isCompleted ?
                "(COMPLETE) " + title
                :
                "( ) " + title;
    }
}
