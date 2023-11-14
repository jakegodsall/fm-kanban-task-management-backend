package com.jakegodsall.kanbantaskmanagerbackend.repository;

import com.jakegodsall.kanbantaskmanagerbackend.entity.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}
