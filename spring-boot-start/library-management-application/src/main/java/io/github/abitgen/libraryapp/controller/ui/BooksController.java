package io.github.abitgen.libraryapp.controller.ui;

import io.github.abitgen.libraryapp.repo.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ViewResolver;

@Controller
public class BooksController {

    private BookRepo bookRepo;

    BooksController(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }

    @RequestMapping("/books")
    private String getBooks(Model model){
        model.addAttribute("books",bookRepo.findAll());
        return "books";
    }
}
