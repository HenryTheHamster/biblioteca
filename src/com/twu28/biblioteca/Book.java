package com.twu28.biblioteca;



/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 14/07/12
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Book {

    private String title;
    private Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }

}
