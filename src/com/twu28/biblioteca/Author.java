package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 14/07/12
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Author {

    private String lastName, firstName;

    public Author(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }
}
