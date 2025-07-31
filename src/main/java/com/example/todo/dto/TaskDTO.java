package com.example.todo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.sql.Timestamp;

@Data
@Builder
public class TaskDTO {

    Long id;
    Long userID;
    String title;
    String description;
    Timestamp createdAt;
    Timestamp updatedAt;
    Timestamp dueDate;
    Boolean completed;
}
