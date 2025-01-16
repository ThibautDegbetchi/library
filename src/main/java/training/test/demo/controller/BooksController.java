package training.test.demo.controller;

import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import training.test.demo.entities.Book;
import training.test.demo.services.BookService;

@Controller
@RequestMapping("/book")
public class BooksController {
    private static final Logger log = LogManager.getLogger(BooksController.class);
    @Autowired
    private BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public String showHome(Model model){
        model.addAttribute("books",bookService.getList());
        return  "Book/books";
    }

    @GetMapping("/add")
    public String addBook(Model model,Book book){
        model.addAttribute("book",book);
        return  "Book/addBook";
    }

    @PostMapping("save")
    public String saveBook(@Valid @ModelAttribute("book") Book book,Model model, RedirectAttributes res){
        try{
            model.addAttribute("book",book);
            bookService.save(book);
            return "redirect:/book";
        }catch (Exception e){
            log.error("error: ", e);
            return "Book/addBook";
        }
    }

    @GetMapping("{id}")
    public String updateBookScreen(@PathVariable Long id,Model model,RedirectAttributes res){
        try{
            Book book=bookService.findById(id);
            model.addAttribute("book",book);
            return "Book/update";
        }catch (Exception e){
            log.error("error: ", e);
            return "Book/books";
        }
    }

    @PostMapping("update/{id}")
    public String updateBook(@ModelAttribute("book") Book book,Model model,RedirectAttributes res){
        try{
            bookService.update(book);
            return "redirect:/book";
        }catch (Exception e){
            log.error("error: ", e);
            return "Book/update";
        }
    }

    @GetMapping("delete/{id}")
    public String delete(Model model,@PathVariable Long id,RedirectAttributes res){
        try{
//            model.addAttribute("id",id);
            bookService.delete(id);
            return "redirect:/book";
        } catch (Exception e) {
            log.error("error: ", e);
            return "redirect:/book";
        }
    }
}
