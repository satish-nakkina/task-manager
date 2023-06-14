package com.example.demo.mapper;

import com.example.demo.dto.TaskDTO;
import com.example.demo.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    private  ModelMapper modelMapper;

    public TaskMapper() {
        this.modelMapper = new ModelMapper();
    }

    public TaskDTO convertTaskToTaskDTO(Task task) {
        return modelMapper.map(task, TaskDTO.class);
    }

    public Task convertTaskDTOToTask(TaskDTO taskDTO) {
        return modelMapper.map(taskDTO, Task.class);
    }
}
