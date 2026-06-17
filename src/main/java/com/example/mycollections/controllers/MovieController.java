package com.example.mycollections.controllers;

import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final List<Movie> movies = new ArrayList<>() {{

        add(new Movie("Dhurandhar", "Aditya Dhar", 2025, 214));
        add(new Movie("Goopy Gyne Bagha Byne", "Satyajit Ray", 1969, 132));
        add(new Movie("Sholay", "Ramesh Sippy", 1975, 204));

    }};
    @GetMapping("/json")
    public List<Movie> getMoviesJson() {
        return movies;
    }

    @GetMapping("/html")
    public String getMoviesHtml() {
        String movieList = "<ul>";
        for (Movie movie : movies) {
            movieList += "<li>" + movie + "</li>";
        }
        movieList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Movies</h1>
                """ +
                movieList +
                """
                    </body>
                </html>
                """;
    }
}