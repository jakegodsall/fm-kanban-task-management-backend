package com.jakegodsall.kanbantaskmanagerbackend.payload;

import com.jakegodsall.kanbantaskmanagerbackend.entity.CompletionStatus;

import java.util.List;
import java.util.Objects;

public class TaskDto extends BaseDto {
    private String title;
    private String description;
    private CompletionStatus status;
    private List<SubTaskDto> subTasks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CompletionStatus getStatus() {
        return status;
    }

    public void setStatus(CompletionStatus status) {
        this.status = status;
    }

    public List<SubTaskDto> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTaskDto> subTasks) {
        this.subTasks = subTasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDto taskDto = (TaskDto) o;
        return Objects.equals(title, taskDto.title) && Objects.equals(description, taskDto.description) && status == taskDto.status && Objects.equals(subTasks, taskDto.subTasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, status, subTasks);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                '}';
    }
}
