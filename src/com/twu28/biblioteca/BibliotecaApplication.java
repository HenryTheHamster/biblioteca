package com.twu28.biblioteca;

import com.twu28.biblioteca.io.CustomInputStream;
import com.twu28.biblioteca.io.CustomOutputStream;
import com.twu28.biblioteca.io.SystemConsoleInputStream;
import com.twu28.biblioteca.io.SystemConsoleOutputStream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 17/07/12
 * Time: 5:02 PM
 */
public class BibliotecaApplication {



    public static void main(String[] args) {

        CustomInputStream consoleInput = new SystemConsoleInputStream();
        CustomOutputStream consoleOutput = new SystemConsoleOutputStream();

        List<String> mainMenuOptions = new ArrayList<String>();
        mainMenuOptions.add("List all books");
        mainMenuOptions.add("Reserve a book");
        mainMenuOptions.add("List all movies");
        mainMenuOptions.add("Check library number");
        mainMenuOptions.add("Login");
        mainMenuOptions.add("Logout");
        mainMenuOptions.add("Exit");

        List<User> users = new ArrayList<User>();
        users.add(new User("111-1111", "librarian"));
        users.add(new User("111-1112", "andrew"));

        List<Book> books = new ArrayList<Book>();
        books.add(new Book("The Agile Samurai", "Jonathan Rasmusson"));
        books.add(new Book("Head First Java", "Kathy Sierra and Bert Bates"));

        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Lock, Stock and Two Smoking Barrels", "Guy Ritchie", 8));
        movies.add(new Movie("Wallace and Gromit in the Wrong Trousers", "Nick Park", 10));
        movies.add(new Movie("The Dark Knight Rises", "Christopher Nolan"));

        Biblioteca biblioteca = new Biblioteca(consoleInput, consoleOutput, users);

        while(true) {



            biblioteca.displayWelcomeMessage();

            switch(biblioteca.displayMainMenu(mainMenuOptions)) {
                case 1:
                    // List books
                    biblioteca.displayBookList(books);
                    break;
                case 2:
                    // Reserve books
                    biblioteca.displayReserveMenu(books);
                    break;
                case 3:
                    // Display all movies
                    biblioteca.displayMovieList(movies);
                    break;
                case 4:
                    // Display library number
                    biblioteca.displayLibraryNumberMessage();
                    break;
                case 5:
                    // Login user
                    biblioteca.loginUser();
                    break;
                case 6:
                    // Logout user
                    biblioteca.logoutUser();
                    break;
                case 7:
                    // Exit
                    System.exit(0);
            }



        }

    }
}
