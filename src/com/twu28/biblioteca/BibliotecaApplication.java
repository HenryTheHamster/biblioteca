package com.twu28.biblioteca;

import com.twu28.biblioteca.io.SystemConsoleOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 17/07/12
 * Time: 5:02 PM
 */
public class BibliotecaApplication {

    public static void main(String[] args) {
        CustomOutputStream consoleOutput = new SystemConsoleOutputStream();
        Biblioteca biblioteca = new Biblioteca(consoleOutput);
        biblioteca.displayWelcomeMessage();
    }
}
