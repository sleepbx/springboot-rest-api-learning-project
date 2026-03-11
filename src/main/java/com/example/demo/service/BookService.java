package com.example.demo.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookService {

    @Cacheable(value = "books", key = "#id")
    public Book getBookById(Long id) {

        log.info("Fetching book {} from database", id);

        return new Book(id, "Spring Boot in Action", "Craig Walls");
    }

    @CachePut(value = "books", key = "#book.id")
    public Book updateBook(Book book) {

        log.info("Updating book {} in database", book.getId());

        return book;
    }

    @CacheEvict(value = "books", key = "#id")
    public void deleteBook(Long id) {

        log.info("Deleting book {} from database", id);
    }
}