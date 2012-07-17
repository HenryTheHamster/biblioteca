package com.twu28.biblioteca;

import com.twu28.biblioteca.io.TestSpecificInputStream;
import com.twu28.biblioteca.io.TestSpecificOutputStream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

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

        biblioteca.displayMainMenu();

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Please select from the following options:");
        expectedOutput.add("[1] List all books");
        expectedOutput.add("[2] Reserve a book");
        expectedOutput.add("[3] Check library number");
        expectedOutput.add("[4] Exit");

        assertEquals(expectedOutput, out.getOutput());
    }


}
