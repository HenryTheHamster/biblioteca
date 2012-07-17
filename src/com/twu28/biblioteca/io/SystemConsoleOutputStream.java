package com.twu28.biblioteca.io;

import com.twu28.biblioteca.CustomOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 17/07/12
 * Time: 5:05 PM
 */
public class SystemConsoleOutputStream implements CustomOutputStream {

    @Override
    public void println(String message) {
        System.out.println(message);
    }

}
