package com.jakegodsall.kanbantaskmanagerbackend.mapper.impl;

import com.jakegodsall.kanbantaskmanagerbackend.entity.SubTask;
import com.jakegodsall.kanbantaskmanagerbackend.entity.Task;
import com.jakegodsall.kanbantaskmanagerbackend.mapper.SubTaskMapper;
import com.jakegodsall.kanbantaskmanagerbackend.mapper.TaskMapper;
import com.jakegodsall.kanbantaskmanagerbackend.payload.SubTaskDto;
import com.jakegodsall.kanbantaskmanagerbackend.payload.TaskDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskMapperImpl implements TaskMapper {

    private SubTaskMapper subTaskMapper;

    public TaskMapperImpl(SubTaskMapper subTaskMapper) {
        this.subTaskMapper = subTaskMapper;
    }

    @Override
    public TaskDto taskToTaskDto(Task task) {
        List<SubTaskDto> subTaskDtos = task.getSubtasks()
                .stream()
                .map(subTaskMapper::subTaskToSubTaskDto)
                .toList();

        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setCreatedDate(task.getCreatedDate());
        dto.setLastModifiedDate(task.getLastModifiedDate());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setSubTasks(subTaskDtos);

        return dto;
    }

    @Override
    public Task taskDtoToTask(TaskDto taskDto) {
        List<SubTask> subTasks = taskDto.getSubTasks()
                .stream()
                .map(subTaskMapper::subTaskDtoToSubTask)
                .toList();

        Task task = new Task();
        task.setId(taskDto.getId());
        task.setCreatedDate(taskDto.getCreatedDate());
        task.setLastModifiedDate(taskDto.getLastModifiedDate());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        task.setSubtasks(subTasks);

        return task;
    }
}
