package com.twu28.biblioteca;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 14/07/12
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class NaiveMain {

    private Book[] books = {new Book("Hitchhikers Guide to the Galaxy", new Author("Adams", "Douglas")),
                            new Book("Mogworld", new Author("Chroshaw", "Yahtzee")),
                            new Book("The Agile Samurai", new Author("Rasmusson", "Jonathon")),
                            new Book("Head First Java", new Author("Sierra", "Kathy"))}; // head first is actually by TWO authors - how to deal with that?

    private String[] mainMenu = {"View all books",
                                 "Check library number",
                                 "Exit"};

    public NaiveMain() throws IOException {
        Display.println("Welcome to the Bangalore Public Library Biblioteca system.");





    }

    public void displayMainMenu() throws IOException {


        int choice = Display.getChoiceAnswer("Please select from the following options:", mainMenu);

        switch(choice) {
            case 0:
                displayBookMenu();
                break;
            case 1:
                displayLibraryNumberInfo();
                break;
            case 2:
                // Exit
                Display.println("Goodbye.");
                System.exit(0);
                break;
        }



    }


    public void displayBookMenu() throws IOException {
        String[] options = new String[books.length + 1];
        for(int i = 0; i < books.length; i++) {
            options[i] = books[i].toString();
        }
        options[books.length] = "Back";
        int choice = Display.getChoiceAnswer("Select a book to reserve, or return to the main menu:", mainMenu);
        if(choice == books.length) {
            displayMainMenu();
        } else {
            if(books[choice].isReserved()) {
                Display.println("Sorry we don't have that book yet");
                displayBookMenu();
            } else {
                Display.println("Thank You! Enjoy the book.");
                displayBookMenu();
            }
        }
    }

    public void displayLibraryNumberInfo() throws IOException {
        Display.println("Please talk to librarian");
        displayMainMenu();
    }

    public void showWelcomeMessage() {
        Display.println("Welcome to the Bangalore Public Library Biblioteca system.");
    }

    public static void main(String[] args) {

    }

}
