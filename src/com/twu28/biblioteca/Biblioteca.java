package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 17/07/12
 * Time: 4:54 PM
 */
public class Biblioteca {
    private CustomOutputStream out;

    public Biblioteca(CustomOutputStream out) {
        this.out = out;
    }

    public void displayWelcomeMessage() {
        out.println("Welcome to the Bangalore Library Biblioteca System!");
    }
}
