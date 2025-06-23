package com.organyus.repository;

import com.organyus.model.User;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
//    Boolean userWithEmailExists(String email);
//    Boolean userWithUsernameExists(String username);
}
