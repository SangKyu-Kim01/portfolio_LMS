package com.montreal.lms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {

    // define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull(message = "Title can not be null.")
    @Size(min = 1, message = "Title is required.")
    @Column(name="title")
    private String title;


    @NotNull(message = "Author can not be null.")
    @Size(min = 1, message = "Author is required.")
    @Column(name="author")
    private String author;

    @NotNull(message = "ISBN is required")
    @Size(min = 13, max = 13, message = "ISBN must be 13 digits number.")
    @Column(name="isbn")
    private String isbn;

    @Column(name="status")
    private Boolean status;

    // define constructor
    public Book(){
    }

    public Book(String title, String author, String isbn, Boolean status){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", status=" + status +
                '}';
    }
}
