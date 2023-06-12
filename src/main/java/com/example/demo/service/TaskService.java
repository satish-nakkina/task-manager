package com.example.demo.service;

import com.example.demo.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();

    Task findById(int taskId);

    void save(Task task);

    void deleteTask(Task task);
}
