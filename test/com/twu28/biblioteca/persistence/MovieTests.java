package com.twu28.biblioteca.persistence;

import com.twu28.biblioteca.persistence.Movie;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 24/07/12
 * Time: 10:01 PM
 */
public class MovieTests {

    @Test
    public void shouldReturnDisplayString() {
        Movie movie = new Movie("Lock, Stock and Two Smoking Barrels", "Guy Ritchie", 9);

        assertEquals("Lock, Stock and Two Smoking Barrels, directed by Guy Ritchie (9/10)", movie.toString());
    }

    @Test
    public void shouldSetAndGetReservedStatus() {
        Movie movie = new Movie("Lock, Stock and Two Smoking Barrels", "Guy Ritchie", 9);

        movie.setReserved(true);

        assertTrue(movie.isItemReserved());
    }
}
