package com.example.todo.mapper;

import com.example.todo.dto.TaskCreateEditDTO;
import com.example.todo.entity.Task;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class TaskCreateEditMapper implements Mapper<TaskCreateEditDTO, Task> {


    @Override
    public Task map(TaskCreateEditDTO dto) {
        Task task = new Task();
        task.setUserId(dto.getUserId());
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate());

        task.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        task.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        task.setCompleted(false);

        return task;
    }

    public Task map(TaskCreateEditDTO dto, Task task) {
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate());
        task.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return task;
    }
}
