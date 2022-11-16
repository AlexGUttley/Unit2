package org.example.controller;

import org.example.dao.FileIO;
import org.example.dto.DVD;
import org.example.ui.UserIOCommandLine;

import java.util.ArrayList;

public class DVDController {

    FileIO databaseManager;
    ArrayList<DVD> DVDs;
    UserIOCommandLine ui;

    //main controller, handles the program's logic
    public DVDController() {
        databaseManager = new FileIO();
        DVDs = databaseManager.getListFromFile();
        ui = new UserIOCommandLine();
    }
    public void start() {

        for (DVD d : DVDs) {
            System.out.println(d.toString());
        }
        int choice = ui.greet();
        int loopFailsafe = 10000;

        while (choice != -1 && loopFailsafe > 0) { //User chose to add a DVD to collection

            if (choice == 1){
                DVDs.add(ui.add());
            } else if (choice == 2){ //User chose to search for a DVD in collection
                DVD searchResult = this.search(ui.searchRequest());
                int edit = 0;
                if (searchResult != null) {
                    ui.display(searchResult.toString());
                    edit = ui.editOptions();
                    editOptions(edit, searchResult);
                }
            } else if (choice == 3){ //User chose to list available DVDs
                String[] dvdStringsVerbose = new String[DVDs.size()]; //Disposable, refactor to array
                int i = 0;
                for (DVD d : DVDs) {
                    dvdStringsVerbose[++i] = d.toString();
                }
                ui.list(dvdStringsVerbose);
            }

            choice = ui.reOption();
            loopFailsafe--;
        }
        terminate();
    }

    private DVD search(String searchTerm) {
        for (DVD d : DVDs) {
            if (d.getTitle().contains(searchTerm)) {
                return d;
            }
        }
        return null;
    }

    private void editOptions(int option, DVD current) {
        //pick between the options. 1 = edit, 2 = remove, 0 = cancel
        if (option == 1) {
            String[] params = ui.edit(current.toStringArray());
            DVD edited;
            if (params.length == 5) {
                edited = new DVD(params[0], params[1], params[2], params[3], params[4]);
            } else {
                edited = new DVD(params[0], params[1], params[2], params[3], params[4], params[5]);
            }
            DVDs.set(DVDs.indexOf(current), edited);
        } else if (option == 2) {
            DVDs.remove(current);
            ui.remove(current.getTitle());
        }
    }

    private void terminate(){
        ui.stop();
        if(!databaseManager.writeListToFile(DVDs)) {
            ui.savingError();
        }
        //databaseManager.writeListToFile(DVDs);
    }
}
