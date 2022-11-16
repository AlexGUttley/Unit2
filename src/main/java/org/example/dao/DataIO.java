package org.example.dao;

import org.example.dto.DVD;

import java.util.ArrayList;

public interface DataIO {

    /**
     * Reads the stored data representing the collection, and returns an ArrayList&lt;DVD&gt; containing all entries.
     * Also perform relevant data marshalling operations.
     * @return The ArrayList of DVDs that represents the data in storage.
     */
    ArrayList<DVD> readList();

    /**
     * Writes the provided ArrayList of DVDs back into storage.
     * Also performs relevant data marshalling operations.
     * @param DVDs The ArrayList of DVDs to be written into storage.
     * @return True if write operation was successful; False if an error occurred.
     */
    boolean writeList(ArrayList<DVD> DVDs);
}
