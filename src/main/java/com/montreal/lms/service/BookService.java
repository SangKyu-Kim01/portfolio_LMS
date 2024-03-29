package com.montreal.lms.service;

import com.montreal.lms.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(int theId);

    void save(Book theBook);

    void deleteById(int theId);
}
