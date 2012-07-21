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


    public Biblioteca(CustomInputStream in, CustomOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public void displayWelcomeMessage() {
        out.println("Welcome to the Bangalore Library Biblioteca System!");
    }

    public int displayMainMenu(List<String> menuOptions) {
        out.println("Please select from the following options:");

        for(int i = 0; i < menuOptions.size(); i++) {
            out.println("[" + (i+1) + "] " + menuOptions.get(i));
        }

        try {
            return getUserIntInput(1, menuOptions.size());
        } catch(IOException e) {
            e.printStackTrace();
            return -1; // return default invalid value
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


/*
    public void performMainMenuAction(int selection) {
        switch (selection) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }
    }
  */
    public void displayBookList(List<Book> books) {

        for(Book b : books) {
            out.println(b.getTitle() + " by " + b.getAuthor());
        }

    }

    public void displayReserveMenu(List<Book> books) {

        out.println("Please select a book to reserve:");
        for(int i = 0; i < books.size(); i++) {
            out.println("[" + (i+1) + "] " + books.get(i).getTitle() + " by " + books.get(i).getAuthor());
        }

        try {
            int selection = getUserIntInput(1, books.size());
            reserveBook(books.get(selection - 1));
        } catch (IOException e) {

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

    public void displayLibraryNumberMessage() {
        out.println("Please talk to Librarian. Thank you.");
    }


}
