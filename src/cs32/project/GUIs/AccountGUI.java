/*
 * Emerson Jacobson & Alice Li
 * CS23, Section #0169
 * Assignment: Team Project
 * Summary: ACCOUNT GUI
 */
package cs32.project.GUIs;

import cs32.project.Classes.*;
import java.util.ArrayList;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class AccountGUI extends BorderPane {
    
    ArrayList<Textbook> all_tbs;
    ArrayList<Textbook> sold_tbs;
    ArrayList<Textbook> unsold_tbs;

    public AccountGUI() {

        // Account Buttons
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

        // Shared Label, ListView, TextField components
        Label title = new Label("");
        ListView<String> list = new ListView<>();
        list.setPrefSize(575, 150);
        list.getItems().add("");
        TextArea text = new TextArea();
        text.setWrapText(true);
        text.setPrefSize(350, 200);
        text.setEditable(false);
        
        // Create ImageView
        ImageView iv = new ImageView();
        iv.setFitHeight(200);
        iv.setFitWidth(200);
        iv.setPreserveRatio(true);
        Pane imgp = new Pane(iv);
        imgp.setPrefSize(200,200); 
        
        all_tbs = DatabaseManager.getAllItemsFromUser(MainMenu.current_user);
        sold_tbs = ((ArrayList<Textbook>)all_tbs.clone());
        sold_tbs.removeIf((Textbook tb) -> !tb.getIsSold());
        unsold_tbs = ((ArrayList<Textbook>)all_tbs.clone());
        unsold_tbs.removeIf((Textbook tb) -> tb.getIsSold());
        
        // Default displays My Info
        Text show = new Text("Name: " + MainMenu.current_user.getFullName() + "\n"
                + "Phone: " + MainMenu.current_user.getPhone() + "\n"
                + "Textbooks sold: " + sold_tbs.size());
        this.setCenter(show);

        // Button MouseEvents       
        view_all.setOnMouseClicked((MouseEvent e) -> {
            this.setCenter(null);

            // Update components
            title.setText("ALL");
            list.getItems().clear();
            text.clear();
            iv.setImage(null);
            for (Textbook tb : all_tbs) {
                list.getItems().add(tb.getTitle());
            }

            list.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                if (list.getSelectionModel().getSelectedIndex() < 0 || list.getSelectionModel().getSelectedIndex() > all_tbs.size())
                    return;
                Textbook selected_book = all_tbs.get(list.getSelectionModel().getSelectedIndex());
                text.setText(selected_book.getDescr());
                iv.setImage(selected_book.getImage(0));
            });

            // Setup GridPane
            GridPane gp = new GridPane();
            gp.setPadding(new Insets(15));
            gp.setHgap(10);
            gp.setVgap(5);
            gp.setAlignment(Pos.CENTER);
            gp.add(title, 0, 0, 2, 1);
            gp.add(list, 0, 1, 2, 1);
            gp.add(text, 0, 2);
            gp.add(imgp, 1, 2);
            GridPane.setHalignment(title, HPos.CENTER);

            this.setCenter(gp);
        });

        view_avail.setOnMouseClicked((MouseEvent e) -> {
            this.setCenter(null);

            // Update components
            title.setText("AVAILABLE");
            list.getItems().clear();
            text.clear();
            iv.setImage(null);
            for (Textbook tb : unsold_tbs) {
                    list.getItems().add(tb.getTitle());
            }

            list.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                if (list.getSelectionModel().getSelectedIndex() < 0 || list.getSelectionModel().getSelectedIndex() > unsold_tbs.size())
                    return;
                Textbook selected = unsold_tbs.get(list.getSelectionModel().getSelectedIndex());
                text.setText(selected.getDescr());
                iv.setImage(selected.getImage(0));
            });

            // Setup GridPane
            GridPane gp = new GridPane();
            gp.setPadding(new Insets(15));
            gp.setHgap(10);
            gp.setVgap(5);
            gp.setAlignment(Pos.CENTER);
            gp.add(title, 0, 0, 2, 1);
            gp.add(list, 0, 1, 2, 1);
            gp.add(text, 0, 2);
            gp.add(imgp, 1, 2);
            GridPane.setHalignment(title, HPos.CENTER);

            this.setCenter(gp);
        });

        view_sold.setOnMouseClicked((MouseEvent e) -> {
            this.setCenter(null);

            // Update components
            title.setText("SOLD");
            list.getItems().clear();
            text.clear();
            iv.setImage(null);
            for(Textbook tb : sold_tbs)
                list.getItems().add(tb.getTitle());
            
            list.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                if (list.getSelectionModel().getSelectedIndex() < 0 || list.getSelectionModel().getSelectedIndex() > sold_tbs.size())
                    return;
                Textbook selected = sold_tbs.get(list.getSelectionModel().getSelectedIndex());
                text.setText(selected.getDescr());
                iv.setImage(selected.getImage(0));
            });

            // Setup GridPane
            GridPane gp = new GridPane();
            gp.setPadding(new Insets(15));
            gp.setHgap(10);
            gp.setVgap(5);
            gp.setAlignment(Pos.CENTER);
            gp.add(title, 0, 0, 2, 1);
            gp.add(list, 0, 1, 2, 1);
            gp.add(text, 0, 2);
            gp.add(imgp, 1, 2);
            GridPane.setHalignment(title, HPos.CENTER);

            this.setCenter(gp);
        });

        my_info.setOnMouseClicked((MouseEvent e) -> {
            this.setCenter(null);
            Text t = new Text("Name: " + MainMenu.current_user.getFullName() + "\n"
                    + "Phone: " + MainMenu.current_user.getPhone() + "\n"
                    + "Textbooks sold: " + sold_tbs.size());
            this.setCenter(t);
        });

        HBox bottom = new HBox(15);
        bottom.setAlignment(Pos.CENTER);
        bottom.getChildren().addAll(view_all, view_avail, view_sold, my_info);
        HBox.setMargin(view_all, new Insets(15, 0, 15, 0));

        this.setBottom(bottom);
    }

}
