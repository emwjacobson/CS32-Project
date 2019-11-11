/*
 * Emerson Jacobson & Alice Li
 * CS23, Section #0169
 * Assignment: Team Project
 * Summary: 
 */
package cs32.project.GUIs;

import cs32.project.Classes.*;
import java.util.ArrayList;
import javafx.geometry.Insets;
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
        HBox bottom = new HBox(15);
        bottom.setAlignment(Pos.CENTER);
        
        
        Button view_all = new Button("View All");
        view_all.setMinWidth(125);
        view_all.setMinHeight(30);
        Button view_avail = new Button("View Available");
        view_avail.setMinWidth(125);
        view_avail.setMinHeight(30);
        Button view_sold = new Button("View Sold");
        view_sold.setMinWidth(125);
        view_sold.setMinHeight(30);
        Button my_info = new Button("My Info");
        my_info.setMinWidth(125);
        my_info.setMinHeight(30);
        
        view_all.setOnMouseClicked((MouseEvent e) -> {
            this.setCenter(null);
            ScrollPane scroll = new ScrollPane();
            scroll.setFitToWidth(true);
            
            Accordion a = new Accordion();
            ArrayList<Textbook> items = MainMenu.current_user.getAllTextbooks();
            for (Textbook i : items) {
                BorderPane bp = new BorderPane();
                Text info = new Text();
                info.setText("Class: " + i.getCourseDept() + i.getCourseNum() + "\n" +
                        "Title: " + i.getTitle() + ", Edition " + i.getEdNum() + ", Condition: " + i.getCondn() + "\n" +
                        "Description:\n" + i.getDescr() + "\n" +
                        "Price: " + i.getPrice() + "\n" + 
                        "Seller: " + i.getSeller().getFullName());
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
            ScrollPane scroll = new ScrollPane();
            scroll.setFitToWidth(true);
            
            Accordion a = new Accordion();
            ArrayList<Textbook> items = MainMenu.current_user.getForSale();
            for (Textbook i : items) {
                BorderPane bp = new BorderPane();
                Text info = new Text();
                info.setText("Class: " + i.getCourseDept() + i.getCourseNum() + "\n" +
                        "Title: " + i.getTitle() + ", Edition " + i.getEdNum() + ", Condition: " + i.getCondn() + "\n" +
                        "Description:\n" + i.getDescr() + "\n" +
                        "Price: " + i.getPrice() + "\n" + 
                        "Seller: " + i.getSeller().getFullName());
                bp.setLeft(info);
                TitledPane t = new TitledPane(i.getTitle(), bp);
                t.setText((i.getIsSold() ? "SOLD: " : "") + i.getCourseDept() + " " + i.getCourseNum() + " - " + i.getTitle());
                a.getPanes().add(t);
            }
            
            scroll.setContent(a);
            this.setCenter(scroll);
        });
        
        view_sold.setOnMouseClicked((MouseEvent e) -> {
            this.setCenter(null);
            ScrollPane scroll = new ScrollPane();
            scroll.setFitToWidth(true);
            
            Accordion a = new Accordion();
            ArrayList<Textbook> items = MainMenu.current_user.getSold();
            for (Textbook i : items) {
                BorderPane bp = new BorderPane();
                Text info = new Text();
                info.setText("Class: " + i.getCourseDept() + i.getCourseNum() + "\n" +
                        "Title: " + i.getTitle() + ", Edition " + i.getEdNum() + ", Condition: " + i.getCondn() + "\n" +
                        "Description:\n" + i.getDescr() + "\n" +
                        "Price: " + i.getPrice() + "\n" + 
                        "Seller: " + i.getSeller().getFullName());
                bp.setLeft(info);
                TitledPane t = new TitledPane(i.getTitle(), bp);
                t.setText((i.getIsSold() ? "SOLD: " : "") + i.getCourseDept() + " " + i.getCourseNum() + " - " + i.getTitle());
                a.getPanes().add(t);
            }
            
            scroll.setContent(a);
            this.setCenter(scroll);
        });
        
        my_info.setOnMouseClicked((MouseEvent e) -> {
            this.setCenter(null);
            Text t = new Text("Name: " + MainMenu.current_user.getFullName() + "\n" + 
                              "Phone: " + MainMenu.current_user.getPhone() + "\n" +
                              "Textbooks sold: " + MainMenu.current_user.getAllTextbooks().size());
            this.setCenter(t);
        });
        
        bottom.getChildren().addAll(view_all, view_avail, view_sold, my_info);
        HBox.setMargin(view_all, new Insets(15, 0, 15, 0));
        this.setBottom(bottom);
    }
    
}
