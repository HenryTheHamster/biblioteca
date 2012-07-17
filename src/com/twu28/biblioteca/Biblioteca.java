package com.twu28.biblioteca;

import com.twu28.biblioteca.io.CustomInputStream;
import com.twu28.biblioteca.io.CustomOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 17/07/12
 * Time: 4:54 PM
 */
public class Biblioteca {

    private CustomInputStream in;
    private CustomOutputStream out;
    private String[] mainMenuOptions = {"List all books",
                                        "Reserve a book",
                                        "Check library number",
                                        "Exit"};


    public Biblioteca(CustomInputStream in, CustomOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public void displayWelcomeMessage() {
        out.println("Welcome to the Bangalore Library Biblioteca System!");
    }

    public void displayMainMenu() {
        out.println("Please select from the following options:");
        for(int i = 0; i < mainMenuOptions.length; i++) {
            out.println("[" + (i+1) + "] " + mainMenuOptions[i]);
        }
    }

}
