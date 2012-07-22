package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 21/07/12
 * Time: 9:30 PM
 */
public class User {
    private String libraryNumber;
    private String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

}
