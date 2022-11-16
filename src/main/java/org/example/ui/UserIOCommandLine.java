package org.example.ui;

import org.example.dto.DVD;

import java.util.Scanner;

public class UserIOCommandLine {

    //Interact with console, take requests and output information

    private static final Scanner scanner = new Scanner(System.in);
    public UserIOCommandLine() {

    }

    public int greet() { //Provide first-instance UI to user
        System.out.println("Welcome to the DVD collection.");
        int choice = 0;
        while (choice == 0) {
            choice = optionMenu();
        }
        return choice;
    }

    public int reOption() { //Reoffer options list to user
        System.out.println("Returning to root menu.");
        int choice = 0;
        while (choice == 0) {
            choice = optionMenu();
        }
        return choice;
    }

    public DVD add() { //Talk user through adding a new DVD
        System.out.println("Please enter the title of the DVD.");
        String title = scanner.nextLine().replaceAll(",","*");
        System.out.println("Please enter the DVD's release date. (DD/MM/YYYY)");
        String releaseDate = scanner.nextLine().replaceAll(",","*");
        System.out.println("Please enter the MPAA rating of the DVD.");
        String ratingMPAA = scanner.nextLine().replaceAll(",","*");
        System.out.println("Please input the name of the DVD's director.");
        String director = scanner.nextLine().replaceAll(",","*");
        System.out.println("Please input the name of the production studio that produced the DVD.");
        String studio = scanner.nextLine().replaceAll(",","*");
        System.out.println("DVD successfully added to collection.");
        return new DVD(title, releaseDate, ratingMPAA, director, studio);
    }

    public void remove(String DVDname) { //Tell the user they did a good job removing the DVD
        System.out.println("Successfully removed " + DVDname + " from the collection.");
    }

    public DVD edit(DVD toBeEdited) { //Talk user through editing a DVD's entry
        return toBeEdited;
    }

    public void list(String[] collection) { //List all DVDs to user
        System.out.println("The DVDs currently in the collection are:");
        for (String s : collection) {
            System.out.println(s);
        }
    }

    public void display(String DVDstring) { // Display a single DVD
        System.out.println("");
    }

    public String searchRequest() { //Talk user through entering a DVD's name to search for
        System.out.println("Enter the name of the film you wish to search for");
        return scanner.nextLine().trim();
    }

    private int optionMenu () {
        System.out.println("Please choose from one of the following options:");
        System.out.println("1. [Add] a new DVD to the database");
        System.out.println("2. [Search] the database for an existing DVD");
        System.out.println("3. [List] all the DVDs currently in the collection");
        System.out.println("4. [Exit] the program");
        String response = scanner.nextLine();
        int responseInt = 0;
        if (response.equalsIgnoreCase("Add")) {
            responseInt = 1;
        } else if (response.equalsIgnoreCase("Search")) {
            responseInt = 2;
        } else if (response.equalsIgnoreCase("List")) {
            responseInt = 3;
        } else if (response.equalsIgnoreCase("Exit")) {
            responseInt = -1;
        }
        return responseInt;
    }

    public int editOptions() {
        boolean responded = false;
        while (!responded) {
            System.out.println("If you would like to [Edit] or [Remove] this entry, please input the relevant command.");
            System.out.println("Or, if you would like to [Return] to the previous menu, input that instead.");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("Edit")) {
                return 1;
            } else if (response.equalsIgnoreCase("Remove")) {
                return 2;
            } else if (response.equalsIgnoreCase("Return")) {
                return 0;
            }
        }
        return -1;
    }

    public String[] edit(String[] dvdData) {
        return dvdData;
    }

    public void savingError() {
        System.out.println("There was an error while communicating with the database.");
        System.out.println("Changes made during this session have not been saved.");
    }

    public void stop() { //Say goodbye to user, close up.

    }
}
