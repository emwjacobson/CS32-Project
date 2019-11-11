/*
 * Emerson Jacobson & Alice Li
 * CS23, Section #0169
 * Assignment: Team Project
 * Summary: 
 */
package cs32.project.Classes;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String fname;
    private String lname;
    private String phone;
    // As stated in the ArrayList decleration, using multiple threads might be a problem
    // with ArrayLists.
    private ArrayList<Textbook> books;
    private ReentrantLock lock = new ReentrantLock();
    
    public Account(String fname, String lname, String phone) {
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        // Get textbooks from DB
        this.lock.lock();
        try {
            this.books = DatabaseManager.getAllItemsFromUser(this);
        } finally {
            this.lock.unlock();
        }
    }
    
    public String getFirstName() { return this.fname; }
    public String getLastName() { return this.lname; }
    public String getFullName() { return this.fname + " " + this.lname; }
    public String getPhone() { return this.phone; }
    
    public void addTextbook(Textbook tb) {
        this.lock.lock();
        try {
            this.books.add(tb);
        } finally {
            this.lock.unlock();
        }
    }
    
    public void delTextbook(Textbook tb) {
        this.lock.lock();
        try {
            this.books.remove(tb);
        } finally {
            this.lock.unlock();
        }
    }
    
    public ArrayList<Textbook> getAllTextbooks() {
        // Clone the list instead of giving the full array reference.
        return (ArrayList<Textbook>)this.books.clone();
    }
    
    // TODO: This is unfinished, will currently return all textbooks.
    public ArrayList<Textbook> getForSale() {
        ArrayList<Textbook> rtn = (ArrayList<Textbook>)this.books.clone();
        
         rtn.removeIf(bk -> (bk.getIsSold()));
        
        return rtn;
    }
    
    // TODO: This is unfinished, will currently return all textbooks.
    public ArrayList<Textbook> getSold() {
        ArrayList<Textbook> rtn = (ArrayList<Textbook>)this.books.clone();
        
        rtn.removeIf(bk -> (!bk.getIsSold()));
        
        return rtn;
    }
}
