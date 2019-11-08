/*
 * Emerson Jacobson
 * CS23, Section #0169
 * Assignment #, Problem #
 * INSERT SUMMARY HERE
 */
package cs32.project.GUIs;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Emerson
 */
public class AccountGUI extends BorderPane {
    
    public AccountGUI() {
        this.setBottom(new HBox(new Button("View All"), new Button("View Available"), new Button("View Sold"), new Button("My Info")));
    }
    
}
