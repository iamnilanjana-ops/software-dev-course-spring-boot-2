package com.example.mycollections.controllers;

import com.example.mycollections.models.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final List<Book> books = new ArrayList<>() {{
        add(new Book("Pather Panchali", "Bibhutibhushan Bandyopadhyay", 1929, 300));
        add(new Book("Chokher Bali", "Rabindranath Tagore", 1903, 250));
        add(new Book("Devdas", "Sarat Chandra Chattopadhyay", 1917, 200));
    }};

    @GetMapping("/json")
    public List<Book> getBooksJson() {
        return books;
    }

    @GetMapping("/html")
    public String getBooksHtml() {
        String bookList = "<ul>";
        for (Book book : books) {
            bookList += "<li>" + book + "</li>";
        }
        bookList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Books</h1>
                        <ul>
                """ +
                bookList + 
                """
                        </ul>
                    </body>
                """;
    }

}
