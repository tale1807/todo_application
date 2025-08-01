package com.example.todo.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TaskCreateEditDTO {

    Long userID;
    String title;
    String description;
    Timestamp dueDate;
}
