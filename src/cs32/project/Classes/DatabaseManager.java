/*
 * Emerson Jacobson
 * CS23, Section #0169
 * Assignment #, Problem #
 * INSERT SUMMARY HERE
 */
package cs32.project.Classes;

import cs32.project.GUIs.MainMenu;
import java.util.ArrayList;

public class DatabaseManager {
    static {
        System.out.println("asd");
    }
    
    public static ArrayList<Textbook> getAllItems() {
        // TODO: Actually pull from DB.
        ArrayList<Textbook> arr = new ArrayList<>();
        for(int i=0; i<30; i++) {
            arr.add(new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99));
            Textbook tb = new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99);
            tb.setIsSold(true);
            arr.add(tb);
        }
        return (ArrayList<Textbook>)arr.clone();
    }
    
    public static ArrayList<Textbook> getAllSoldItems() {
        // TODO: Actually pull from DB.
        ArrayList<Textbook> arr = new ArrayList<>();
        for(int i=0; i<30; i++){
            Textbook tb = new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99);
            tb.setIsSold(true);
            arr.add(tb);
        }
        return (ArrayList<Textbook>)arr.clone();
    }
    
    public static ArrayList<Textbook> getAllUnsoldItems(String query) {
        // TODO: Actually pull from DB.
        ArrayList<Textbook> arr = new ArrayList<>();
        for(int i=0; i<30; i++)
            arr.add(new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99));
        return (ArrayList<Textbook>)arr.clone();
    }
    
    public static ArrayList<Textbook> getAllItemsFromUser(Account acct) {
        // TODO: Actually pull from DB.
        ArrayList<Textbook> arr = new ArrayList<>();
        for(int i=0; i<30; i++){
            arr.add(new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99, acct));
            Textbook tb = new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99, acct);
            tb.setIsSold(true);
            arr.add(tb);
        }
        return (ArrayList<Textbook>)arr.clone();
    }
    
    public static ArrayList<Textbook> getAllSoldItemsFromUser(Account acct) {
        // TODO: Actually pull from DB.
        ArrayList<Textbook> arr = new ArrayList<>();
        for(int i=0; i<30; i++) {
            Textbook tb = new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99, acct);
            tb.setIsSold(true);
            arr.add(tb);
        }
        return (ArrayList<Textbook>)arr.clone();
    }
    
    public static ArrayList<Textbook> getAllUnsoldItemsFromUser(Account acct) {
        // TODO: Actually pull from DB.
        ArrayList<Textbook> arr = new ArrayList<>();
        for(int i=0; i<30; i++) {
            Textbook tb = new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99, acct);
            arr.add(tb);
        }
        return (ArrayList<Textbook>)arr.clone();
    }
    
    public static void addItem(Textbook tb) {
        // TODO: actually add item.
    }
}
