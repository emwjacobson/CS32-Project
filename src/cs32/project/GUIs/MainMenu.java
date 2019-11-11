/*
 * Emerson Jacobson & Alice Li
 * CS23, Section #0169
 * Assignment: Team Project
 * Summary: 
 */
package cs32.project.GUIs;

import cs32.project.Classes.Account;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenu extends Application {
    
    public static Account current_user;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO: Some kind of login?
        current_user = new Account("Some", "Student", "18001112222");
        
        // Sets the default page
        BorderPane bp = new BorderPane();
        AccountGUI acctGUI = new AccountGUI();
        bp.setCenter(acctGUI);
        
        // Label for title
        Label title = new Label("El Camino Student Used Textbook Portal");
        title.setPadding(new Insets(15, 15, 0, 15));
        title.setFont(new Font(28));
        
        // Main menu buttons
        Button buy_button = new Button("BUY");
        buy_button.setMinWidth(175);
        buy_button.setMinHeight(40);
        Button sell_button = new Button("SELL");
        sell_button.setMinWidth(175);
        sell_button.setMinHeight(40);
        Button account_button = new Button("ACCOUNT");
        account_button.setMinWidth(175);
        account_button.setMinHeight(40);

        buy_button.setOnMouseClicked((MouseEvent e) -> {
            bp.setCenter(null);
            bp.setCenter(new BuyGUI());
        });
        
        sell_button.setOnMouseClicked((MouseEvent e) -> {
            bp.setCenter(null);
            bp.setCenter(new SellGUI());
        });
        
        account_button.setOnMouseClicked((MouseEvent e) -> {
            bp.setCenter(null);
            bp.setCenter(acctGUI);
        });
       
        // HBox for main menu buttons
        HBox hb = new HBox(15);
        hb.getChildren().addAll(buy_button, sell_button, account_button);
        hb.setAlignment(Pos.CENTER);
        HBox.setMargin(buy_button, new Insets(15, 0, 15, 0));
        
        // VBox to hold title and main menu buttons
        VBox vb = new VBox();
        vb.getChildren().addAll(title, hb);
        vb.setAlignment(Pos.CENTER);
        bp.setTop(vb);
        Scene scene = new Scene(bp, 600, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
 