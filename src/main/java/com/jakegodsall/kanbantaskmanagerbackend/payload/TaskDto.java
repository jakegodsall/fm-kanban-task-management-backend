package com.jakegodsall.kanbantaskmanagerbackend.payload;

import com.jakegodsall.kanbantaskmanagerbackend.entity.CompletionStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class TaskDto extends BaseDto {

    @NotNull(message = "is required")
    @NotBlank(message = "cannot be blank")
    @Size(min = 5, max = 100, message = "must be between 3 and 100 characters")
    private String title;

    @Size(max = 500, message = "cannot be more than 500 characters")
    private String description;

    @NotNull(message = "is required")
    private CompletionStatus status;

    @Valid
    private List<SubTaskDto> subTasks;

    public TaskDto() {
    }

    public TaskDto(String title,
                   String description,
                   CompletionStatus status,
                   List<SubTaskDto> subTasks) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.subTasks = subTasks;
    }

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
