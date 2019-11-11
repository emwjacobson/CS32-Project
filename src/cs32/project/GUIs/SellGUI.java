/*
 * Emerson Jacobson & Alice Li
 * CS23, Section #0169
 * Assignment: Team Project
 * Summary: 
 */
package cs32.project.GUIs;

import cs32.project.Classes.*;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import javafx.event.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.converter.IntegerStringConverter;

public class SellGUI extends BorderPane implements AllCourses {

    public SellGUI() {

        // ComboBox setup for course department and number 
        ComboBox dept = new ComboBox();
        ComboBox cnum = new ComboBox();
        dept.getItems().addAll((Object[]) deptList);
        EventHandler<ActionEvent> event = (ActionEvent e) -> {
            int index = dept.getSelectionModel().getSelectedIndex();
            cnum.getItems().clear();
            cnum.getItems().addAll((Object[]) allCourses[index]);
        };
        dept.setOnAction(event);
        dept.setPrefWidth(100);
        cnum.setPrefWidth(100);

        // ComboBox setup for condition
        ComboBox cond = new ComboBox();
        cond.getItems().addAll("New", "Like New", "Used", "Worn");
        cond.setPrefWidth(100);

        // TextField & TextArea for user inputs
        TextField title = new TextField();
        TextField ednum = new TextField();
        TextArea descr = new TextArea();
        descr.setPrefHeight(125);

        // TextField setup for price to only allow numbers with up to 2 decimals
        TextField price = new TextField();
        price.setPrefWidth(125);
        UnaryOperator<Change> filter = c -> {
            Pattern decimalPattern = Pattern.compile("\\d*(\\.\\d{0,2})?");
            if (decimalPattern.matcher(c.getControlNewText()).matches()) {
                return c;
            } else {
                return null;
            }
        };
        price.setTextFormatter(new TextFormatter<>(filter));

        // Button setup to submit form
        Button button = new Button("Done");
        button.setPrefSize(75, 25);
        button.setOnAction((ActionEvent ae) -> {
            // TODO: Submit to database
        });

        // Gridpane to for sell form
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(15));
        gp.setHgap(10);
        gp.setVgap(5);
        gp.setAlignment(Pos.CENTER);
        gp.add(new Label("Course Department:"), 0, 0);
        gp.add(dept, 1, 0);
        gp.add(new Label("    Course Number:"), 2, 0);
        gp.add(cnum, 3, 0);
        gp.add(new Label("Title:"), 0, 1);
        gp.add(title, 1, 1, 3, 1);
        gp.add(new Label("Edition:"), 0, 2);
        gp.add(ednum, 1, 2, 3, 1);
        gp.add(new Label("Price:"), 0, 3);
        gp.add(price, 1, 3);
        gp.add(new Label("             Condition:"), 2, 3);
        gp.add(cond, 3, 3);
        gp.add(new Label("Description:"), 0, 4);
        gp.add(descr, 1, 4, 3, 1);
        gp.add(button, 0, 8, 4, 1);
        GridPane.setHalignment(button, HPos.CENTER);
        // TODO: Upload images setup

        this.setCenter(gp);
    }

}
