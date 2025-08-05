package com.example.todo.service;

import com.example.todo.dto.TaskCreateEditDTO;
import com.example.todo.dto.TaskDTO;
import com.example.todo.entity.Task;
import com.example.todo.mapper.TaskCreateEditMapper;
import com.example.todo.mapper.TaskReadMapper;
import com.example.todo.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
//@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskCreateEditMapper taskCreateEditMapper;
    private final TaskReadMapper taskReadMapper;

    public TaskService(TaskRepository taskRepository, TaskCreateEditMapper taskCreateEditMapper, TaskReadMapper taskReadMapper) {
        this.taskRepository = taskRepository;
        this.taskCreateEditMapper = taskCreateEditMapper;
        this.taskReadMapper = taskReadMapper;
    }

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


    public TaskDTO create(TaskCreateEditDTO taskDTO) {
        if (taskDTO == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Task data must not be null");
        }

        Task task = taskCreateEditMapper.map(taskDTO);
        Task savedTask = taskRepository.save(task);
        return taskReadMapper.map(savedTask);
    }

    public TaskDTO update(Long id, TaskCreateEditDTO taskDTO) {
        return taskRepository.findById(id)
                .map(existingTask -> {
                    Task updateTask = taskCreateEditMapper.map(taskDTO, existingTask);
                    Task savedTask = taskRepository.saveAndFlush(updateTask);
                    return taskReadMapper.map(savedTask);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

}
