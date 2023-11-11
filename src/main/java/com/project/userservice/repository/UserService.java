package com.project.userservice.repository;

import com.project.userservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public List<User> allUser(){
        return repository.findAll();
    }

    public User findUserByUsername(String username){
        return repository.findByUsername(username);
    }

    public User findUserByEmail(String email){
        return repository.findByEmail(email);
    }

    public User findById(String id){
        return repository.findByID((id));
    }

    public User createUser(User user){
        return repository.insert(user);
    }

    public User updateUser(User user){
        return repository.save(user);
    }

    public boolean deleteUser(User user){
        try {
            repository.delete((user));
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
