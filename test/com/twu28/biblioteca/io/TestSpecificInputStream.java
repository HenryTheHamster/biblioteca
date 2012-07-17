package com.twu28.biblioteca.io;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 17/07/12
 * Time: 6:44 PM
 */
public class TestSpecificInputStream implements CustomInputStream {

    private String inputValue = "";

    public void setInput(String input) {
        inputValue = input;
    }

    @Override
    public String readLine() {
        return inputValue;
    }
}
