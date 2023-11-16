package com.jakegodsall.kanbantaskmanagerbackend.mapper;

import com.jakegodsall.kanbantaskmanagerbackend.entity.Task;
import com.jakegodsall.kanbantaskmanagerbackend.payload.TaskDto;

public interface TaskMapper {
    TaskDto taskToTaskDto(Task task);
    Task taskDtoToTask(TaskDto taskDto);
}
