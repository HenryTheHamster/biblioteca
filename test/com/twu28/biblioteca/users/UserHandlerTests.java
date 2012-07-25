package com.twu28.biblioteca.users;

import com.twu28.biblioteca.io.DisplayHandler;
import com.twu28.biblioteca.io.TestSpecificInputStream;
import com.twu28.biblioteca.io.TestSpecificOutputStream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 24/07/12
 * Time: 10:01 PM
 */
public class UserHandlerTests {

    @Test
    public void shouldLoginUser() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);

        User user = new User("111-1111", "librarian");
        User[] users = {user};

        UserHandler handler = new UserHandler(display, users);

        in.addInput("111-1111");
        in.addInput("librarian");

        handler.loginUser();

        assertEquals(user, handler.getCurrentUser());
    }

    @Test
    public void shouldLogoutUser() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);

        User user = new User("111-1111", "librarian");
        User[] users = {user};

        UserHandler handler = new UserHandler(display, users);

        in.addInput("111-1111");
        in.addInput("librarian");
        in.addInput("y");

        handler.loginUser();

        handler.logoutUser();

        assertNull(handler.getCurrentUser());
    }

    @Test
    public void shouldWarnOfIncorrectLibraryNumber() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);

        User user = new User("111-1111", "librarian");
        User[] users = {user};

        UserHandler handler = new UserHandler(display, users);

        in.addInput("000-1111");

        handler.loginUser();

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Please enter your library number:");
        expectedOutput.add("There is no user with that library number registered.");

        assertEquals(expectedOutput, out.getOutput());
    }

    @Test
    public void shouldWarnOfIncorrectPassword() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);

        User user = new User("111-1111", "librarian");
        User[] users = {user};

        UserHandler handler = new UserHandler(display, users);

        in.addInput("111-1111");
        in.addInput("badpassword");
        handler.loginUser();

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Please enter your library number:");
        expectedOutput.add("Please enter your password:");
        expectedOutput.add("That password is incorrect.");

        assertEquals(expectedOutput, out.getOutput());
    }

    @Test
    public void shouldDisplayLoggedInLibraryNumberMessage() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);

        User user = new User("111-1111", "librarian");
        User[] users = {user};

        UserHandler handler = new UserHandler(display, users);

        in.addInput("111-1111");
        in.addInput("librarian");

        handler.loginUser();

        handler.displayLibraryNumberMessage();

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Please enter your library number:");
        expectedOutput.add("Please enter your password:");
        expectedOutput.add("Your library number is 111-1111");

        assertEquals(expectedOutput, out.getOutput());
    }

    @Test
    public void shouldDisplayLoggedOutLibraryNumberMessage() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);

        User user = new User("111-1111", "librarian");
        User[] users = {user};

        UserHandler handler = new UserHandler(display, users);

        handler.displayLibraryNumberMessage();

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Please talk to librarian. Thank you.");

        assertEquals(expectedOutput, out.getOutput());
    }
}
