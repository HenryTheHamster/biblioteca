package com.twu28.biblioteca.library;

import com.twu28.biblioteca.io.DisplayHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 24/07/12
 * Time: 8:30 PM
 */
public class LibraryHandler {
    private DisplayHandler display;
    private List<LibraryItem> items;

    public LibraryHandler(DisplayHandler display) {
        this.display = display;
        items = new ArrayList<LibraryItem>();
    }

    public LibraryHandler(DisplayHandler display, LibraryItem[] items) {
        this(display);
        for(LibraryItem i : items) {
            addItem(i);
        }
    }

    public void addItem(LibraryItem item) {
        // assumes we can only have one copy of any item
        // if later we need to deal with multiple copies, support can be easily added here and in the item class
        if(!items.contains(item)) {
            items.add(item);
        }

    }

    public void displayItemList() {
        display.displayList("The library currently has the following items:", items.toArray());
    }

    public void displayReserveMenu() {
        LibraryItem selectedItem = (LibraryItem)display.displayMenu("Select the item you would like to reserve:", items.toArray());
        if(selectedItem.isItemReserved()) {
            display.displayConfirmationMessage("Sorry we don't have that book yet.");
        } else {
            display.displayConfirmationMessage("Thank You! Enjoy the book.");
            selectedItem.setReserved(true);
        }
    }
}
