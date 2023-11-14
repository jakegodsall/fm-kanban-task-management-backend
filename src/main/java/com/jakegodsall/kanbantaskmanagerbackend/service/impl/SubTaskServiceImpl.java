package com.jakegodsall.kanbantaskmanagerbackend.service.impl;

import com.jakegodsall.kanbantaskmanagerbackend.entity.SubTask;
import com.jakegodsall.kanbantaskmanagerbackend.exception.ResourceNotFoundException;
import com.jakegodsall.kanbantaskmanagerbackend.payload.SubTaskDto;
import com.jakegodsall.kanbantaskmanagerbackend.repository.SubTaskRepository;
import com.jakegodsall.kanbantaskmanagerbackend.service.SubTaskService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SubTaskServiceImpl implements SubTaskService {

    private final SubTaskRepository subTaskRepository;

    public SubTaskServiceImpl(SubTaskRepository subTaskRepository) {
        this.subTaskRepository = subTaskRepository;
    }

    @Override
    public List<SubTaskDto> getAllSubTasks() {
        return subTaskRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public SubTaskDto createSubTask(SubTaskDto subTaskDto) {
        // Convert from DTO to entity
        SubTask subTask = mapToEntity(subTaskDto);

        // Set dates
        LocalDateTime now = LocalDateTime.now();
        subTask.setCreatedDate(now);
        subTask.setLastModifiedDate(now);

        // Store in the database
        SubTask subTaskFromDb = subTaskRepository.save(subTask);

        // Map to DTO and return
        return mapToDto(subTaskFromDb);
    }

    @Override
    public Optional<SubTaskDto> getSubTaskById(long id) {
        SubTask subTaskFromDb = subTaskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subtask", "id", id)
        );
        return Optional.of(mapToDto(subTaskFromDb));
    }

    @Override
    public SubTaskDto updateSubTaskById(SubTaskDto dto, long id) {
        // Get entity from the db
        SubTask subTaskFromDb = subTaskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subtask", "id", id)
        );

        // Update last modified date
        subTaskFromDb.setLastModifiedDate(LocalDateTime.now());

        // Store in the database
        SubTask updatedSubTask = subTaskRepository.save(subTaskFromDb);

        // Map to DTO and return
        return mapToDto(updatedSubTask);
    }

    @Override
    public void deleteSubTaskById(long id) {
        // Get entity from the db
        SubTask subTaskFromDb = subTaskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subtask", "id", id)
        );

        // Delete the entity
        subTaskRepository.delete(subTaskFromDb);
    }

    private SubTaskDto mapToDto(SubTask subTask) {
        SubTaskDto subTaskDto = new SubTaskDto();
        subTaskDto.setId(subTask.getId());
        subTaskDto.setCreatedDate(subTask.getCreatedDate());
        subTaskDto.setLastModifiedDate(subTask.getLastModifiedDate());
        subTaskDto.setTitle(subTask.getTitle());
        subTaskDto.setIsCompleted(subTask.getIsCompleted());

        return subTaskDto;
    }

    private SubTask mapToEntity(SubTaskDto subTaskDto) {
        SubTask subTask = new SubTask();
        subTask.setId(subTaskDto.getId());
        subTask.setCreatedDate(subTaskDto.getCreatedDate());
        subTask.setLastModifiedDate(subTaskDto.getLastModifiedDate());
        subTask.setTitle(subTaskDto.getTitle());
        subTask.setIsCompleted(subTaskDto.getIsCompleted());

        return subTask;
    }
}
