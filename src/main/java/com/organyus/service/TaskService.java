package com.organyus.service;

import com.organyus.model.Task;
import com.organyus.repository.TaskRepository;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task addOne(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> addAll(List<Task> tasks) {
        return taskRepository.saveAll(tasks);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> getById(@Valid ObjectId taskId) {
        return taskRepository.findById(taskId);
    }
}
