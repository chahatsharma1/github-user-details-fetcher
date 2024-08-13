package com.example.github.project.demo.controllers;

import com.example.github.project.demo.users.GithubUsers;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Personal {
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/users/{username}")
    public GithubUsers getUser(@PathVariable String username) {
        ResponseEntity<GithubUsers> responseEntity = restTemplate.getForEntity(String.format("https://api.github.com/users/%s", username), GithubUsers.class);
        return responseEntity.getBody();
    }
}
