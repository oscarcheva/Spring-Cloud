package com.restfulservices.restwebservice.User;

import com.restfulservices.restwebservice.Error.PostNotFoundException;
import com.restfulservices.restwebservice.Error.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJPAResource {

    @Autowired
    UserDAOService service;

    @GetMapping("/jpa/users")
    public List<User> displayAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> displayUser(@PathVariable int id) {
        User user = service.getUser(id);
        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).displayAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> displayPostForUser(@PathVariable int id) {
        return service.getAllUsersPost(id);
    }

    @GetMapping("/jpa/users/{userId}/posts/{postid}")
    public Post getSpecificPostForUser(@PathVariable int userId, @PathVariable int postid)
            throws PostNotFoundException {
        return service.getAPost(userId, postid);
    }

    @DeleteMapping("/jpa/users/{userId}/posts/{postid}")
    public String deleteAPost(@PathVariable int userId, @PathVariable int postid)
            throws PostNotFoundException {
        return "Post deleted";
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> addUser(@RequestBody @Valid User user) {
        User savedUser = service.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/jpa/users/{userId}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int userId, @RequestBody @Valid Post post) {
        Post createdPost = service.createPost(userId, post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public String deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        return "User deleted";
    }
}
