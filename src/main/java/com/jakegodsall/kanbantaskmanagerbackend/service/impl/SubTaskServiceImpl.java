package com.jakegodsall.kanbantaskmanagerbackend.service.impl;

import com.jakegodsall.kanbantaskmanagerbackend.entity.SubTask;
import com.jakegodsall.kanbantaskmanagerbackend.exception.ResourceNotFoundException;
import com.jakegodsall.kanbantaskmanagerbackend.mapper.SubTaskMapper;
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
    private final SubTaskMapper subTaskMapper;

    public SubTaskServiceImpl(SubTaskRepository subTaskRepository, SubTaskMapper subTaskMapper) {
        this.subTaskRepository = subTaskRepository;
        this.subTaskMapper = subTaskMapper;
    }

    @Override
    public List<SubTaskDto> getAllSubTasks() {
        return subTaskRepository.findAll()
                .stream()
                .map(subTaskMapper::subTaskToSubTaskDto)
                .toList();
    }

    @Override
    public SubTaskDto createSubTask(SubTaskDto subTaskDto) {
        // Convert from DTO to entity
        SubTask subTask = subTaskMapper.subTaskDtoToSubTask(subTaskDto);

        // Set dates
        LocalDateTime now = LocalDateTime.now();
        subTask.setCreatedDate(now);
        subTask.setLastModifiedDate(now);

        // Store in the database
        SubTask subTaskFromDb = subTaskRepository.save(subTask);

        // Map to DTO and return
        return subTaskMapper.subTaskToSubTaskDto(subTaskFromDb);
    }

    @Override
    public Optional<SubTaskDto> getSubTaskById(long id) {
        SubTask subTaskFromDb = subTaskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subtask", "id", id)
        );
        return Optional.of(subTaskMapper.subTaskToSubTaskDto(subTaskFromDb));
    }

    @Override
    public SubTaskDto updateSubTaskById(SubTaskDto dto, long id) {
        // Get entity from the db
        SubTask subTaskFromDb = subTaskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subtask", "id", id)
        );

        // Update fields
        subTaskFromDb.setLastModifiedDate(LocalDateTime.now());
        subTaskFromDb.setTitle(dto.getTitle());
        subTaskFromDb.setIsCompleted(dto.getIsCompleted());

        // Store in the database
        SubTask updatedSubTask = subTaskRepository.save(subTaskFromDb);

        // Map to DTO and return
        return subTaskMapper.subTaskToSubTaskDto(updatedSubTask);
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
}
