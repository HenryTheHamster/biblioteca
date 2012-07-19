package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 18/07/12
 * Time: 8:39 PM
 */
public class Book {


    private String title;
    private String author;
    private boolean reserved;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
