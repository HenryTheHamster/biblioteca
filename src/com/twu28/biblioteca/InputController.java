package com.twu28.biblioteca;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 17/07/12
 * Time: 1:58 PM
 */
public class InputController {

    private Scanner scanner;

    public InputController(Scanner scanner) {
        this.scanner = scanner;
    }

    public Integer getIntInput() {
        if(scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            return null;
        }
    }

    public Integer getIntInput(int lower, int upper) {
        Integer input = getIntInput();
        if(input == null || input < lower || input > upper) {
            return null;
        } else {
            return input;
        }
    }

}
