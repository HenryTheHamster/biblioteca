package com.twu28.biblioteca;

import com.twu28.biblioteca.io.TestSpecificInputStream;
import com.twu28.biblioteca.io.TestSpecificOutputStream;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
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

        List<User> users = getUserList();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out, users);


        biblioteca.displayWelcomeMessage();

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Welcome to the Bangalore Library Biblioteca System!");
        expectedOutput.add("You are not logged in.");

        assertEquals(expectedOutput, out.getOutput());

    }

    @Test
    public void shouldDisplayMenuOptions() {

        List<User> users = getUserList();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out, users);

        List<String> menuOptions = getMainMenuOptions();

        in.addInput("4");
        biblioteca.displayMainMenu(menuOptions);


        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Please select from the following options:");
        expectedOutput.add("[1] List all books");
        expectedOutput.add("[2] Reserve a book");
        expectedOutput.add("[3] List all movies");
        expectedOutput.add("[4] Check library number");
        expectedOutput.add("[5] Login");
        expectedOutput.add("[6] Logout");
        expectedOutput.add("[7] Exit");

        assertEquals(expectedOutput, out.getOutput());
    }

    @Test
    public void shouldAcceptValidIntSelection() {
        List<User> users = getUserList();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out, users);

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
        List<User> users = getUserList();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out, users);

        in.addInput("11");
        in.addInput("");
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
        List<User> users = getUserList();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out, users);

        List<Book> books = getBookList();

        biblioteca.displayBookList(books);

        /*
        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("The Agile Samurai by Jonathan Rasmusson");
        expectedOutput.add("Head First Java by Kathy Sierra and Bert Bates");
*/

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Title                         Author                        ");
        expectedOutput.add("------------------------------------------------------------");
        expectedOutput.add("The Agile Samurai             Jonathan Rasmusson            ");
        expectedOutput.add("Head First Java               Kathy Sierra and Bert Bates   ");

        assertEquals(expectedOutput, out.getOutput());

    }



    @Test
    public void shouldDisplayReserveMenu() {
        List<User> users = getUserList();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out, users);

        List<Book> books = getBookList();

        in.addInput("1");
        biblioteca.displayReserveMenu(books);

        /*
        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Please select a book to reserve:");
        expectedOutput.add("[1] The Agile Samurai by Jonathan Rasmusson");
        expectedOutput.add("[2] Head First Java by Kathy Sierra and Bert Bates");
        expectedOutput.add("Thank You! Enjoy the book.");
*/
        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("    Title                         Author                        ");
        expectedOutput.add("----------------------------------------------------------------");
        expectedOutput.add("[1] The Agile Samurai             Jonathan Rasmusson            ");
        expectedOutput.add("[2] Head First Java               Kathy Sierra and Bert Bates   ");
        expectedOutput.add("Thank You! Enjoy the book.");

        assertEquals(expectedOutput, out.getOutput());
    }

    @Test
    public void shouldReserveAvailableBook() {
        List<User> users = getUserList();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out, users);

        Book book = new Book("The Agile Samurai", "Jonathan Rasmusson");

        biblioteca.reserveBook(book);

        assertTrue(book.isReserved());
    }



    @Test
    public void shouldDisplayReserveMessages() {
        List<User> users = getUserList();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out, users);

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
        List<User> users = getUserList();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out, users);

        biblioteca.displayLibraryNumberMessage();

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Please talk to Librarian. Thank you.");

        assertEquals(expectedOutput, out.getOutput());
    }

    @Test
    public void shouldDisplayListOfMovies() {
        List<User> users = getUserList();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out, users);

        List<Movie> movies = getMovieList();

        biblioteca.displayMovieList(movies);

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Title                                             Director            Rating     ");
        expectedOutput.add("---------------------------------------------------------------------------------");
        expectedOutput.add("Lock, Stock and Two Smoking Barrels               Guy Ritchie         ********   ");
        expectedOutput.add("Wallace and Gromit in the Wrong Trousers          Nick Park           ********** ");
        expectedOutput.add("The Dark Knight Rises                             Christopher Nolan   N/A        ");

        assertEquals(expectedOutput, out.getOutput());

    }

    @Test
    public void shouldLoginUser() {
        List<User> users = getUserList();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out, users);


        in.addInput("111-1111");
        in.addInput("librarian");

        biblioteca.loginUser();

        assertEquals(users.get(0), biblioteca.getCurrentUser());

    }

    @Test
    public void shouldLogoutUser() {
        List<User> users = getUserList();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out, users);

        biblioteca.setCurrentUser(users.get(0));

        biblioteca.logoutUser();

        assertNull(biblioteca.getCurrentUser());
    }

    @Test
    public void shouldWarnOfIncorrectLibraryNumber() {
        List<User> users = getUserList();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out, users);

        in.addInput("000-0000");

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Please enter your library number:");
        expectedOutput.add("There are no registered users with that library number.");

        biblioteca.loginUser();

        assertEquals(expectedOutput, out.getOutput());
    }

    @Test
    public void shouldWarnOfIncorrectPassword() {
        List<User> users = getUserList();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out, users);

        in.addInput("111-1111");
        in.addInput("incorrect");

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Please enter your library number:");
        expectedOutput.add("Please enter your password:");
        expectedOutput.add("Incorrect password.");

        biblioteca.loginUser();

        assertEquals(expectedOutput, out.getOutput());
    }

    @Test
    public void shouldReportLibraryNumber() {
        List<User> users = getUserList();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        TestSpecificInputStream in = new TestSpecificInputStream();
        Biblioteca biblioteca = new Biblioteca(in, out, users);


        biblioteca.setCurrentUser(new User("111-1111", "librarian"));


        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Your library number is 111-1111");

        biblioteca.displayLibraryNumberMessage();

        assertEquals(expectedOutput, out.getOutput());
    }

    public List<String> getMainMenuOptions() {
        List<String> mainMenuOptions = new ArrayList<String>();
        mainMenuOptions.add("List all books");
        mainMenuOptions.add("Reserve a book");
        mainMenuOptions.add("List all movies");
        mainMenuOptions.add("Check library number");
        mainMenuOptions.add("Login");
        mainMenuOptions.add("Logout");
        mainMenuOptions.add("Exit");
        return mainMenuOptions;
    }

    public List<Book> getBookList() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("The Agile Samurai", "Jonathan Rasmusson"));
        books.add(new Book("Head First Java", "Kathy Sierra and Bert Bates"));
        return books;
    }

    public List<Movie> getMovieList() {
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Lock, Stock and Two Smoking Barrels", "Guy Ritchie", 8));
        movies.add(new Movie("Wallace and Gromit in the Wrong Trousers", "Nick Park", 10));
        movies.add(new Movie("The Dark Knight Rises", "Christopher Nolan"));
        return movies;
    }

    public List<User> getUserList() {
        List<User> users = new ArrayList<User>();
        users.add(new User("111-1111", "librarian"));
        users.add(new User("111-1112", "andrew"));
        return users;
    }

}
