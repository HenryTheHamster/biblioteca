package com.twu28.biblioteca;

import com.twu28.biblioteca.io.CustomInputStream;
import com.twu28.biblioteca.io.CustomOutputStream;

import java.io.IOException;
import java.util.List;

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

    public int getUserIntInput(int lower, int upper) throws IOException {

        while(true) {
            String inputString = in.readLine();
            try {
                int inputInt = Integer.parseInt(inputString);
                if(inputInt >= lower && inputInt <= upper) {
                    return inputInt;
                } else {
                    out.println("Select a valid option!!");
                }
            } catch (NumberFormatException e) {
                // not a valid integer
                out.println("Select a valid option!!");
            }
        }
    }

    public void displayBookMenu(List<Book> books) {

        for(Book b : books) {
            out.println(b.getTitle() + " by " + b.getAuthor());
        }

    }

    public void displayReserveMenu(List<Book> books) {
        out.println("Please select a book to reserve:");
        for(int i = 0; i < books.size(); i++) {
            out.println("[" + (i+1) + "] " + books.get(i).getTitle() + " by " + books.get(i).getAuthor());
        }
    }

    public void reserveBook(Book book) {
        if(book.isReserved()) {
            out.println("Sorry we don't have that book yet.");
        } else {
            book.setReserved(true);
            out.println("Thank You! Enjoy the book.");
        }
    }
}
