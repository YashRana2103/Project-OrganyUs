package com.organyus.service;

import com.organyus.model.User;
import com.organyus.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addOne(User user){
        userRepository.save(user);
        return user;
    }

    public List<User> addAll(List<User> users) {
        return userRepository.saveAll(users);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> getById(ObjectId uid){
        return userRepository.findById(uid);
    }
}
