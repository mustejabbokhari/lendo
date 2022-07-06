package com.lendo.assignment.controller;

import com.lendo.assignment.dto.Post;
import com.lendo.assignment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
   private PostService postService;
    @RequestMapping(value = "/posts",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Post> getPosts(@RequestParam(required = false) Integer userID){
        return postService.getPost(userID);
    }
}
