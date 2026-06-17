package com.example.mycollections.models;

public class Movie extends LibraryItem {
    private String director;
    private int length;

    public Movie(String name, String director, int year, int length) {
        super(name, year);
        this.director = director;
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return name + " directed by " + director;
    }
}