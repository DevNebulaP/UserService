package com.project.userservice.controller;

import com.project.userservice.pojo.User;
import com.project.userservice.pojo.Users;
import com.project.userservice.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    private Users users = new Users();

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> usersList = userService.allUser();
        this.users.setModel((ArrayList<User>) usersList);
        return this.users.getModel();
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUserByUserName(@PathVariable("username") String username){
        User user = userService.findUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@RequestBody MultiValueMap<String, String> formdata){
        Map<String, String> d = formdata.toSingleValueMap();
        User user = userService.createUser(
                new User(null, d.get("email"), d.get("username"), d.get("phone"), d.get("password"), d.get("birthdate"))
        );
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/updateUser")
    public boolean updateUser(@RequestBody MultiValueMap<String, String> formdata){
        Map<String, String> d = formdata.toSingleValueMap();
        userService.updateUser(
                new User(d.get("id"), d.get("emailNew"), d.get("usernameNew"), d.get("phoneNew"), d.get("passwordNew"), d.get("birthdateNew"))
        );
        return true;
    }

    @PostMapping(value = "/deleteUser/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") String id){
        User user =  userService.findById(id);
        boolean status = userService.deleteUser(user);
        if (status) {
            users.getModel().remove(user);
        }
        return ResponseEntity.ok(status);
    }

}
