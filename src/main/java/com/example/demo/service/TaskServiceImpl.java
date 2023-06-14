package com.example.demo.service;

import com.example.demo.dao.TaskRepository;
import com.example.demo.dto.TaskDTO;
import com.example.demo.entity.Task;
import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private  TaskRepository taskRepository;

    @Autowired
    private  TaskMapper taskMapper;


    @Override
    public List<TaskDTO> findAll() {
        try {
            List<Task> tasks = taskRepository.findAll();
            return tasks.stream()
                    .map(taskMapper::convertTaskToTaskDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve tasks", e);
        }
    }

    @Override
    public TaskDTO findById(int taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            return taskMapper.convertTaskToTaskDTO(task);
        } else {
            throw new TaskNotFoundException("Task not found with the id - " + taskId);
        }
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        try {
            Task task = taskMapper.convertTaskDTOToTask(taskDTO);
            taskRepository.save(task);
            return taskDTO;
        } catch (Exception e) {
            throw new RuntimeException("Failed to save task", e);
        }
    }

    @Override
    public void deleteTask(TaskDTO taskDTO) {
        try {
            Task task = taskMapper.convertTaskDTOToTask(taskDTO);
            taskRepository.delete(task);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete task", e);
        }
    }

    @Override
    public void updateTask(TaskDTO taskDTO) {
        try {
            Task task = taskMapper.convertTaskDTOToTask(taskDTO);
            taskRepository.save(task);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save task", e);
        }
    }
}
