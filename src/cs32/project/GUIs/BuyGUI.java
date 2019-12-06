/*
 * Emerson Jacobson & Alice Li
 * CS23, Section #0169
 * Assignment: Team Project
 * Summary: BUY GUI
 */
package cs32.project.GUIs;

import cs32.project.Classes.*;
import static cs32.project.Classes.AllCourses.allCourses;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class BuyGUI extends BorderPane implements AllCourses {
    
    private ArrayList<Textbook> current_tbs;

    public BuyGUI() throws URISyntaxException, MalformedURLException {

        // Create ListView setup for course department, number, and search results
        ListView<String> dept = new ListView<>();
        ListView<String> cnum = new ListView<>();
        ListView<String> results = new ListView<>();
        dept.setPrefSize(75, 200);
        dept.getItems().addAll(deptList);
        cnum.setPrefSize(75, 200);
        cnum.getItems().add("");
        results.setPrefSize(400, 150);
        results.getItems().add("");

        // Create TextField to display details
        TextArea details = new TextArea();
        details.setWrapText(true);
        details.setPrefSize(250, 225);
        details.setEditable(false);
        
        // Create ImageView
        ImageView iv = new ImageView();
        iv.setFitHeight(150);
        iv.setFitWidth(150);
        iv.setPreserveRatio(true);
        StackPane sp = new StackPane(iv);
        sp.setPrefSize(150, 150);   
        StackPane.setAlignment(iv,Pos.CENTER);   

        // Listeners
        dept.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
            if (dept.getSelectionModel().getSelectedIndex() < 0)
                return;
            int index = dept.getSelectionModel().getSelectedIndex();
            cnum.getItems().clear();
            cnum.getItems().addAll((String[]) allCourses[index]);
        });

        cnum.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
            if (cnum.getSelectionModel().getSelectedIndex() < 0)
                return;
            results.getItems().clear();
            current_tbs = DatabaseManager.getAllItemsForCourse(dept.getSelectionModel().getSelectedItem(), cnum.getSelectionModel().getSelectedItem());
            for (Textbook tb : current_tbs) {
                results.getItems().add(tb.getTitle() + " Ed. " + tb.getEdNum() + " -- " + tb.getCondn() + " -- $" + tb.getPrice());
            }
        });

        results.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
            if (results.getSelectionModel().getSelectedIndex() < 0)
                return;
            Textbook tb = current_tbs.get(results.getSelectionModel().getSelectedIndex());
            String desc = "Book Info: \n" +
                          "\tDescription: " + tb.getDescr() + "\n\n" + 
                          "Seller Info: \n" +
                          "\tName: " + tb.getSeller().getFullName() + "\n" +
                          "\tPhone: " + tb.getSeller().getPhone();
            details.setText(desc);
            iv.setImage(tb.getImage(0));
        });

        // Labels
        Label courseLabel = new Label("Course Selection:");
        Label deptLabel = new Label("Department");
        Label cnumLabel = new Label("Number");
        Label resultsLabel = new Label("Available for Sale:");
        Label detailsLabel = new Label("Select item to view details");

        // GridPane
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(15));
        gp.setHgap(10);
        gp.setVgap(5);
        gp.setAlignment(Pos.CENTER);
        gp.add(courseLabel, 0, 0, 2, 1);
        gp.add(deptLabel, 0, 1);
        gp.add(dept, 0, 2);
        gp.add(cnumLabel, 1, 1);
        gp.add(cnum, 1, 2);
        gp.add(resultsLabel, 2, 0);
        gp.add(detailsLabel, 2, 1);
        gp.add(results, 2, 2);
        gp.add(details, 2, 3);
        gp.add(sp, 0, 3, 2, 1);
        GridPane.setHalignment(courseLabel, HPos.CENTER);
        GridPane.setHalignment(deptLabel, HPos.CENTER);
        GridPane.setHalignment(cnumLabel, HPos.CENTER);
        GridPane.setHalignment(resultsLabel, HPos.CENTER);
        GridPane.setHalignment(detailsLabel, HPos.CENTER);

        this.setCenter(gp);
    }

}
