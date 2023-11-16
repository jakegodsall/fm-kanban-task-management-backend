package com.jakegodsall.kanbantaskmanagerbackend.controller;

import com.jakegodsall.kanbantaskmanagerbackend.payload.TaskDto;
import com.jakegodsall.kanbantaskmanagerbackend.service.TaskService;
import org.apache.coyote.Response;
import org.hibernate.usertype.LoggableUserType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class TaskController {

    private static final String PATH_V1_TASK = "/api/v1/tasks";
    private static final String PATH_V1_TASK_ID = PATH_V1_TASK + "/{taskId}";

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(PATH_V1_TASK)
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        List<TaskDto> taskDtos = taskService.getAllTasks();
        return new ResponseEntity<>(taskDtos, HttpStatus.OK);
    }

    @PostMapping(PATH_V1_TASK)
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        TaskDto createdTask = taskService.createTask(taskDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{taskId}")
                .buildAndExpand(createdTask.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdTask);
    }

    @GetMapping(PATH_V1_TASK_ID)
    public ResponseEntity<TaskDto> getTaskById(@PathVariable long taskId) {
        TaskDto taskDto = taskService.getTaskById(taskId).get();
        return new ResponseEntity<>(taskDto, HttpStatus.OK);
    }

    @PutMapping(PATH_V1_TASK_ID)
    public ResponseEntity<TaskDto> updateTaskById(
            @RequestBody TaskDto taskDto,
            @PathVariable long taskId
    ) {
        TaskDto updatedTaskDto = taskService.updateTaskById(taskDto, taskId);
        return new ResponseEntity<>(updatedTaskDto, HttpStatus.OK);
    }

    @DeleteMapping(PATH_V1_TASK_ID)
    public ResponseEntity<Void> deleteTaskById(@PathVariable long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
