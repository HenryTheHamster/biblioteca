package com.twu28.biblioteca.persistence;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 24/07/12
 * Time: 8:33 PM
 */
public abstract class LibraryItem {

    private boolean isReserved = false;

    public boolean isItemReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public abstract String toString();

}
