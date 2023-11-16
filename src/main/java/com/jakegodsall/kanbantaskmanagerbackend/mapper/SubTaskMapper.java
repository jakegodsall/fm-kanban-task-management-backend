package com.jakegodsall.kanbantaskmanagerbackend.mapper;

import com.jakegodsall.kanbantaskmanagerbackend.entity.SubTask;
import com.jakegodsall.kanbantaskmanagerbackend.payload.SubTaskDto;

public interface SubTaskMapper {
    public SubTaskDto subTaskToSubTaskDto(SubTask subTask);
    public SubTask subTaskDtoToSubTask(SubTaskDto subTaskDto);
}
