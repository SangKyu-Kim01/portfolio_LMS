package com.montreal.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.montreal.lms.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
