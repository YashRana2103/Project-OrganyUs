package com.organyus.service;

import com.organyus.model.Project;
import com.organyus.repository.ProjectRepository;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project addOne(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> addAll(List<Project> projects) {
        return projectRepository.saveAll(projects);
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public Optional<Project> getById(@Valid ObjectId projectId) {
        return projectRepository.findById(projectId);
    }
}
