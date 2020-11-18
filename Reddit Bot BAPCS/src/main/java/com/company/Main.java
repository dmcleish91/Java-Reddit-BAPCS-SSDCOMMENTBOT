package com.company;

import Application.RedditInterface;

/**
 * The HelloWorld program implements an application that
 * simply displays "Hello World!" to the standard output.
 *
 * @author  Dwight McLeish Jr
 * @version 0.1
 * @since   2020-11-10
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        RedditInterface RedditInterface = new RedditInterface();
        RedditInterface.start();
    }
}
