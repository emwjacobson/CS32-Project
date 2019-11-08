/*
 * Emerson Jacobson
 * CS23, Section #0169
 * Assignment #, Problem #
 * INSERT SUMMARY HERE
 */
package cs32.project.Classes;

import java.util.ArrayList;

/**
 *
 * @author Emerson
 */
public class DatabaseManager {
    public DatabaseManager() {
        // TODO: Connect to database
    }
    
    public ArrayList<Textbook> getItems() {
        // TODO: Actually pull from DB.
        ArrayList<Textbook> arr = new ArrayList<>();
        arr.add(new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99));
        return arr;
    }
    
    public ArrayList<Textbook> getItems(String query) {
        // TODO: Actually pull from DB.
        ArrayList<Textbook> arr = new ArrayList<>();
        arr.add(new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99));
        return arr;
    }
    
    public void addItem(Textbook tb) {
        // TODO: actually add item.
    }
}
