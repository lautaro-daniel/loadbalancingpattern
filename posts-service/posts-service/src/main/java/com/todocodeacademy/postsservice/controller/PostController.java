package com.todocodeacademy.postsservice.controller;

import com.todocodeacademy.postsservice.model.Post;
import com.todocodeacademy.postsservice.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private IPostService iPostService;

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/{user_id}")
    public List<Post> getPostByUserId(@PathVariable Long user_id){
        System.out.println("--------Estoy en el puerto " + serverPort);
        return iPostService.getPostByUser(user_id);
    }
}
