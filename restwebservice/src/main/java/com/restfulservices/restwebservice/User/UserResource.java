package com.restfulservices.restwebservice.User;

import com.restfulservices.restwebservice.Error.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    UserDAOService service;

    @GetMapping("/users")
    public List<User> displayAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User displayUser(@PathVariable int id) {
        User user = service.getUser(id);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody @Valid User user) {
        User savedUser = service.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        return "User deleted";
    }
}