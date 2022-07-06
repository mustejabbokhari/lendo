package com.lendo.assignment.service;

import com.lendo.assignment.dto.Post;

import java.util.List;

public interface PostService {
    List<Post> getPost(Integer userId);
}
