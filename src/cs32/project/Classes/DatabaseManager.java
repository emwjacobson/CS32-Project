/*
 * Emerson Jacobson
 * CS23, Section #0169
 * Assignment #, Problem #
 * INSERT SUMMARY HERE
 */
package cs32.project.Classes;

import java.util.ArrayList;

public class DatabaseManager {
    static {
        System.out.println("asd");
    }
    
    public static ArrayList<Textbook> getItems() {
        // TODO: Actually pull from DB.
        ArrayList<Textbook> arr = new ArrayList<>();
        for(int i=0; i<100; i++)
            arr.add(new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99));
        return (ArrayList<Textbook>)arr.clone();
    }
    
    public static ArrayList<Textbook> getItems(String query) {
        // TODO: Actually pull from DB.
        ArrayList<Textbook> arr = new ArrayList<>();
        arr.add(new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99));
        return (ArrayList<Textbook>)arr.clone();
    }
    
    public static void addItem(Textbook tb) {
        // TODO: actually add item.
    }
}
