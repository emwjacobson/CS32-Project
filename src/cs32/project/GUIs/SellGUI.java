/*
 * Emerson Jacobson & Alice Li
 * CS23, Section #0169
 * Assignment: Team Project
 * Summary: SELL GUI
 */
package cs32.project.GUIs;

import cs32.project.Classes.*;
import java.io.File;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import javafx.event.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
        descr.setPrefHeight(75);

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

        // Create ImageView
        ImageView iv = new ImageView();
        iv.setFitHeight(200);
        iv.setFitWidth(200);
        iv.setPreserveRatio(true);
        StackPane sp = new StackPane(iv);
        sp.setPrefSize(200,200);   
        StackPane.setAlignment(iv,Pos.CENTER);
              
        // Button setup to upload image
        Button upload = new Button("Choose Image");
        upload.setPrefSize(100, 25);
        upload.setOnAction((ActionEvent ae) -> {
            Stage uploadStage = new Stage();
            FileChooser f = new FileChooser();
            File file = f.showOpenDialog(uploadStage);
            if (file != null) { // only proceed, if file was chosen
                Image img = new Image(file.toURI().toString());
                iv.setImage(img);
            }
        });

        // Button setup to submit form
        Button finish = new Button("Done");
        finish.setPrefSize(75, 25);
        finish.setOnAction((ActionEvent ae) -> {
            String cond2 = (String)cond.getValue();
            cond2 = cond2.replaceAll("\\s+", "");
            Textbook tb = new Textbook((String)dept.getValue(), (String)cnum.getValue(), title.getText(), ednum.getText(), descr.getText(), Textbook.Condition.valueOf(cond2), Double.parseDouble(price.getText()), MainMenu.current_user);
            tb.addImage(iv.getImage());
            DatabaseManager.addItem(tb);
            title.setText("");
            ednum.setText("");
            descr.setText("");
            price.setText("");
        });
        
        // Labels
        Label imageLabel = new Label("Photo:");
        Label condLabel = new Label("Condition:");
        Label cnumLabel = new Label("Course Number:");
        
        // GridPane
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(15));
        gp.setHgap(10);
        gp.setVgap(5);
        gp.setAlignment(Pos.CENTER);    
        gp.add(new Label("Course Department:"), 0, 0);
        gp.add(dept, 1, 0);
        gp.add(cnumLabel, 2, 0);
        gp.add(cnum, 3, 0);
        gp.add(new Label("Title:"), 0, 1);
        gp.add(title, 1, 1, 3, 1);
        gp.add(new Label("Edition:"), 0, 2);
        gp.add(ednum, 1, 2, 3, 1);
        gp.add(new Label("Price:"), 0, 3);
        gp.add(price, 1, 3);
        gp.add(condLabel, 2, 3);
        gp.add(cond, 3, 3);
        gp.add(new Label("Description:"), 0, 4);
        gp.add(descr, 1, 4, 3, 1);
        gp.add(imageLabel, 0, 5, 2, 1);
        gp.add(upload, 1, 5);
        gp.add(sp, 2, 5);
        gp.add(finish, 0, 9, 4, 1);
        GridPane.setHalignment(finish, HPos.CENTER);
        GridPane.setHalignment(cnumLabel, HPos.RIGHT);
        GridPane.setHalignment(condLabel, HPos.RIGHT);
        GridPane.setValignment(imageLabel, VPos.TOP);
        GridPane.setValignment(upload, VPos.TOP);

        this.setCenter(gp);
    }

}
