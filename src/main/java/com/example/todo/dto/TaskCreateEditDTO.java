package com.example.todo.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TaskCreateEditDTO {

    Long userId;
    String title;
    String description;
    Timestamp dueDate;

}
