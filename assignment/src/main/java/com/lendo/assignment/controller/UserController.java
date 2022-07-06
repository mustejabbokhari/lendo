package com.lendo.assignment.controller;

import com.lendo.assignment.dto.Comment;
import com.lendo.assignment.dto.User;
import com.lendo.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/users",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<User> getUsers(){
        return userService.getUsers();
    }

}
