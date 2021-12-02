package com.example.test.controller;

import com.example.test.dto.User;
import com.example.test.entity.UserEntity;
import com.example.test.repository.UserRepository;
import com.example.test.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    //글 전체보기
    @GetMapping("/user")
    public List<UserEntity> Usersee(){
        return userService.Usersee();
    }

    //글 선택보기
    @GetMapping("/user/{id}")
    public Optional<UserEntity> Userfiltersee(@PathVariable Long id){
        return userService.Userfiltersee(id);
    }

    //글 올리기
    @PostMapping("/user")
    public void Usercreate(@RequestBody UserEntity userEntity){
        userService.usercreate(userEntity);
    }

    //글 삭제하기
    @DeleteMapping("/user/{id}")
    public void Userdel(@PathVariable Long id) {
        userService.Userdel(id);
    }

    // 글 수정하기
    @Transactional
    @PutMapping("/user/{id}")
    public void Userupload(@PathVariable("id") Long id, @RequestBody User user){
        userService.Userupload(id, user);
    }
}

