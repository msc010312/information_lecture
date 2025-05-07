package com.example.demo.domain.repository;

import com.example.demo.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

    @Query("select u from User AS u where u.role=?1") // query문으로 검색(주로 join에 많이 쓰임)
    List<User> selectByRole(String role);

    @Query("select u from User AS u where u.role=?1 and u.password?2")
    List<User> selectByRoleAndPassword(String role, String password);

    @Query("select u from User AS u where u.password=:password")
    List<User> selectByPassword(@Param("password") String pw);

    @Query("select u from User u where u.username Like CONCAT('%',:username,'%')")
    List<User> selectAllLikeUsername(@Param("username") String username);
}
