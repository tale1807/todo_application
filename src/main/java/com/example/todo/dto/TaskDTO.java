package com.example.todo.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class TaskDTO {

    Long id;
    Long userId;
    String title;
    String description;
    Timestamp createdAt;
    Timestamp updatedAt;
    Timestamp dueDate;
    Boolean completed;

}
