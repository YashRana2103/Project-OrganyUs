package com.organyus.repository;

import com.organyus.model.Project;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Project, ObjectId> {
}
