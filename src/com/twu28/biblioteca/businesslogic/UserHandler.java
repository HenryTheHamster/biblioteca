package com.twu28.biblioteca.businesslogic;

import com.twu28.biblioteca.persistence.User;
import com.twu28.biblioteca.presentation.DisplayHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 24/07/12
 * Time: 7:35 PM
 */
public class UserHandler {

    private Map<String, User> users = new HashMap<String, User>();
    private DisplayHandler display;
    private User currentUser = null;

    public UserHandler(DisplayHandler display) {
        this.display = display;
    }

    public UserHandler(DisplayHandler display, User[] users) {
        this(display);
        for(User u : users) {
            this.users.put(u.getLibraryNumber(), u);
        }
    }

    public boolean hasUserLoggedIn() {
        return currentUser != null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void loginUser() {
        String libraryNumber = display.displayInputMessage("Please enter your library number:");
        if(!users.containsKey(libraryNumber)) {
            display.displayConfirmationMessage("There is no user with that library number registered.");
            return;
        }
        String password = display.displayInputMessage("Please enter your password:");
        if(!users.get(libraryNumber).getPassword().equals(password)) {
            display.displayConfirmationMessage("That password is incorrect.");
            return;
        }
        currentUser = users.get(libraryNumber);
    }



    public void logoutUser() {
        if(display.displayYesNoMessage("This will logout the current user. Do you wish to continue?")) {
            currentUser = null;
        }
    }

    public void displayLibraryNumberMessage() {
        if(hasUserLoggedIn()) {
            display.displayConfirmationMessage("Your library number is " + currentUser.getLibraryNumber());
        } else {
            display.displayConfirmationMessage("Please talk to librarian. Thank you.");
        }
    }

}
