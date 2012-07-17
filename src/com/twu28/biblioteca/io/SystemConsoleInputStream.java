package com.twu28.biblioteca.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 17/07/12
 * Time: 8:13 PM
 */
public class SystemConsoleInputStream implements CustomInputStream {
    @Override
    public String readLine() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
