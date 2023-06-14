package com.example.demo.service;

import com.example.demo.dto.TaskDTO;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface TaskService {
    List<TaskDTO> findAll();

    TaskDTO findById(int taskId);

    TaskDTO createTask(TaskDTO task);

    void deleteTask(TaskDTO task);

    void updateTask(TaskDTO task);
}
