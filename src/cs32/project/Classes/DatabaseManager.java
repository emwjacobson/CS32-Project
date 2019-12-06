/*
 * Emerson Jacobson & Alice Li
 * CS23, Section #0169
 * Assignment: Team Project
 * Summary: 
 */
package cs32.project.Classes;

import cs32.project.Classes.Textbook.Condition;
import cs32.project.GUIs.MainMenu;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javax.imageio.ImageIO;

public class DatabaseManager {
    
    private static Connection conn;
    
    static {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://192.168.1.109:3306/bookswap", "library", "LibraryPassword");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<Textbook> getAllItemsForCourse(String dept, String cnum) {
        ArrayList<Textbook> tbs = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM books WHERE courseDept = ? AND courseNum = ?;");
            ps.setString(1, dept);
            ps.setString(2, cnum);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Textbook tb = new Textbook(rs.getString("courseDept"), String.valueOf(rs.getInt("courseNum")), rs.getString("title"), rs.getString("edNum"), rs.getString("descr"), Condition.values()[rs.getInt("cond")], rs.getDouble("price"), new Account(rs.getInt("seller")));
                BufferedImage img = ImageIO.read(rs.getBinaryStream("images"));
                tb.addImage(SwingFXUtils.toFXImage(img, null));
                tbs.add(tb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbs;
    }
    
    public static ArrayList<Textbook> getAllItemsFromUser(Account acct) {
        ArrayList<Textbook> tbs = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM books WHERE seller = ?;");
            ps.setInt(1, acct.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Textbook tb = new Textbook(rs.getString("courseDept"), String.valueOf(rs.getInt("courseNum")), rs.getString("title"), rs.getString("edNum"), rs.getString("descr"), Condition.values()[rs.getInt("cond")], rs.getDouble("price"), new Account(rs.getInt("seller")));
                tb.setIsSold(rs.getBoolean("isSold"));
                BufferedImage img = ImageIO.read(rs.getBinaryStream("images"));
                tb.addImage(SwingFXUtils.toFXImage(img, null));
                tbs.add(tb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbs;
    }
    
//    public static ArrayList<Textbook> getAllSoldItemsFromUser(Account acct) {
//        // TODO: Actually pull from DB.
//        ArrayList<Textbook> arr = new ArrayList<>();
//        for(int i=0; i<30; i++) {
//            Textbook tb = new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99, acct);
//            tb.setIsSold(true);
//            arr.add(tb);
//        }
//        return (ArrayList<Textbook>)arr.clone();
//    }
//    
//    public static ArrayList<Textbook> getAllUnsoldItemsFromUser(Account acct) {
//        // TODO: Actually pull from DB.
//        ArrayList<Textbook> arr = new ArrayList<>();
//        for(int i=0; i<30; i++) {
//            Textbook tb = new Textbook("CSCI", "32", "Advanced Java", "1", "This is the description.", Textbook.Condition.New, 99.99, acct);
//            arr.add(tb);
//        }
//        return (ArrayList<Textbook>)arr.clone();
//    }
    
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
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ImageIO.write(SwingFXUtils.fromFXImage(tb.getImage(0), null), "jpg", bout);
            byte[] data = bout.toByteArray();
            ps.setBytes(9, data);
            ps.setInt(10, tb.getSeller().getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
