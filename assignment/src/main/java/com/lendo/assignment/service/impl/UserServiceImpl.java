package com.lendo.assignment.service.impl;

import com.lendo.assignment.dto.User;
import com.lendo.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Value("${third.party.base.url}")
    private String baseURL;
    @Autowired
    RestTemplate restTemplate;
    @Override
    public List<User> getUsers() {
        ResponseEntity<User[]> responseEntity=  restTemplate.getForEntity(baseURL.concat("users"),User[].class);
        return Arrays.asList(responseEntity.getBody());

    }
}
