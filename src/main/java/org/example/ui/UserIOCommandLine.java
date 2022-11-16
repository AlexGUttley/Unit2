package org.example.ui;

import org.example.dto.DVD;

import java.util.Scanner;

/**
 * Provides console-based interaction between user and DVD collection program.
 */
public class UserIOCommandLine implements UserIO {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Constructor; no core functionality.
     */
    public UserIOCommandLine() {

    }

    /**
     * Run on startup, provide the user with a list of options, and return an integer pertaining to the option chosen.
     * @return 1 = Add item, 2 = Search database, 3 = List all entries, -1 = quit.
     */
    public int greet() { //Provide first-instance UI to user
        System.out.println("Welcome to the DVD collection.");
        int choice = 0;
        while (choice == 0) {
            choice = optionMenu();
        }
        return choice;
    }

    /**
     * Provides similar functionality to greet, but is run after an operation has been completed, rather than on startup.
     * Must still provide the user with a list of options and return an integer.
     * @return 1 = Add item, 2 = Search database, 3 = List all entries, -1 = quit.
     */
    public int reOption() { //Offer options list to user again
        System.out.println("Returning to root menu.");
        System.out.println();
        int choice = 0;
        while (choice == 0) {
            choice = optionMenu();
        }
        return choice;
    }

    /**
     * Creates a DVD object based on input from the user, to be added to the collection.
     * @return A new DVD object based on input.
     */
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
        while(true){ //Loops until user selects whether or not they would like to add a comment.
            System.out.println("Would you like to add a comment? [Yes], [No]");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("Yes")){
                System.out.println("Please enter the comment you would like to add.");
                String comment = scanner.nextLine().replaceAll(",","*");
                System.out.println("DVD successfully added to collection.");
                return new DVD(title, releaseDate, ratingMPAA, director, studio, comment);
            } else if (response.equalsIgnoreCase("No")) {
                System.out.println("DVD successfully added to collection.");
                return new DVD(title, releaseDate, ratingMPAA, director, studio);
            }
            System.out.println("Input not recognised.");
        }
    }

    /**
     * Informs the user that a DVD has been deleted corresponding to the DVDName parameter provided.
     * This method does not need to gather or provide any information, as the DVD has already been deleted.
     * @param DVDname The name of the DVD that has been removed.
     */
    public void remove(String DVDname) { //Tell the user they did a good job removing the DVD
        System.out.println("Successfully removed " + DVDname + " from the collection.");
    }

    /**
     * Provide the user with information on all DVDs in the collection, as provided in String format
     * @param collection String array where each element corresponds to a single DVD in the collection
     */
    public void list(String[] collection) { //List all DVDs to user
        System.out.println("The DVDs currently in the collection are:");
        for (String s : collection) {
            System.out.println(s);
        }
        System.out.println();
    }

    /**
     * Display information on a single DVD, using the provided information.
     * @param DVDstring The information pertaining to the DVD, provided as a verbose string.
     */
    public void display(String DVDstring) { // Display a single DVD
        System.out.println(DVDstring);
    }

    /**
     * Queries the user for a search term that can be used to search for a particular DVD via the DVD's title.
     * @return The search term provided by the user.
     */
    public String searchRequest() { //Talk user through entering a DVD's name to search for
        System.out.println("Enter the name of the film you wish to search for");
        return scanner.nextLine().trim();
    }

    private int optionMenu () { //Generates an option menu for user. Used by greet and reOption.
        System.out.println("Please choose from one of the following options:");
        System.out.println("1. [Add] a new DVD to the database");
        System.out.println("2. [Search] the database for an existing DVD");
        System.out.println("3. [List] all the DVDs currently in the collection");
        System.out.println("4. [Exit] the program");
        String response = scanner.nextLine();
        int responseInt = 0;
        if (response.equalsIgnoreCase("Add") || response.equalsIgnoreCase("1")) {
            responseInt = 1;
        } else if (response.equalsIgnoreCase("Search") || response.equalsIgnoreCase("2")) {
            responseInt = 2;
        } else if (response.equalsIgnoreCase("List") || response.equalsIgnoreCase("3")) {
            responseInt = 3;
        } else if (response.equalsIgnoreCase("Exit") || response.equalsIgnoreCase("4")) {
            responseInt = -1;
        }
        return responseInt;
    }

    /**
     * Provide options to the user based on editing a DVD within the array, and return an integer reflecting the choice.
     * @return 1 = edit item, 2 = remove item, -1 = return to root menu.
     */
    public int editOptions() {
        while (true) {
            System.out.println("If you would like to [Edit] or [Remove] this entry, please input the relevant command.");
            System.out.println("Or, if you would like to [Return] to the previous menu, input that instead.");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("Edit")) {
                return 1;
            } else if (response.equalsIgnoreCase("Remove")) {
                return 2;
            } else if (response.equalsIgnoreCase("Return")) {
                return -1;
            }
        }
    }

    /**
     * Given an array containing information for a DVD, returns an edited version of that information.
     * Should retrieve any changes from the user, and implement them to the return string array.
     * @param dvdData The supplied data as it exists from the collection.
     * @return The edited data with the user's changes applied.
     */
    public String[] edit(String[] dvdData) {
        return dvdData;
    }

    /**
     *  Report that there has been an error while saving the document, and all changes made during this session will not be committed.
     */
    public void savingError() {
        System.out.println("There was an error while communicating with the database.");
        System.out.println("Changes made during this session have not been saved.");
    }

    /**
     * Ends all user interface elements, and says goodbye to the user.
     */
    public void stop() { //Say goodbye to user, close up.
        System.out.println("The program will now close. Goodbye!");
    }
}
