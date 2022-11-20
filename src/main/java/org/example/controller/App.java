package org.example.controller;

/**
 * Runs an instance of DVDController according to intended function when 'main' method is called.
 * No core functionality other than to act as an entry point into the appication.
 */
public class App {

    /**
     * Entry point into the application.
     * @param args Unused.
     */
    public static void main(String[] args) {
        DVDController controller = new DVDController();
        controller.start();
    }

}
