package com.twu28.biblioteca;

import com.twu28.biblioteca.io.CustomInputStream;
import com.twu28.biblioteca.io.CustomOutputStream;

import java.io.IOException;
import java.util.HashMap;
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
    private HashMap<String, User> userHash = new HashMap<String, User>();
    private User currentUser = null;

    public Biblioteca(CustomInputStream in, CustomOutputStream out, List<User> userList) {
        this.in = in;
        this.out = out;
        for(User u : userList) {
            userHash.put(u.getLibraryNumber(), u);
        }
    }

    public void displayWelcomeMessage() {
        out.println("Welcome to the Bangalore Library Biblioteca System!");
        if(currentUser != null) {
            out.println("You are logged in as " + currentUser.getLibraryNumber());
        } else {
            out.println("You are not logged in.");
        }
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
                    awaitUserConfirmation();
                }
            } catch (NumberFormatException e) {
                // not a valid integer
                out.println("Select a valid option!!");
                awaitUserConfirmation();
            }
        }
    }


    public void displayBookList(List<Book> books) {
        /*
        for(Book b : books) {
            out.println(b.getTitle() + " by " + b.getAuthor());
        }
        */
        out.println(String.format("%-30s", "Title") + String.format("%-30s", "Author"));
        out.println(String.format("%-60s", "").replace(' ', '-'));
        for(Book b : books) {
            out.println(String.format("%-30s", b.getTitle()) + String.format("%-30s", b.getAuthor()));
        }

        awaitUserConfirmation();
    }

    public void displayReserveMenu(List<Book> books) {
        /*
        out.println("Please select a book to reserve:");
        for(int i = 0; i < books.size(); i++) {
            out.println("[" + (i+1) + "] " + books.get(i).getTitle() + " by " + books.get(i).getAuthor());
        }
        */

        out.println("    " + String.format("%-30s", "Title") + String.format("%-30s", "Author"));
        out.println(String.format("%-64s", "").replace(' ', '-'));
        for(int i = 0; i < books.size(); i++) {
            out.println("[" + (i+1) + "] " + String.format("%-30s", books.get(i).getTitle()) + String.format("%-30s", books.get(i).getAuthor()));
        }

        try {
            int selection = getUserIntInput(1, books.size());
            reserveBook(books.get(selection - 1));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void awaitUserConfirmation() {
        try {
            in.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void reserveBook(Book book) {
        if(book.isReserved()) {
            out.println("Sorry we don't have that book yet.");
            awaitUserConfirmation();
        } else {
            book.setReserved(true);
            out.println("Thank You! Enjoy the book.");
            awaitUserConfirmation();
        }
    }

    public void displayLibraryNumberMessage() {
        if(currentUser != null) {
            out.println("Your library number is " + currentUser.getLibraryNumber());
        } else {
            out.println("Please talk to Librarian. Thank you.");
        }
        awaitUserConfirmation();
    }


    public void displayMovieList(List<Movie> movies) {
        out.println(String.format("%-50s", "Title") + String.format("%-20s", "Director") + String.format("%-11s", "Rating"));
        out.println(String.format("%-81s", "").replace(' ', '-'));
        for(Movie m : movies) {
            out.println(String.format("%-50s", m.getTitle()) + String.format("%-20s", m.getDirector()) + String.format("%-11s", m.getRatingString()));
        }
        awaitUserConfirmation();
    }

    public void loginUser() {
        try {
            out.println("Please enter your library number:");
            String libraryNumber = in.readLine();
            if(!userHash.containsKey(libraryNumber)) {
                out.println("There are no registered users with that library number.");
                awaitUserConfirmation();
                return;
            }
            out.println("Please enter your password:");
            String password = in.readLine();
            if(!userHash.get(libraryNumber).getPassword().equals(password)) {
                out.println("Incorrect password.");
                awaitUserConfirmation();
                return;
            }
            currentUser = userHash.get(libraryNumber);
            out.println("Login successful!");
            awaitUserConfirmation();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }



    public void logoutUser() {
        if(currentUser != null) {
            currentUser = null;
            out.println("You have been logged out.");
        } else {
            out.println("You are not logged in!");
        }
        awaitUserConfirmation();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
