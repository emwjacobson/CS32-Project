/*
 * Emerson Jacobson & Alice Li
 * CS23, Section #0169
 * Assignment: Team Project
 * Summary: 
 */
package cs32.project.Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManager {
    
    private static Connection conn;
    
    static {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://192.168.1.109:3306/bookswap", "library", "LibraryPassword");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<Textbook> getAllItems() {
        // TODO: Actually pull from DB.
        ArrayList<Textbook> arr = new ArrayList<>();
//        for(int i=0; i<30; i++) {
//            arr.add(new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99));
//            Textbook tb = new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99);
//            tb.setIsSold(true);
//            arr.add(tb);
//        }
        return (ArrayList<Textbook>)arr.clone();
    }
    
    public static ArrayList<Textbook> getAllSoldItems() {
        // TODO: Actually pull from DB.
        ArrayList<Textbook> arr = new ArrayList<>();
//        for(int i=0; i<30; i++){
//            Textbook tb = new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99);
//            tb.setIsSold(true);
//            arr.add(tb);
//        }
        return (ArrayList<Textbook>)arr.clone();
    }
    
    public static ArrayList<Textbook> getAllUnsoldItems(String query) {
        // TODO: Actually pull from DB.
        ArrayList<Textbook> arr = new ArrayList<>();
//        for(int i=0; i<30; i++)
//            arr.add(new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99));
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
        try {
            // TODO: actually add item.
            PreparedStatement ps = conn.prepareStatement("INSERT INTO books (title, courseDept, courseNum, edNum, descr, cond, price, isSold, images, seller) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, tb.getTitle());
            ps.setString(2, tb.getCourseDept());
            ps.setString(3, tb.getCourseNum());
            ps.setInt(4, Integer.parseInt(tb.getEdNum()));
            ps.setString(5, tb.getDescr());
            ps.setInt(6, tb.getCondn().ordinal());
            ps.setDouble(7, tb.getPrice());
            ps.setBoolean(8, tb.getIsSold());
            ps.setString(9, "I dont know what to do for Images :s");
            ps.setInt(10, tb.getSeller().getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
