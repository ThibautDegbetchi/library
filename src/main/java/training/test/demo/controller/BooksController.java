package training.test.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import training.test.demo.services.BookService;

@Controller
@RequestMapping("/book")
public class BooksController {
    private BookService bookService;

    @GetMapping("")
    public String showHome(){
        return  "Book/books";
    }

    @GetMapping("/add")
    public String addBook(){
        return  "Book/addBook";
    }
}
