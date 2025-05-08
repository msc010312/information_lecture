package com.example.demo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id // id값 지정
    @Column(length = 255) // 길이, notnull 설정
    private String username;
    @Column(length = 255, nullable = false)
    private String password;
    @Column(length = 255)
    private String role;
}
