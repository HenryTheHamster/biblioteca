package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 17/07/12
 * Time: 1:58 PM
 */
public class InputControllerTests {

    @Test
    public void returnsInputForValidInt()  {

        InputController input = new InputController(new Scanner("2"));
        Integer result = input.getIntInput();
        Assert.assertEquals(new Integer(2), result);

    }

    public void returnNullForInvalidOption() {

    }

    public void returnNullForInvalidInt() {

    }




}
