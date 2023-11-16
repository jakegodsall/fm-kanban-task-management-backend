package com.jakegodsall.kanbantaskmanagerbackend.service.impl;

import com.jakegodsall.kanbantaskmanagerbackend.entity.Task;
import com.jakegodsall.kanbantaskmanagerbackend.exception.ResourceNotFoundException;
import com.jakegodsall.kanbantaskmanagerbackend.mapper.TaskMapper;
import com.jakegodsall.kanbantaskmanagerbackend.payload.TaskDto;
import com.jakegodsall.kanbantaskmanagerbackend.repository.TaskRepository;
import com.jakegodsall.kanbantaskmanagerbackend.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::taskToTaskDto)
                .toList();
    }

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        // Map from DTO to entity
        Task task = taskMapper.taskDtoToTask(taskDto);
        // Update timestamps
        LocalDateTime now = LocalDateTime.now();
        task.setCreatedDate(now);
        task.setLastModifiedDate(now);
        // Store the entity in the database
        Task taskFromDb = taskRepository.save(task);
        // Map stored entity to DTO and return
        return taskMapper.taskToTaskDto(taskFromDb);
    }

    @Override
    public Optional<TaskDto> getTaskById(long id) {
        // Get the entity from the db
        Task taskFromDb = taskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Task", "id", id)
        );

        // Map to DTO and return
        return Optional.of(taskMapper.taskToTaskDto(taskFromDb));
    }

    @Override
    public TaskDto updateTaskById(TaskDto taskDto, long id) {
        // Get the entity from the db
        Task taskFromDb = taskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Task", "id", id)
        );
        // Update the fields
        taskFromDb.setLastModifiedDate(LocalDateTime.now());
        taskFromDb.setTitle(taskDto.getTitle());
        taskFromDb.setDescription(taskDto.getDescription());
        taskFromDb.setStatus(taskDto.getStatus());
        // Save to the database
        Task modifiedTask = taskRepository.save(taskFromDb);
        // Map the saved entity to DTO and return
        return taskMapper.taskToTaskDto(modifiedTask);
    }

    @Override
    public void deleteTaskById(long id) {
        // Get the entity from the db
        Task taskFromDb = taskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Task", "id", id)
        );
        // Delete the entity
        taskRepository.delete(taskFromDb);
    }
}
