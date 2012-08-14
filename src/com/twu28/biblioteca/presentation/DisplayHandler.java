package com.twu28.biblioteca.presentation;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 24/07/12
 * Time: 7:59 PM
 */
public class DisplayHandler {

    private CustomInputStream in;
    private CustomOutputStream out;

    public DisplayHandler(CustomInputStream in, CustomOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public void displayMessage(String message) {
        out.println(message);
    }

    public void displayConfirmationMessage(String message) {
        displayMessage(message);
        try {
            in.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public boolean displayYesNoMessage(String question) {
        displayMessage(question + " (y/n)");
        return getValidYesNoInput();
    }

    public String displayInputMessage(String question) {
        displayMessage(question);
        String input = null;
        try {
            input = in.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public void displayList(String heading, Object[] items) {

        out.println(heading);
        for(Object o : items) {
            out.println(o.toString());
        }

        try {
            in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Object displayMenu(String question, Object[] options) {
        while (true) {
            out.println(question);
            for (int i = 0; i < options.length; i++) {
                out.println("[" + (i + 1) + "] " + options[i].toString());
            }
            return options[getValidIntInput(1, options.length) - 1];
        }
    }

    public boolean getValidYesNoInput() {
        while (true) {
            try {
                String inputString = in.readLine();
                if(inputString == null) {
                    continue;
                }
                if(inputString.equalsIgnoreCase("y")) {
                    return true;
                } else if(inputString.equalsIgnoreCase("n")) {
                    return false;
                } else {
                    out.println("Select a valid option!!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int getValidIntInput(int lower, int upper) {
        while (true) {
            try {
                String inputString = in.readLine();
                if(inputString == null) {
                    continue;
                }
                try {
                    int inputInt = Integer.parseInt(inputString);
                    if (inputInt >= lower && inputInt <= upper) {
                        return inputInt;
                    } else {
                        out.println("Select a valid option!!");
                        //awaitUserConfirmation();
                    }
                } catch (NumberFormatException e) {
                    // not a valid integer
                    out.println("Select a valid option!!");
                    //awaitUserConfirmation();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
/*
    public void awaitUserConfirmation() {
        try {
            in.readLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }*/


}
