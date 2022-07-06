package com.lendo.assignment.service;

import com.lendo.assignment.dto.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getComments(Integer postID);
}
