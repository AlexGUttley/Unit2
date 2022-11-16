package org.example.dao;

import org.example.dto.DVD;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;

public class FileIO {

    private static final String FILE_NAME = "DVDCollection.csv";

    public FileIO() {
    }
    public ArrayList<DVD> getListFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = "placeholder";
            line = reader.readLine();//reads twice to ensure the first line (categories) is not used
            line = reader.readLine();
            ArrayList<DVD> DVDs = new ArrayList<DVD>();
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

    public boolean writeListToFile(ArrayList<DVD> DVDs) {
        try (PrintWriter pw = new PrintWriter(FILE_NAME)){
            for (DVD d: DVDs) {
                String output = (d.getTitle() + ", " + d.getReleaseDate() + ", " + d.getRatingMPAA() + ", " +
                        d.getDirector() + ", " + d.getStudio());
                if (!d.getUserNote().equals("")) {
                    output += (", " + d.getUserNote());
                }
                pw.println(output);
            }
        } catch (FileNotFoundException e) {

            System.out.println("Unable to write file: Data for this session has not been saved.");
            //throw new RuntimeException(e.getCause());
            return false;
        }
        return true;
    }


    //Interfaces with a csv to read and write data that comprises the DVD collection.

}
