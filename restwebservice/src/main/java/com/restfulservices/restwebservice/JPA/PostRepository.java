package com.restfulservices.restwebservice.JPA;

import com.restfulservices.restwebservice.User.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {


}
