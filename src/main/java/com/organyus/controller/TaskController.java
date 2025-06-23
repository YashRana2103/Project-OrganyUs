package com.organyus.controller;

import com.organyus.model.Task;
import com.organyus.service.TaskService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<?> addOne(@Valid @RequestBody Task task) {
        return new ResponseEntity<>(taskService.addOne(task), HttpStatus.OK) ;
    }

    @PostMapping("/all")
    public ResponseEntity<?> addAll(@Valid @RequestBody List<Task> tasks) {
        return new ResponseEntity<>(taskService.addAll(tasks), HttpStatus.OK) ;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Task> tasks = taskService.getAll();
        if(tasks.isEmpty()){
            return new ResponseEntity<>("No tasks found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<?> getById(@PathVariable ObjectId taskId) {
        Optional<Task> task = taskService.getById(taskId);
        if(task.isEmpty()){
            return new ResponseEntity<>("No task found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task.get(), HttpStatus.OK);
    }
}
