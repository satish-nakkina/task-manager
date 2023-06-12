package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/list")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public List<Task> getAllTasks(){
        return taskService.findAll();
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable int taskId){
        return taskService.findById(taskId);
    }

    @PostMapping("/")
    public String saveTask(@RequestBody Task task){
        task.setId(0);
        taskService.save(task);

        return "saved task";
    }

    @PutMapping("/")
    public Task updateTask(@RequestBody Task task){

        taskService.save(task);
        return task;
    }

    @DeleteMapping("/{taskId}")
    public String deleteTaskById(@PathVariable int taskId){
        Task task= taskService.findById(taskId);
        taskService.deleteTask(task);

        return "deleted task with the id - "+ taskId;
    }
}
