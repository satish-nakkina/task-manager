package com.example.demo.service;

import com.example.demo.dao.TaskRepository;
import com.example.demo.entity.Task;
import com.example.demo.exception.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(int taskId) {
        Optional<Task> optionalTask= taskRepository.findById(taskId);

        if(optionalTask.isPresent()){
            return optionalTask.get();
        }
        else{
            throw new TaskNotFoundException("Task not found with the id - "+taskId);
        }

    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }
}
