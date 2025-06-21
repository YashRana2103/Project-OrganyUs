package com.organyus.repository;

import com.organyus.model.Department;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, ObjectId> {
}
