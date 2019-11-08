/*
 * Emerson Jacobson
 * CS23, Section #0169
 * Assignment #, Problem #
 * INSERT SUMMARY HERE
 */
package cs32.project.GUIs;

import cs32.project.Classes.DatabaseManager;
import cs32.project.Classes.Textbook;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class AccountGUI extends BorderPane {
    
    public AccountGUI() {
        HBox bottom = new HBox();
        bottom.setAlignment(Pos.CENTER);
        
        Button view_all = new Button("View All");
        view_all.setMinWidth(150);
        view_all.setMinHeight(40);
        Button view_avail = new Button("View Available");
        view_avail.setMinWidth(150);
        view_avail.setMinHeight(40);
        Button view_sold = new Button("View Sold");
        view_sold.setMinWidth(150);
        view_sold.setMinHeight(40);
        Button my_info = new Button("My Info");
        my_info.setMinWidth(150);
        my_info.setMinHeight(40);
        
        view_all.setOnMouseClicked((MouseEvent e) -> {
            this.setCenter(null);
            ScrollPane scroll = new ScrollPane();
            scroll.setFitToWidth(true);
            
            Accordion a = new Accordion();
            ArrayList<Textbook> items = DatabaseManager.getItems();
            for (Textbook i : items) {
                BorderPane bp = new BorderPane();
                Text info = new Text();
                info.setText("Class: " + i.getCourseDept() + i.getCourseNum() + "\n" +
                        "Title: " + i.getTitle() + ", Edition " + i.getEdNum() + ", Condition: " + i.getCondn() + "\n" +
                        "Description:\n" + i.getDescr() + "\n" +
                        "Price: " + i.getPrice());
                bp.setLeft(info);
                TitledPane t = new TitledPane(i.getTitle(), bp);
                t.setText((i.getIsSold() ? "SOLD: " : "") + i.getCourseDept() + " " + i.getCourseNum() + " - " + i.getTitle());
                a.getPanes().add(t);
            }
            
            scroll.setContent(a);
            this.setCenter(scroll);
        });
        
        view_avail.setOnMouseClicked((MouseEvent e) -> {
            this.setCenter(null);
        });
        
        view_sold.setOnMouseClicked((MouseEvent e) -> {
            this.setCenter(null);
        });
        
        my_info.setOnMouseClicked((MouseEvent e) -> {
            this.setCenter(null);
        });
        
        bottom.getChildren().addAll(view_all, view_avail, view_sold, my_info);
        
        this.setBottom(bottom);
    }
    
}
