package com.twu28.biblioteca.presentation;

import com.twu28.biblioteca.presentation.CustomOutputStream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 17/07/12
 * Time: 4:31 PM
 */
public class TestSpecificOutputStream implements CustomOutputStream {

    private List<String> output = new ArrayList<String>();

    public List<String> getOutput() {
        return output;
    }

    @Override
    public void println(String message) {
        output.add(message);
    }


}
