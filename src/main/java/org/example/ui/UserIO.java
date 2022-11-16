package org.example.ui;

import org.example.dto.DVD;

/**
 * A generic interface used to ensure correct user interface functionality when used with the DVDController class.
 *
 */
public interface UserIO {

    /**
     * Run on startup, provide the user with a list of options, and return an integer pertaining to the option chosen.
     * @return 1 = Add item, 2 = Search database, 3 = List all entries, -1 = quit.
     */
    int greet();

    /**
     * Provides similar functionality to greet, but is run after an operation has been completed, rather than on startup.
     * Must still provide the user with a list of options and return an integer.
     * @return 1 = Add item, 2 = Search database, 3 = List all entries, -1 = quit.
     */
    int reOption();

    /**
     * Creates a DVD object based on input from the user, to be added to the collection.
     * @return A new DVD object based on input.
     */
    DVD add();

    /**
     * Informs the user that a DVD has been deleted corresponding to the DVDName parameter provided.
     * This method does not need to gather or provide any information, as the DVD has already been deleted.
     * @param DVDName The name of the DVD that has been removed.
     */
    void remove(String DVDName);

    /**
     * Provide the user with information on all DVDs in the collection, as provided in String format
     * @param collection String array where each element corresponds to a single DVD in the collection
     */
    void list(String[] collection);

    /**
     * Display information on a single DVD, using the provided information.
     * @param dvdString The information pertaining to the DVD, provided as a verbose string.
     */
    void display(String dvdString);

    /**
     * Queries the user for a search term that can be used to search for a particular DVD via the DVD's title.
     * @return The search term provided by the user.
     */
    String searchRequest();

    /**
     * Provide options to the user based on editing a DVD within the array, and return an integer reflecting the choice.
     * @return 1 = edit item, 2 = remove item, -1 = return to root menu.
     */
    int editOptions();

    /**
     * Given an array containing information for a DVD, returns an edited version of that information.
     * Should retrieve any changes from the user, and implement them to the return string array.
     * @param DVDData The supplied data as it exists from the collection.
     * @return The edited data with the user's changes applied.
     */
    String[] edit(String[] DVDData);

    /**
     *  Report that there has been an error while saving the document, and all changes made during this session will not be committed.
     */
    void savingError();

    /**
     * Ends all user interface elements, and says goodbye to the user.
     */
    void stop();

}