package com.restfulservices.restwebservice.User;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOService {
    private static List<User> userList = new ArrayList<>();

    static int userCount = 1;

    static {
        userList.add(new User(userCount++, "Oscar", LocalDate.now().minusYears(30)));
        userList.add(new User(userCount++, "Enrique", LocalDate.now().minusYears(20)));
        userList.add(new User(userCount++, "Lus", LocalDate.now().minusYears(25)));
    }

    public List<User> findAll() {
        return userList;
    }

    public User getUser(int id) {
        return userList
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst().orElse(null);
    }

    public User addUser(User user) {
        user.setId(userCount);
        userCount++;
        userList.add(user);
        return userList
                .stream()
                .filter(anUser -> anUser.getId().equals(user.getId()))
                .findFirst().orElse(null);
    }

    public void deleteUser(int id) {
        userList.remove(userList
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst().orElse(null));
    }
}
