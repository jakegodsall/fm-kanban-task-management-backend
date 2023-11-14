package com.jakegodsall.kanbantaskmanagerbackend.repository;

import com.jakegodsall.kanbantaskmanagerbackend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
