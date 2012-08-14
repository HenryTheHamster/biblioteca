package com.twu28.biblioteca.presentation;

import com.twu28.biblioteca.persistence.Book;
import com.twu28.biblioteca.businesslogic.LibraryHandler;
import com.twu28.biblioteca.persistence.Movie;
import com.twu28.biblioteca.persistence.User;
import com.twu28.biblioteca.businesslogic.UserHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 17/07/12
 * Time: 4:54 PM
 */
public class Biblioteca {

    private static final Book[] standardBookList = {new Book("The Agile Samurai", "Jonathan Rasmusson"),
                                                    new Book("Head First Java", "Kathy Sierra and Bert Bates")};

    private static final Movie[] standardMovieList = {new Movie("Underworld Awakening", "Mans Marlind and Bjorn Stein", 3),
                                                      new Movie("Lock, Stock and Two Smoking Barrels", "Guy Ritchie", 9),
                                                      new Movie("The Dark Knight Rises", "Christopher Nolan")};

    private static final User[] standardUserList = {new User("111-1111", "librarian"),
                                                    new User("111-1112", "andrew")};


    private DisplayHandler display;
    private LibraryHandler bookLibrary;
    private LibraryHandler movieLibrary;
    private UserHandler userSystem;

    public Biblioteca(CustomInputStream in, CustomOutputStream out) {

        this.display = new DisplayHandler(in, out);

        bookLibrary = new LibraryHandler(display, standardBookList);
        movieLibrary = new LibraryHandler(display, standardMovieList);
        userSystem = new UserHandler(display, standardUserList);

    }

    public void displayWelcomeMessage() {
        display.displayMessage("Welcome to the Bangalore Library Biblioteca System!");
    }

    public void displayMainMenu() {



        while(true) {

            List<String> menuOptions = new ArrayList<String>();
            menuOptions.add("List all books");
            menuOptions.add("Reserve a book");
            menuOptions.add("List all movies");
            menuOptions.add("Check library number");
            if(userSystem.hasUserLoggedIn()) {
                menuOptions.add("Logout");
            } else {
                menuOptions.add("Login");
            }
            menuOptions.add("Exit");

            Object selectedOption = display.displayMenu("= Main Menu =", menuOptions.toArray());

            int selectedIndex = menuOptions.indexOf(selectedOption);

            switch (selectedIndex) {
                case 0:
                    bookLibrary.displayItemList();
                    break;
                case 1:
                    bookLibrary.displayReserveMenu();
                    break;
                case 2:
                    movieLibrary.displayItemList();
                    break;
                case 3:
                    userSystem.displayLibraryNumberMessage();
                    break;
                case 4:
                    if(userSystem.hasUserLoggedIn()) {
                        userSystem.logoutUser();
                    } else {
                        userSystem.loginUser();
                    }
                    break;
                case 5:
                    display.displayMessage("Goodbye!");
                    System.exit(0);
                    break;
            }
        }

    }

}
