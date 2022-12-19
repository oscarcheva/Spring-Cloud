package com.restfulservices.restwebservice.JPA;

import com.restfulservices.restwebservice.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


}
