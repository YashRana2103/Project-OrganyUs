package com.organyus.controller;

import com.organyus.model.Project;
import com.organyus.service.ProjectService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class TaskController {

    private final ProjectService projectService;

    public TaskController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<?> addOne(@Valid @RequestBody Project project) {
        return new ResponseEntity<>(projectService.addOne(project), HttpStatus.OK) ;
    }

    @PostMapping("/all")
    public ResponseEntity<?> addAll(@Valid @RequestBody List<Project> projects) {
        return new ResponseEntity<>(projectService.addAll(projects), HttpStatus.OK) ;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Project> projects = projectService.getAll();
        if(projects.isEmpty()){
            return new ResponseEntity<>("No projects found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getById(@PathVariable ObjectId projectId) {
        Optional<Project> project = projectService.getById(projectId);
        if(project.isEmpty()){
            return new ResponseEntity<>("No project found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(project.get(), HttpStatus.OK);
    }
}
