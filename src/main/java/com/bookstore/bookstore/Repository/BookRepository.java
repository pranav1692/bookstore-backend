package com.bookstore.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookstore.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    
}
