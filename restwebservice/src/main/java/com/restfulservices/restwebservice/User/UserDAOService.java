package com.restfulservices.restwebservice.User;

import com.restfulservices.restwebservice.Error.PostNotFoundException;
import com.restfulservices.restwebservice.Error.UserNotFoundException;
import com.restfulservices.restwebservice.JPA.PostRepository;
import com.restfulservices.restwebservice.JPA.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
public class UserDAOService {
    @Autowired
    UserRepository userRepo;

    @Autowired
    PostRepository postRepo;

    public List<User> getAllUsers() {

        return userRepo.findAll();
    }

    public User getUser(int id) {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User not found with Id: " + id);
        }
        return user;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(int id) {

        userRepo.delete(getUser(id));
    }

    public List<Post> getAllUsersPost(int userId) {
        return getUser(userId).getPosts();
    }

    public Post getAPost(int userId, int postId) throws PostNotFoundException {
        Post post = Optional.ofNullable(getUser(userId))
                .map(User::getPosts)
                .orElse(new ArrayList<>())
                .stream()
                .filter(v -> v.getId() == postId)
                .findFirst()
                .orElse(null);
        if (post == null) {
            throw new PostNotFoundException("Post not found with Id: " + postId + " for user: " + userId);
        }
        return post;
    }

    public Post createPost(int userId, Post post) {
        post.setUser(getUser(userId));
        return postRepo.save(post);
    }

    public void deletePost(int userId, int postId) throws PostNotFoundException {
        postRepo.delete(getAPost(userId, postId));
    }
}
