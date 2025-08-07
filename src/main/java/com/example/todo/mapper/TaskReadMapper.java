package com.example.todo.mapper;

import com.example.todo.dto.TaskDTO;
import com.example.todo.entity.Task;
import org.springframework.stereotype.Component;


@Component
public class TaskReadMapper implements Mapper<Task, TaskDTO> {


    @Override
    public TaskDTO map(Task task) {
        return TaskDTO.builder()
                .id(task.getId())
                .userId(task.getUserId())
                .title(task.getTitle())
                .description(task.getDescription())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .dueDate(task.getDueDate())
                .completed(task.getCompleted())
                .build();
    }
}
