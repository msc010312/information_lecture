package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByBookName(String bookname);
    List<Book> findByPublisher(String publisher);
    List<Book> findByIsbn(String isbn);

    Book findByBookNameAndIsbn(String bookName, String isbn); // 다중문자열 검색

    List<Book> findByBookNameContains(String keyword); // 호완문자열 검색

    void deleteByBookName(String bookname);
}
