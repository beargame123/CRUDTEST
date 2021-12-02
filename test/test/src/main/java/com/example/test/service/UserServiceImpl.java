package com.example.test.service;

import com.example.test.dto.User;
import com.example.test.entity.UserEntity;
import com.example.test.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    // 글등록
    @Override
    public String usercreate(@RequestBody UserEntity userEntity){
        userRepository.save(userEntity);
        return "글이 등록되었습니다!";
    }

    //글 전체보기
    @Override
    public List<UserEntity> Usersee(){
        return userRepository.findAll();
    }

    //글 선택해서보기
    @Override
    public Optional<UserEntity> Userfiltersee(@PathVariable Long id){
        return userRepository.findById(id);
    }

    //글 삭제
    @Override
    public String Userdel(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "글이 삭제되었습니다!";
    }

    //글 수정
    @Override
    public String Userupload(@PathVariable("id") Long id, @RequestBody User user){
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setTitle(user.getTitle());
        userEntity.setContent(user.getContent());
        return "바뀜";
    }
}
