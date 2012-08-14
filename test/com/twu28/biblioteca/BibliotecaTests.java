package com.twu28.biblioteca;

import com.twu28.biblioteca.presentation.Biblioteca;
import com.twu28.biblioteca.presentation.TestSpecificInputStream;
import com.twu28.biblioteca.presentation.TestSpecificOutputStream;
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
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        Biblioteca biblioteca = new Biblioteca(in, out);

        biblioteca.displayWelcomeMessage();

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Welcome to the Bangalore Library Biblioteca System!");

        assertEquals(expectedOutput, out.getOutput());
    }

}
