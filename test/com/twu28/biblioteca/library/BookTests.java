package com.twu28.biblioteca.library;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 24/07/12
 * Time: 10:00 PM
 */
public class BookTests {

    @Test
    public void shouldReturnDisplayString() {
        Book book = new Book("The Agile Samurai", "Jonathan Rasmusson");

        assertEquals("The Agile Samurai by Jonathan Rasmusson", book.toString());
    }

    @Test
    public void shouldSetAndGetReservedStatus() {
        Book book = new Book("The Agile Samurai", "Jonathan Rasmusson");

        book.setReserved(true);

        assertTrue(book.isItemReserved());
    }
}
