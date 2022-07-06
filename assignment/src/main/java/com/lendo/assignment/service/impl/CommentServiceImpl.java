package com.lendo.assignment.service.impl;

import com.lendo.assignment.dto.Comment;
import com.lendo.assignment.service.CommentService;
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
public class CommentServiceImpl implements CommentService {
    @Value("${third.party.base.url}")
    private String baseURL;
    @Autowired
    RestTemplate restTemplate;
    @Override
    public List<Comment> getComments(Integer postID) {
        ResponseEntity<Comment[]> responseEntity=  restTemplate.getForEntity(baseURL.concat("comments"),Comment[].class);
        List<Comment> comments = Arrays.asList(responseEntity.getBody());
        if(Objects.nonNull(postID)){
            return comments.stream().filter(comment->comment.getPost_id()==postID).collect(Collectors.toList());
        }
        return comments;

    }
}
