package com.example.todo.controller;

import com.example.todo.dto.TaskCreateEditDTO;
import com.example.todo.dto.TaskDTO;
import com.example.todo.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
//@RequiredArgsConstructor
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping
    public List<TaskDTO> findByUserId(@RequestParam("user_id") Long userId) {
        return taskService.findByUserId(userId);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDTO findById(@PathVariable("id") Long id) {
        return taskService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@RequestBody TaskCreateEditDTO taskDTO) {
        return taskService.create(taskDTO);
    }


    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public TaskDTO updatePut(@PathVariable Long id, @RequestBody TaskCreateEditDTO taskDTO) {
        return taskService.update(id, taskDTO);
    }

    @PatchMapping("/{id}/done")
    public TaskDTO updatePatch(@PathVariable Long id, @RequestBody TaskCreateEditDTO taskDTO) {
        return taskService.update(id, taskDTO);
    }
}
