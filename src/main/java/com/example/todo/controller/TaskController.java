package com.example.todo.controller;

import com.example.todo.dto.TaskDTO;
import com.example.todo.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;


    @GetMapping
    public List<TaskDTO> findByUserId(@RequestParam("user_id") Long userId) {
        return taskService.findByUserId(userId);
    }


    @GetMapping("/{id}")
    public TaskDTO findById(@PathVariable("id") Long id) {
        return taskService.findById(id);
    }


}
