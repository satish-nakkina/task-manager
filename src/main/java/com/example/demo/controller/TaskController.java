package com.example.demo.controller;

import com.example.demo.dto.TaskDTO;
import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/list")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<TaskDTO>> getAllTasks(){
        List<TaskDTO> tasks = taskService.findAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable int taskId){
        TaskDTO task = taskService.findById(taskId);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> saveTask(@RequestBody TaskDTO task){
        task.setId(0);
        taskService.save(task);
        return new ResponseEntity<>("saved task", HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO task){
        taskService.updateTask(task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTaskById(@PathVariable int taskId){
        TaskDTO task = taskService.findById(taskId);
        taskService.deleteTask(task);
        return new ResponseEntity<>("deleted task with the id - " + taskId, HttpStatus.OK);
    }
}
