/*
 * Emerson Jacobson
 * CS23, Section #0169
 * Assignment #, Problem #
 * INSERT SUMMARY HERE
 */
package cs32.project.Classes;

import java.awt.Image;
import java.util.ArrayList;

public class Textbook {
    
    public static enum Condition {
        New,
        LikeNew,
        Used,
        Worn
    }
    
    private String courseDept; // Course Department
    private String courseNum; // Course Number
    private String title; // Textbook Title
    private String edNum; // Edition Number
    private String descr; // Description
    private Condition condn; // Condition
    private double price; // Price
    private boolean isSold; // True if  sold, false if still for sale
    private ArrayList<Image> images; // Images
    private Account seller; // Seller
      
    // Constructor
    Textbook(String courseDept, String courseNum, String title, String edNum, String descr, Condition condn, double price) {
        this.courseDept = courseDept;
        this.courseNum = courseNum;
        this.title = title;
        this.edNum = edNum;
        this.descr = descr;
        this.condn = condn;
        this.price = price;
        this.isSold = false;
    }
    
    // Mutators
    private String getCourseDept() { return courseDept; }
    private String getCourseNum() { return courseNum; }
    private String getTitle() { return title; } 
    private String getEdNum() { return edNum; }
    private String getDescr() { return descr; }
    private Condition getCondn() { return condn; }
    private double getPrice() { return price; }
    private boolean getIsSold() { return isSold; }
    private Account getSeller() { return seller; }
    
    // Accessors
    private void setCourseDept(String courseDept) { this.courseDept = courseDept; }
    private void setCourseNum(String courseNum) { this.courseNum = courseNum; }
    private void setTitle(String title) { this.title = title; }
    private void setEdNum(String edNum) { this.edNum = edNum; }
    private void setDescr(String descr) { this.descr = descr; }
    private void setCondn(Condition condn) { this.condn = condn; }
    private void setPrice(double price) { this.price = price; }
    private void setIsSold(boolean isSold) { this.isSold = isSold; }
    
    // Methods for Images Vector
    private Image getImage(int i) { return images.get(i); }
    private void addImage(Image addMe) { images.add(addMe); }
    private void delImage(Image delMe) { images.remove(delMe); }
    
}
