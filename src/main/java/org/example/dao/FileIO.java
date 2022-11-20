package org.example.dao;

import org.example.dto.DVD;

import java.io.*;
import java.util.ArrayList;

/**
 * Designed for use with DVDController, reads a .csv file into an arraylist and writes back when complete.
 * An implementation of DataIO designed for a simple .csv file storage.
 */
public class FileIO implements DataIO {

    private static final String FILE_NAME = "DVDCollection.csv";

    /**
     * Constructor; no core functionality.
     */
    public FileIO() {
    }

    /**
     * Reads the stored data representing the collection, and returns an ArrayList&lt;DVD&gt; containing all entries.
     * Also perform relevant data marshalling operations to reverse steps taken to comply with the .csv format.
     * @return The ArrayList of DVDs that represents the data in storage.
     */
    @Override
    public ArrayList<DVD> readList() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            reader.readLine();//reads twice to ensure the first line (categories) is not used
            line = reader.readLine();
            ArrayList<DVD> DVDs = new ArrayList<>();
            while (line != null) {
                String[] lineArray = line.split(", ");
                for (int i = 0; i < lineArray.length; i++) {
                    lineArray[i] = lineArray[i].replace('*', ',');
                }
                if (lineArray.length > 5){
                    DVDs.add(new DVD(lineArray[0], lineArray[1], lineArray[2], lineArray[3], lineArray[4], lineArray[5]));
                } else {
                    DVDs.add(new DVD(lineArray[0], lineArray[1], lineArray[2], lineArray[3], lineArray[4]));
                }
                line = reader.readLine();
            }
            return DVDs;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Writes the provided ArrayList of DVDs back into .&nbsp;csv format.
     * Also performs relevant data marshalling operations to ensure compliance with the .csv format.
     * @param DVDs The ArrayList of DVDs to be written into storage.
     * @return True if write operation was successful; False if an error occurred.
     */
    @Override
    public boolean writeList(ArrayList<DVD> DVDs) {
        try (PrintWriter pw = new PrintWriter(FILE_NAME)){
            pw.println("DVD title, Release Date, MPAA Rating, Director, Studio, User's Note");
            for (DVD d: DVDs) {
                String output = (d.getTitle().replaceAll(",","*") + ", " +
                        d.getReleaseDate().replaceAll(",","*") + ", " +
                        d.getRatingMPAA().replaceAll(",","*") + ", " +
                        d.getDirector().replaceAll(",","*") + ", " +
                        d.getStudio().replaceAll(",","*"));
                if (!d.getUserNote().equals("")) {
                    output += (", " + d.getUserNote());
                }
                pw.println(output);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write file: Data for this session has not been saved.");
            return false;
        }
        return true;
    }
}
