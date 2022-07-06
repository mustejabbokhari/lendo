package com.lendo.assignment.controller;

import com.lendo.assignment.dto.Comment;
import com.lendo.assignment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comments",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Comment> getComments(@RequestParam(required = false) Integer postID){
        return commentService.getComments(postID);
    }
}
