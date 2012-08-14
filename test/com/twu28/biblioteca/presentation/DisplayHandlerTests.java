package com.twu28.biblioteca.presentation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 24/07/12
 * Time: 10:02 PM
 */
public class DisplayHandlerTests {

    @Test
    public void shouldDisplayMessage() {

        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);

        display.displayMessage("This is a message.");

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("This is a message.");

        assertEquals(expectedOutput, out.getOutput());

    }

    @Test
    public void shouldDisplayConfirmationMessage() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);

        display.displayConfirmationMessage("This is a confirmation message.");

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("This is a confirmation message.");

        assertEquals(expectedOutput, out.getOutput());
    }

    @Test
    public void shouldDisplayYesNoMessage() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);

        in.addInput("y");

        display.displayYesNoMessage("This is a yes/no message.");

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("This is a yes/no message. (y/n)");

        assertEquals(expectedOutput, out.getOutput());
    }

    @Test
    public void shouldDisplayInputMessage() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);

        display.displayInputMessage("This is an input message.");

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("This is an input message.");

        assertEquals(expectedOutput, out.getOutput());
    }

    @Test
    public void shouldDisplayList() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);

        display.displayList("This is a list:", new Object[] {"Item 1", "Item 2"});

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("This is a list:");
        expectedOutput.add("Item 1");
        expectedOutput.add("Item 2");

        assertEquals(expectedOutput, out.getOutput());
    }

    @Test
    public void shouldDisplayMenu() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);

        in.addInput("1");

        display.displayMenu("This is a menu:", new Object[] {"Item 1, Item 2"});

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("This is a menu:");
        expectedOutput.add("[1] Item 1");
        expectedOutput.add("[2] Item 2");
    }

    @Test
    public void shouldGetValidYesNoInput() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);

        in.addInput("y");

        boolean result = display.getValidYesNoInput();

        assertTrue(result);
    }

    @Test
    public void shouldWarnOfInvalidYesNoInput() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);

        in.addInput("x");
        in.addInput("y");

        display.getValidYesNoInput();

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Select a valid option!!");

        assertEquals(expectedOutput, out.getOutput());
    }

    @Test
    public void shouldGetValidIntInput() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);

        in.addInput("3");

        int result = display.getValidIntInput(2, 6);

        assertEquals(3, result);
    }

    @Test
    public void shouldWarnOfInvalidIntInput() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);

        in.addInput("10");
        in.addInput("3");

        display.getValidIntInput(2, 6);

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Select a valid option!!");

        assertEquals(expectedOutput, out.getOutput());
    }

}
