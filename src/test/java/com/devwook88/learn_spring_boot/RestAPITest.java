package com.devwook88.learn_spring_boot;

import com.devwook88.learn_spring_boot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestAPITest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestAPITest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetUserById() {
        String url = "http://localhost:8080/user/0";
        User user = restTemplate.getForObject(url, User.class);
        System.out.println("등록일 : " + user.getDateCreated() + ", " + user.getUsername());
    }

    @Test
    public void testGetUsers() {
        String url = "http://localhost:8080/users";
        ResponseEntity<Map<String, List<User>>> result = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Map<String, List<User>>>() {}
        );

        Map<String, List<User>> tempMap = (Map)result.getBody();

        ArrayList<User> users = (ArrayList<User>)tempMap.get("result");
        for(User user : users) {
            System.out.println(user.getUsername());
        }
    }
}
