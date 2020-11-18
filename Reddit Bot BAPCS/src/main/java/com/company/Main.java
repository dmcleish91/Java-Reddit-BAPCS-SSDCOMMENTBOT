package com.company;

import Application.RedditInterface;

/**
 * This software application runs a script that parces a publicly maintained
 * csv file of ssd information and post that information in a formatted mannar
 * on the subreddit Buildapcsales
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
