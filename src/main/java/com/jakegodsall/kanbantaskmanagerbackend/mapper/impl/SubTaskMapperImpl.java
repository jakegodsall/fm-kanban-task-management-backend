package com.jakegodsall.kanbantaskmanagerbackend.mapper.impl;

import com.jakegodsall.kanbantaskmanagerbackend.entity.SubTask;
import com.jakegodsall.kanbantaskmanagerbackend.mapper.SubTaskMapper;
import com.jakegodsall.kanbantaskmanagerbackend.payload.SubTaskDto;
import org.springframework.stereotype.Component;

@Component
public class SubTaskMapperImpl implements SubTaskMapper {

    public SubTaskDto subTaskToSubTaskDto(SubTask subTask) {
        SubTaskDto subTaskDto = new SubTaskDto();
        subTaskDto.setId(subTask.getId());
        subTaskDto.setCreatedDate(subTask.getCreatedDate());
        subTaskDto.setLastModifiedDate(subTask.getLastModifiedDate());
        subTaskDto.setTitle(subTask.getTitle());
        subTaskDto.setIsCompleted(subTask.getIsCompleted());

        return subTaskDto;
    }

    @Override
    public SubTask subTaskDtoToSubTask(SubTaskDto subTaskDto) {
        SubTask subTask = new SubTask();
        subTask.setId(subTaskDto.getId());
        subTask.setCreatedDate(subTaskDto.getCreatedDate());
        subTask.setLastModifiedDate(subTaskDto.getLastModifiedDate());
        subTask.setTitle(subTaskDto.getTitle());
        subTask.setIsCompleted(subTaskDto.getIsCompleted());

        return subTask;
    }


}
