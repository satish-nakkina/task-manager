package com.example.demo.dto;

import java.time.LocalDate;

public class TaskDTO {
    private int id;
    private String title;
    private LocalDate dueDate;
    private String description;
    private String status;

    public TaskDTO() {
    }

    public TaskDTO(int id, String title, LocalDate dueDate, String description, String status) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
