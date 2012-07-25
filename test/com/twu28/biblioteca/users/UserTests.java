package com.twu28.biblioteca.users;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 24/07/12
 * Time: 10:00 PM
 */
public class UserTests {

    @Test
    public void shouldReturnLibraryNumber() {
        User user = new User("111-1111", "librarian");

        assertEquals("111-1111", user.getLibraryNumber());
    }

    @Test
    public void shouldReturnPassword() {
        User user = new User("111-1111", "librarian");

        assertEquals("librarian", user.getPassword());
    }
}
