package com.example.demo.domain.repository;

import com.example.demo.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void t1() throws Exception{
//        User user = User.builder().username("aaa").password("1234").role("admin").build();
//        userRepository.save(user);

//        user.setPassword("5678");
//        user.setRole("user");
//        userRepository.save(user);

        userRepository.deleteById("aaa");
    }

    @Test
    public void t2() throws Exception {
//        List<User> list = userRepository.selectByRole("user");
        List<User> list = userRepository.selectAllLikeUsername("a");
        list.stream().forEach(System.out::println);
    }
}