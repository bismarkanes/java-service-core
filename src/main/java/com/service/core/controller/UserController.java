package com.service.core.controller;

import java.util.List;
import java.util.Optional;

import com.service.core.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.core.model.*;

@RestController
@RequestMapping("/api")
class UserController {
    @Autowired
    private UserRepository ur;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> user = ur.findAll();

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUsers(@RequestBody User userParam) {
        User u = new User();
        u.setName(userParam.getName());
        u.setAddress(userParam.getAddress());

        u = ur.save(u);

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<User> updateUsers(@PathVariable Integer id, @RequestBody User userParam) {
        Optional<User> u = ur.findById(id);
        if (u.isPresent()) {
            User user = u.get();
            user.setName(userParam.getName());
            user.setAddress(userParam.getAddress());
            user = ur.save(user);

            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
        ur.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
