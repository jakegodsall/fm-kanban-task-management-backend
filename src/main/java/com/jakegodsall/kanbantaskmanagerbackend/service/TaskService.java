package com.jakegodsall.kanbantaskmanagerbackend.service;

import com.jakegodsall.kanbantaskmanagerbackend.payload.TaskDto;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<TaskDto> getAllTasks();
    TaskDto createTask(TaskDto taskDto);
    Optional<TaskDto> getTaskById(long id);
    TaskDto updateTaskById(TaskDto taskDto, long id);
    void deleteTaskById(long id);
}
