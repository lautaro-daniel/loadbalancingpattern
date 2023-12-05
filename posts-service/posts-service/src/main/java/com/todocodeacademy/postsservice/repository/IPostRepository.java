package com.todocodeacademy.postsservice.repository;

import com.todocodeacademy.postsservice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.user_id = :user_id")/*selecciona todos los
                                                                posteos desde post donde el id
                                                                de usuario de ese posteo que estoy
                                                                encontrando sea igual al user_id que
                                                                te paso como parametro*/
    List<Post> findPostByUserId(Long user_id);
}
