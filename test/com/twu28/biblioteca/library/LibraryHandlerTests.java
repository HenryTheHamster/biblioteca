package com.twu28.biblioteca.library;

import com.twu28.biblioteca.io.DisplayHandler;
import com.twu28.biblioteca.io.TestSpecificInputStream;
import com.twu28.biblioteca.io.TestSpecificOutputStream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 24/07/12
 * Time: 10:01 PM
 */
public class LibraryHandlerTests {

    @Test
    public void shouldDisplayItemList() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);
        LibraryHandler library = new LibraryHandler(display);

        library.addItem(new Book("The Agile Samurai", "Jonathon Rasmusson"));
        library.addItem(new Book("Head First Java", "Kathy Sierra and Bert Bates"));

        library.displayItemList();

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("The library currently has the following items:");
        expectedOutput.add("The Agile Samurai by Jonathon Rasmusson");
        expectedOutput.add("Head First Java by Kathy Sierra and Bert Bates");

        assertEquals(expectedOutput, out.getOutput());
    }

    @Test
    public void shouldDisplayReserveMenu() {
        TestSpecificInputStream in = new TestSpecificInputStream();
        TestSpecificOutputStream out = new TestSpecificOutputStream();
        DisplayHandler display = new DisplayHandler(in, out);
        LibraryHandler library = new LibraryHandler(display);

        library.addItem(new Book("The Agile Samurai", "Jonathon Rasmusson"));
        library.addItem(new Book("Head First Java", "Kathy Sierra and Bert Bates"));

        in.addInput("1");

        library.displayReserveMenu();

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Select the item you would like to reserve:");
        expectedOutput.add("[1] The Agile Samurai by Jonathon Rasmusson");
        expectedOutput.add("[2] Head First Java by Kathy Sierra and Bert Bates");
        expectedOutput.add("Thank You! Enjoy the book.");
        assertEquals(expectedOutput, out.getOutput());
    }
}
