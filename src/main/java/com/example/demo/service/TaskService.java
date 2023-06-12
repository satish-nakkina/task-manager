package com.example.demo.service;

import com.example.demo.dto.TaskDTO;
import com.example.demo.entity.Task;

import java.util.List;

public interface TaskService {
    List<TaskDTO> findAll();

    TaskDTO findById(int taskId);

    void save(TaskDTO task);

    void deleteTask(TaskDTO task);

    void updateTask(TaskDTO task);
}
