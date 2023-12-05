package com.todocodeacademy.usersservice.service;

import com.todocodeacademy.usersservice.dto.PostDTO;
import com.todocodeacademy.usersservice.dto.UserDTO;
import com.todocodeacademy.usersservice.model.User;
import com.todocodeacademy.usersservice.repository.IUserRepository;
import com.todocodeacademy.usersservice.repository.PostAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private PostAPI postAPI;

    @Override
    public UserDTO getUserAndPosts(Long user_id) {

        //traer datos de usuarios de bd
        User user = iUserRepository.findById(user_id).orElse(null);

        //una vez que tengo los datos necesito los posteos
        //traigo posteos desde la api de posteos
        List<PostDTO> posts_list = postAPI.getPostByUserId(user_id);

        //unificar datos del usuario + posteos mediante PostDTO
        UserDTO userDTO = new UserDTO(user.getUser_id(), user.getName(), user.getLastname(),
                user.getCellphone(), posts_list);


        return userDTO;
    }
}
