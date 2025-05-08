package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void t1() throws Exception{
        //Insert
//        Book book = Book.builder().bookCode(1111L).bookName("aaaa").publisher("bbbb").isbn("cccc").build();
        //bookRepository.save(book);

        //Update
//        book.setBookName("AAAA");
//        book.setPublisher("BBBB");
//        book.setIsbn("CCCC");
//        bookRepository.save(book);

        //Delete
        bookRepository.deleteById(1111L);


    }

    @Test
    public void t2() throws Exception {
        Optional<Book> bookOptional = bookRepository.findById(1111L);
        if(bookOptional.isPresent())
            System.out.println(bookOptional.get());
        //List<Book> list = bookRepository.findByBookName("aaa");
        //List<Book> list = bookRepository.findByPublisher("qqq");
        List<Book> list = bookRepository.findByIsbn("22-22");
        System.out.println(list);

        Book find = bookRepository.findByBookNameAndIsbn("aaa","11-11");
        System.out.println(find);

        List<Book> list2 = bookRepository.findByBookNameContains("a");
        list2.stream().forEach(System.out::println);
    }
}