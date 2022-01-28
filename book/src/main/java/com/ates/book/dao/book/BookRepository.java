package com.ates.book.dao.book;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ates.book.dao.model.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long>{
}
