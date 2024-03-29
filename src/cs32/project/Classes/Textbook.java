/*
 * Emerson Jacobson & Alice Li
 * CS23, Section #0169
 * Assignment: Team Project
 * Summary: 
 */
package cs32.project.Classes;


import java.util.ArrayList;
import javafx.scene.image.Image;

public class Textbook {

    public static enum Condition {
        New,
        LikeNew,
        Used,
        Worn
    }
    // CREATE TABLE books (id INT PRIMARY KEY, title VARCHAR(128), courseDept VARCHAR(32), courseNum INT, edNum INT, descr LONGTEXT, cond INT, price DOUBLE, isSold TINYINT(1), images LONGBLOB, seller VARCHAR(128));
    private String courseDept; // Course Department
    private String courseNum; // Course Number
    private String title; // Textbook Title
    private String edNum; // Edition Number
    private String descr; // Description
    private Condition condn; // Condition
    private double price; // Price
    private boolean isSold; // True if  sold, false if still for sale
    private ArrayList<Image> images = new ArrayList<>(); // Images
    private Account seller; // Seller

    public Textbook(String courseDept, String courseNum, String title, String edNum, String descr, Condition condn, double price, Account seller) {
        this.courseDept = courseDept;
        this.courseNum = courseNum;
        this.title = title;
        this.edNum = edNum;
        this.descr = descr;
        this.condn = condn;
        this.price = price;
        this.isSold = false;
        this.seller = seller;
    }

    // Accessors
    public String getCourseDept() {
        return courseDept;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public String getTitle() {
        return title;
    }

    public String getEdNum() {
        return edNum;
    }

    public String getDescr() {
        return descr;
    }

    public Condition getCondn() {
        return condn;
    }

    public double getPrice() {
        return price;
    }

    public boolean getIsSold() {
        return isSold;
    }

    public Account getSeller() {
        return seller;
    }

    // Mutators
    public void setCourseDept(String courseDept) {
        this.courseDept = courseDept;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEdNum(String edNum) {
        this.edNum = edNum;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public void setCondn(Condition condn) {
        this.condn = condn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIsSold(boolean isSold) {
        this.isSold = isSold;
    }

    // Methods for Images Vector
    public Image getImage(int i) {
        return images.get(i);
    }

    public void addImage(Image addMe) {
        images.add(addMe);
    }

    public void delImage(Image delMe) {
        images.remove(delMe);
    }

}
