package com.example.test.service;

import com.example.test.dto.User;
import com.example.test.entity.UserEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


public interface UserService {


    String usercreate(@RequestBody UserEntity userEntity);

    List<UserEntity> Usersee();

    Optional<UserEntity> Userfiltersee(@PathVariable Long id);

    String Userdel(@PathVariable Long id);

    String Userupload(@PathVariable("id") Long id, @RequestBody User user);
}
