package com.twu28.biblioteca;

import com.twu28.biblioteca.presentation.Biblioteca;
import com.twu28.biblioteca.presentation.CustomInputStream;
import com.twu28.biblioteca.presentation.CustomOutputStream;
import com.twu28.biblioteca.presentation.SystemConsoleInputStream;
import com.twu28.biblioteca.presentation.SystemConsoleOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 17/07/12
 * Time: 5:02 PM
 */
public class BibliotecaApplication {



    public static void main(String[] args) {

        CustomInputStream consoleInput = new SystemConsoleInputStream();
        CustomOutputStream consoleOutput = new SystemConsoleOutputStream();

        Biblioteca biblioteca = new Biblioteca(consoleInput, consoleOutput);
        biblioteca.displayWelcomeMessage();
        biblioteca.displayMainMenu();

    }
}
