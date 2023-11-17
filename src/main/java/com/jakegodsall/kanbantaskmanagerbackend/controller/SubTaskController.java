package com.jakegodsall.kanbantaskmanagerbackend.controller;

import com.jakegodsall.kanbantaskmanagerbackend.payload.SubTaskDto;
import com.jakegodsall.kanbantaskmanagerbackend.service.SubTaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SubTaskController {

    public static final String PATH_V1_SUBTASK = "/api/v1/subtasks";
    public static final String PATH_V1_SUBTASK_ID = PATH_V1_SUBTASK + "/{subTaskId}";

    private final SubTaskService subTaskService;

    public SubTaskController(SubTaskService subTaskService) {
        this.subTaskService = subTaskService;
    }

    @GetMapping(PATH_V1_SUBTASK)
    public ResponseEntity<List<SubTaskDto>> getAllSubTasks() {
        List<SubTaskDto> subTasks = subTaskService.getAllSubTasks();
        return new ResponseEntity<>(subTasks, HttpStatus.OK);
    }

    @PostMapping(PATH_V1_SUBTASK)
    public ResponseEntity<?> createSubTask(@Validated @RequestBody SubTaskDto subTaskDto) {
        SubTaskDto createdSubTaskDto = subTaskService.createSubTask(subTaskDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdSubTaskDto.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdSubTaskDto);
    }

    @GetMapping(PATH_V1_SUBTASK_ID)
    public ResponseEntity<SubTaskDto> getSubTaskById(@PathVariable long subTaskId) {
        SubTaskDto subTaskDto = subTaskService.getSubTaskById(subTaskId).get();
        return new ResponseEntity<>(subTaskDto, HttpStatus.OK);
    }

    @PutMapping(PATH_V1_SUBTASK_ID)
    public ResponseEntity<SubTaskDto> updateSubTaskById(
            @RequestBody SubTaskDto subTaskDto,
            @PathVariable long subTaskId
    ) {
        SubTaskDto updatedSubTaskDto = subTaskService.updateSubTaskById(subTaskDto, subTaskId);
        return new ResponseEntity<>(updatedSubTaskDto, HttpStatus.OK);
    }

    @DeleteMapping(PATH_V1_SUBTASK_ID)
    public ResponseEntity<Void> deleteSubTaskById(@PathVariable long subTaskId) {
        subTaskService.deleteSubTaskById(subTaskId);
        return ResponseEntity.noContent().build();
    }
}
