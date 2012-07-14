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
    private boolean isReserved = false;

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

    public void reserveBook() {
        isReserved = true;
    }

    public void cancelReservations() {
        isReserved = false;
    }

    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }

}
