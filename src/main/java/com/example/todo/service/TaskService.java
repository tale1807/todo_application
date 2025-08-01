package com.example.todo.service;

import com.example.todo.dto.TaskDTO;
import com.example.todo.mapper.TaskCreateEditMapper;
import com.example.todo.mapper.TaskReadMapper;
import com.example.todo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskCreateEditMapper taskCreateEditMapper;
    private final TaskReadMapper taskReadMapper;

    public List<TaskDTO> findByUserId(Long userId) {
        return taskRepository.findAllByUserID(userId)
                .stream()
                .map(taskReadMapper::map)
                .toList();
    }


    public TaskDTO findById(Long Id) {
        return taskRepository.findById(Id)
                .map(taskReadMapper::map)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


}
