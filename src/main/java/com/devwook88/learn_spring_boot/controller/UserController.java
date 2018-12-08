package com.devwook88.learn_spring_boot.controller;

import com.devwook88.learn_spring_boot.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    private static List<User> userList = new ArrayList<User>();
    {
        userList.add(new User(0, "jpub01", "user01@test.com", "remine", new Date()));
        userList.add(new User(1, "jpub02", "user02@test.com", "wook", new Date()));
        userList.add(new User(2, "jpub03", "user03@test.com", "wang", new Date()));
        userList.add(new User(3, "jpub04", "user04@test.com", "kim", new Date()));
    }

    @RequestMapping("/user/{id}")
    public ResponseEntity<User> getUserInfo(@PathVariable int id) {
        User user = userList.get(id);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @RequestMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        HashMap<String, Object> result = new HashMap();
        result.put("result", userList);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
