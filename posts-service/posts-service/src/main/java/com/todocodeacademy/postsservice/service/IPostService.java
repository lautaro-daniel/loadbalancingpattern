package com.todocodeacademy.postsservice.service;

import com.todocodeacademy.postsservice.model.Post;

import java.util.List;

public interface IPostService {

    List<Post> getPostByUser(Long id_user);
}
