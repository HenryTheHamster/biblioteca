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
        mainMenuOptions.add("Check library number");
        mainMenuOptions.add("Exit");

        List<Book> books = new ArrayList<Book>();
        books.add(new Book("The Agile Samurai", "Jonathon Rasmusson"));
        books.add(new Book("Head First Java", "Kathy Sierra and Bert Bates"));

        while(true) {


            Biblioteca biblioteca = new Biblioteca(consoleInput, consoleOutput);
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
                    // Display library number
                    biblioteca.displayLibraryNumberMessage();
                    break;
                case 4:
                    // Exit
                    System.exit(0);
            }



        }

    }
}
