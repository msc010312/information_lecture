package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id // id값 지정
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가 옵션
    @Column(name="bookcode") // 컬럼명 설정
    private Long bookCode;
    @Column(name="bookname")
    private String bookName;
    private String publisher;
    private String isbn;
}
