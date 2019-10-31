/*
 * Emerson Jacobson
 * CS23, Section #0169
 * Assignment #, Problem #
 * INSERT SUMMARY HERE
 */
package cs32.project.Classes;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Emerson
 */
public class Account {
    private String fname;
    private String lname;
    private String phone;
    // As stated in the ArrayList decleration, using multiple threads might be a problem
    // with ArrayLists.
    private ArrayList<Textbook> books;
    private ReentrantLock lock;
    
    public Account() {
        
    }
    
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
    
    public ArrayList<Textbook> showAll() {
        // Clone the list instead of giving the full array reference.
        return (ArrayList<Textbook>)this.books.clone();
    }
    
    // TODO: This is unfinished, will currently return all textbooks.
    public ArrayList<Textbook> showForSale() {
        ArrayList<Textbook> rtn = (ArrayList<Textbook>)this.books.clone();
        
        // TODO: Remove dis
        // rtn.removeIf(bk -> (bk.getIsSold()));
        
        return rtn;
    }
    
    // TODO: This is unfinished, will currently return all textbooks.
    public ArrayList<Textbook> showSold() {
        ArrayList<Textbook> rtn = (ArrayList<Textbook>)this.books.clone();
        
        // TODO: Remove dis
//        rtn.removeIf(bk -> (!bk.getIsSold()));
        
        return rtn;
    }
}
