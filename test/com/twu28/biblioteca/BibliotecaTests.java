package com.twu28.biblioteca;

import com.twu28.biblioteca.io.TestSpecificInputStream;
import com.twu28.biblioteca.io.TestSpecificOutputStream;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 17/07/12
 * Time: 4:29 PM
 */
public class BibliotecaTests {


    @Test
    public void shouldDisplayWelcomeMessage() {

        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out);


        biblioteca.displayWelcomeMessage();

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Welcome to the Bangalore Library Biblioteca System!");

        assertEquals(expectedOutput, out.getOutput());

    }

    @Test
    public void shouldDisplayMenuOptions() {

        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out);

        List<String> menuOptions = new ArrayList<String>();
        menuOptions.add("List all books");
        menuOptions.add("Reserve a book");
        menuOptions.add("Check library number");
        menuOptions.add("Exit");


        in.addInput("4");
        biblioteca.displayMainMenu(menuOptions);


        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Please select from the following options:");
        expectedOutput.add("[1] List all books");
        expectedOutput.add("[2] Reserve a book");
        expectedOutput.add("[3] Check library number");
        expectedOutput.add("[4] Exit");

        assertEquals(expectedOutput, out.getOutput());
    }

    @Test
    public void shouldAcceptValidIntSelection() {
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out);

        in.addInput("4");

        int inputInt = -1;
        try {
            inputInt = biblioteca.getUserIntInput(0, 10);
        } catch(IOException e) {
            e.printStackTrace();
        }

        assertEquals(4, inputInt);
    }

    @Test
    public void shouldWarnOfInvalidIntSelection() {
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out);

        in.addInput("11");
        in.addInput("2");

        int inputInt = -1;
        try {
            inputInt = biblioteca.getUserIntInput(0, 10);
        } catch(IOException e) {
            e.printStackTrace();
        }

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Select a valid option!!");

        assertEquals(expectedOutput, out.getOutput());

    }

    @Test
    public void shouldDisplayListOfBooks() {
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out);

        List<Book> books = new ArrayList<Book>();
        books.add(new Book("The Agile Samurai", "Jonathan Rasmusson"));
        books.add(new Book("Head First Java", "Kathy Sierra and Bert Bates"));

        biblioteca.displayBookList(books);

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("The Agile Samurai by Jonathan Rasmusson");
        expectedOutput.add("Head First Java by Kathy Sierra and Bert Bates");

        assertEquals(expectedOutput, out.getOutput());

    }

    @Test
    public void shouldDisplayReserveMenu() {
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out);

        List<Book> books = new ArrayList<Book>();
        books.add(new Book("The Agile Samurai", "Jonathan Rasmusson"));
        books.add(new Book("Head First Java", "Kathy Sierra and Bert Bates"));

        in.addInput("1");
        biblioteca.displayReserveMenu(books);

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Please select a book to reserve:");
        expectedOutput.add("[1] The Agile Samurai by Jonathan Rasmusson");
        expectedOutput.add("[2] Head First Java by Kathy Sierra and Bert Bates");
        expectedOutput.add("Thank You! Enjoy the book.");

        assertEquals(expectedOutput, out.getOutput());
    }

    @Test
    public void shouldReserveAvailableBook() {
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out);

        Book book = new Book("The Agile Samurai", "Jonathan Rasmusson");

        biblioteca.reserveBook(book);

        assertTrue(book.isReserved());
    }



    @Test
    public void shouldDisplayReserveMessages() {
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out);

        Book book = new Book("The Agile Samurai", "Jonathan Rasmusson");

        biblioteca.reserveBook(book);
        biblioteca.reserveBook(book);

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Thank You! Enjoy the book.");
        expectedOutput.add("Sorry we don't have that book yet.");

        assertEquals(expectedOutput, out.getOutput());
    }


    @Test
    public void shouldDisplayLibraryNumberMessage() {
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out);

        biblioteca.displayLibraryNumberMessage();

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Please talk to Librarian. Thank you.");

        assertEquals(expectedOutput, out.getOutput());
    }



}
