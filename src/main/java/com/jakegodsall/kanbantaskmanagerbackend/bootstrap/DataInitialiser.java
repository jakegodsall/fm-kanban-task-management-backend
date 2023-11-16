package com.jakegodsall.kanbantaskmanagerbackend.bootstrap;

import com.jakegodsall.kanbantaskmanagerbackend.entity.SubTask;
import com.jakegodsall.kanbantaskmanagerbackend.payload.SubTaskDto;
import com.jakegodsall.kanbantaskmanagerbackend.repository.SubTaskRepository;
import com.jakegodsall.kanbantaskmanagerbackend.service.SubTaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(2)
public class DataInitialiser implements CommandLineRunner {

    private final SubTaskService subTaskService;

    public DataInitialiser(SubTaskService subTaskService) {
        this.subTaskService = subTaskService;
    }

    @Override
    public void run(String... args) throws Exception {
        initialiseSubTasks();
    }

    private void initialiseSubTasks() {
        List<SubTaskDto> subTasks = new ArrayList<>();
        subTasks.add(new SubTaskDto("Find Hunter", false));
        subTasks.add(new SubTaskDto("Gather assets", false));
        subTasks.add(new SubTaskDto("Draft product page", false));
        subTasks.add(new SubTaskDto("Notify customers", false));
        subTasks.add(new SubTaskDto("Notify network", false));
        subTasks.add(new SubTaskDto("Launch!", false));

        for (SubTaskDto subTask : subTasks) {
            subTaskService.createSubTask(subTask);
        }
    }
}
