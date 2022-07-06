package com.lendo.assignment.service.impl;

import com.lendo.assignment.dto.Post;
import com.lendo.assignment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Value("${third.party.base.url}")
    private String baseURL;
    @Autowired
    RestTemplate restTemplate;
    @Override
    public List<Post> getPost(Integer userId) {

        ResponseEntity<Post[]> responseEntity=  restTemplate.getForEntity(baseURL.concat("posts"),Post[].class);
        List<Post> posts = Arrays.asList(responseEntity.getBody());
        if(Objects.nonNull(userId)){
            return posts.stream().filter(post->post.getUser_id()==userId).collect(Collectors.toList());
        }
        return posts;

    }
}
