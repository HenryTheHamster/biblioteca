package com.twu28.biblioteca;

import java.io.IOException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 14/07/12
 * Time: 9:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Display {

    private Scanner in;
    private PrintStream out;

    public Display(Scanner in, PrintStream out) {
        this.in = in;
        this.out = out;
    }

    // return a valid integer choice from a list of numbered options
    public int getChoiceAnswer(String question, String[] options) throws IOException {
        println(question);
        for(int i = 0; i < options.length; i++) {
            println("[" + i + "] " + options[i]);
        }
        while(true) {
            println("Selection: ");
            try {
                int choice = in.nextInt();
                if(choice >= 0 && choice < options.length) {
                    return choice;
                } else {
                    println("Select a valid option!!");
                }
            } catch(InputMismatchException e) {
                println("Select a valid option!!");
            }

        }
    }
/*
    // return a valid integer response to a question
    public int getIntAnswer(String question) throws IOException{
        while(true) {
            String answerAsString = getStringAnswer(question);
            try {
                return Integer.parseInt(answerAsString);
            } catch(NumberFormatException e) {
                // invalid integer - try again
            }
        }
    }
/*
    // return any string response to a question
    public String getStringAnswer(String question) throws IOException {
        print(question + " ");
        return readLine();
    }
/*
    // read a line of user input
    private String readLine() throws IOException {
        //BufferedReader br  = new BufferedReader(new InputStreamReader(in));
        //return br.readLine();
    }
*/
    // print to the console with a trailing newline
    public void println(String value) {
        out.println(value);
        out.flush();
    }


    // print to the console without adding a newline
    public void print(String value) {
        out.print(value);
        out.flush();
    }
}
