package org.example.controller;

import org.example.dao.DataIO;
import org.example.dao.FileIO;
import org.example.dto.DVD;
import org.example.ui.UserIO;
import org.example.ui.UserIOCommandLine;

import java.util.ArrayList;

/**
 * Main controller for the DVD collection interface program.
 * Handles communication between file I/O, user interface, and data.
 */
public class DVDController {

    DataIO databaseManager;
    ArrayList<DVD> DVDs;
    UserIO ui;

    /**
     * Instantiates the working database, as well as the UI and database management classes.
     */
    public DVDController() {
        databaseManager = new FileIO();
        DVDs = databaseManager.readList();
        ui = new UserIOCommandLine();
    }

    /**
     * The main control loop for the program.
     * Interfaces with the UI and file I/O, and performs all necessary logic to ensure correct program operation.
     */
    public void start() {

        int choice = ui.greet();

        while (choice != -1) { //User chose to add a DVD to collection

            if (choice == 1){
                DVDs.add(ui.add());
            } else if (choice == 2){ //User chose to search for a DVD in collection
                DVD searchResult = this.search(ui.searchRequest());
                int edit;
                if (searchResult != null) {
                    ui.display(searchResult.toString());
                    edit = ui.editOptions();
                    editOptions(edit, searchResult);
                } else {
                    ui.searchFail();
                }
            } else if (choice == 3){ //User chose to list available DVDs
                String[] dvdStringsVerbose = new String[DVDs.size()];
                int i = 0;
                for (DVD d : DVDs) {
                    dvdStringsVerbose[i++] = d.toString();
                }
                ui.list(dvdStringsVerbose);
            }

            choice = ui.reOption();
        }
        terminate();
    }

    /**
     * Given a specific search term, iterate through the titles of each DVD in memory, and return the first one that contains it.
     * @param searchTerm A string representing the search term
     * @return the DVD object returned by the search process, or null if no matching DVD is found.
     */
    private DVD search(String searchTerm) {
        for (DVD d : DVDs) {
            if (d.getTitle().toLowerCase().contains(searchTerm)) {
                return d;
            }
        }
        return null;
    }

    /**
     * Interfaces with the UI to modify the data of a particular DVD in the collection.
     * @param option An integer representing the option that has been selected. 1 = edit, 2 = remove, -1 = cancel
     * @param current The DVD upon which the modifying operations are to take place.
     */
    private void editOptions(int option, DVD current) {
        if (option == 1) {
            String[] params = ui.edit(current.toStringArray());
            DVD edited;
            if (params.length == 5) { //Generates a DVD with or without a note, based on if it was supplied or not.
                edited = new DVD(params[0], params[1], params[2], params[3], params[4]);
            } else {
                edited = new DVD(params[0], params[1], params[2], params[3], params[4], params[5]);
            }
            DVDs.set(DVDs.indexOf(current), edited);
        } else if (option == 2) {
            //Remove the DVD from the array
            DVDs.remove(current);
            ui.remove(current.getTitle());
        }
    }

    /**
     * Writes the contents of the DVD arraylist stored in memory to file, and ends the program.
     */
    private void terminate(){
        if(!databaseManager.writeList(DVDs)) {
            ui.savingError();
        }
        ui.stop();
    }
}
