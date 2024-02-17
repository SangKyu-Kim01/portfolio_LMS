package com.montreal.lms.controller;

import com.montreal.lms.service.BookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.montreal.lms.entity.Book;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;
    public BookController(BookService theBookService){
        bookService = theBookService;
    }

    @GetMapping("/list")
    public String listBooks(Model theModel){
        // get the book from DB
        List<Book> theBooks = bookService.findAll();
        theModel.addAttribute("books", theBooks);

        return "/books/list-books";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Book theBook = new Book();
        theModel.addAttribute("book", theBook);

        return "/books/book-form";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel){
        // get the book from the database
        Book theBook = bookService.findById(theId);

        // set book as a model attribute to pre-populate the form
        theModel.addAttribute("book", theBook);

        // send over to the book form
        return "/books/book-form";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int theId){
        // delete the book
        bookService.deleteById(theId);

        // redirect to /books/list
        return "redirect:/books/list";
    }


    // handle save event
    @PostMapping("/save")
    public String saveBook(@Valid @ModelAttribute("book") Book theBook,
                           BindingResult theBindingResult
    ){
        if(theBindingResult.hasErrors()){
            return "/books/book-form";
        }else {
            bookService.save(theBook);
            return "redirect:/books/list";
        }
    }

}
