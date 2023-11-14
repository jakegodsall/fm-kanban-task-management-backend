package com.jakegodsall.kanbantaskmanagerbackend.service;

import com.jakegodsall.kanbantaskmanagerbackend.payload.SubTaskDto;

import java.util.List;
import java.util.Optional;

public interface SubTaskService {
    public List<SubTaskDto> getAllSubTasks();
    public SubTaskDto createSubTask(SubTaskDto subTaskDto);
    public Optional<SubTaskDto> getSubTaskById(long id);
    public SubTaskDto updateSubTaskById(SubTaskDto subTaskDto, long id);
    public void deleteSubTaskById(long id);
}
