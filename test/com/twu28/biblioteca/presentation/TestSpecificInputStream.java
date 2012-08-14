package com.twu28.biblioteca.presentation;

import com.twu28.biblioteca.presentation.CustomInputStream;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 17/07/12
 * Time: 6:44 PM
 */
public class TestSpecificInputStream implements CustomInputStream {

    private Queue<String> inputQueue = new LinkedList<String>();

    public void addInput(String input) {
        inputQueue.add(input);
    }

    @Override
    public String readLine() {
        return inputQueue.poll();
    }
}
