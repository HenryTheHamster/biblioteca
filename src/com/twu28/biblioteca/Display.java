package com.twu28.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 14/07/12
 * Time: 9:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Display {

    // currently doesn't really allow for testing
    // should this be public and passed an InputStream (and an OutputStream/PrintStream)?
    private Display() {
    }

    // return a valid integer choice from a list of numbered options
    public static int getChoiceAnswer(String question, String[] options) throws IOException {

        while(true) {
            println(question);
            for(int i = 0; i < options.length; i++) {
                println("[" + i + "] " + options[i]);
            }
            int choice = getIntAnswer("Selection: ");
            if(choice >= 0 && choice < options.length) {
                return choice;
            }
        }
    }

    // return a valid integer response to a question
    public static int getIntAnswer(String question) throws IOException{
        while(true) {
            String answerAsString = getStringAnswer(question);
            try {
                return Integer.parseInt(answerAsString);
            } catch(NumberFormatException e) {
                // invalid integer - try again
            }
        }
    }

    // return any string response to a question
    public static String getStringAnswer(String question) throws IOException {
        print(question + " ");
        return readLine();
    }

    // read a line of user input
    private static String readLine() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    // print to the console with a trailing newline
    public static void println(String value) {
        System.out.println(value);
        System.out.flush();
    }


    // print to the console without adding a newline
    public static void print(String value) {
        System.out.print(value);
        System.out.flush();
    }
}
