package com.jakegodsall.kanbantaskmanagerbackend.bootstrap;

import com.jakegodsall.kanbantaskmanagerbackend.entity.CompletionStatus;
import com.jakegodsall.kanbantaskmanagerbackend.entity.SubTask;
import com.jakegodsall.kanbantaskmanagerbackend.payload.SubTaskDto;
import com.jakegodsall.kanbantaskmanagerbackend.payload.TaskDto;
import com.jakegodsall.kanbantaskmanagerbackend.repository.SubTaskRepository;
import com.jakegodsall.kanbantaskmanagerbackend.service.SubTaskService;
import com.jakegodsall.kanbantaskmanagerbackend.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(2)
public class DataInitialiser implements CommandLineRunner {

    private final SubTaskService subTaskService;
    private final TaskService taskService;

    public DataInitialiser(SubTaskService subTaskService, TaskService taskService) {
        this.subTaskService = subTaskService;
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {
//        initializeTodoTasks();
    }

    private void initializeSubtasks() {
        List<SubTaskDto> subTasks = new ArrayList<>();
        subTasks.add(new SubTaskDto("Find Hunter", false));
        subTasks.add(new SubTaskDto("Gather assets", false));
        subTasks.add(new SubTaskDto("Draft product page", false));
        subTasks.add(new SubTaskDto("Notify customers", false));
        subTasks.add(new SubTaskDto("Notify network", false));
        subTasks.add(new SubTaskDto("Launch!", false));
        subTasks.add(new SubTaskDto("Do the subtask!", false));

        for (SubTaskDto subTask : subTasks) {
            subTaskService.createSubTask(subTask);
        }
    }

    private void initializeTodoTasks() {
        TaskDto task1 = new TaskDto();
        task1.setTitle("Build UI for onboarding flow");
        task1.setDescription("");
        task1.setStatus(CompletionStatus.TODO);
        task1.setSubTasks(
                List.of(
                        new SubTaskDto("Sign up page", true),
                        new SubTaskDto("Sign in page", false),
                        new SubTaskDto("Welcome page", false)
                )
        );

        TaskDto task2 = new TaskDto();
        task2.setTitle("Build UI for search");
        task2.setDescription("");
        task2.setStatus(CompletionStatus.TODO);
        task2.setSubTasks(
                List.of(
                        new SubTaskDto("Search page", false)
                )
        );

        TaskDto task3 = new TaskDto();
        task3.setTitle("Build settings UI");
        task3.setDescription("");
        task3.setStatus(CompletionStatus.TODO);
        task3.setSubTasks(
                List.of(
                        new SubTaskDto("Account page", false),
                        new SubTaskDto("Billing page", false)
                )
        );

        TaskDto task4 = new TaskDto();
        task4.setTitle("QA and test all major user journeys");
        task4.setDescription("");
        task4.setStatus(CompletionStatus.TODO);
        task4.setSubTasks(
                List.of(
                        new SubTaskDto("Internal testing", false),
                        new SubTaskDto("External testing", false)
                )
        );

        taskService.createTask(task1);
        taskService.createTask(task2);
        taskService.createTask(task3);
        taskService.createTask(task4);
    }

    private void initializeDoingTasks() {
        TaskDto task1 = new TaskDto();
        task1.setTitle("Design settings and search pages");
        task1.setDescription("");
        task1.setStatus(CompletionStatus.DOING);
        task1.setSubTasks(
                List.of(
                        new SubTaskDto("Settings - Account page", true),
                        new SubTaskDto("Settings - Billing page", true),
                        new SubTaskDto("Search page", false)
                )
        );

        TaskDto task2 = new TaskDto();
        task2.setTitle("Add account management endpoints");
        task2.setDescription("");
        task2.setStatus(CompletionStatus.DOING);
        task2.setSubTasks(
                List.of(
                        new SubTaskDto("Upgrade plan", true),
                        new SubTaskDto("Cancel plan", true),
                        new SubTaskDto("Update payment method", false)
                )
        );

        TaskDto task3 = new TaskDto();
        task3.setTitle("Design onboarding flow");
        task3.setDescription("");
        task3.setStatus(CompletionStatus.DOING);
        task3.setSubTasks(
                List.of(
                        new SubTaskDto("Sign up page", true),
                        new SubTaskDto("Sign in page", false),
                        new SubTaskDto("Welcome page", false)
                )
        );

        TaskDto task4 = new TaskDto();
        task4.setTitle("Add search endpoints");
        task4.setDescription("");
        task4.setStatus(CompletionStatus.DOING);
        task4.setSubTasks(
                List.of(
                        new SubTaskDto("Add search endpoint", false),
                        new SubTaskDto("Define search filters", false)
                )
        );

        TaskDto task5 = new TaskDto();
        task5.setTitle("Add authentication endpoints");
        task5.setDescription("");
        task5.setStatus(CompletionStatus.DOING);
        task5.setSubTasks(
                List.of(
                        new SubTaskDto("Define user model", true),
                        new SubTaskDto("Add auth endpoints", false)
                )
        );

        TaskDto task6 = new TaskDto();
        task6.setTitle("Research pricing points of various competitors and trial different business models");
        task6.setDescription("We know what we're planning to build for version one. Now we need to finalise the first pricing model we'll use. Keep iterating the subtasks until we have a coherent proposition.");
        task6.setStatus(CompletionStatus.DOING);
        task6.setSubTasks(
                List.of(
                        new SubTaskDto("Research competitor pricing and business models", true),
                        new SubTaskDto("Outline a business model that works for our solution", false),
                        new SubTaskDto("Talk to potential customers about our proposed solution and ask for fair price expectancy", false)
                )
        );
    }
}
