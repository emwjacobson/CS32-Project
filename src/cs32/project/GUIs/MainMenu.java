/*
 * Emerson Jacobson
 * CS23, Section #0169
 * Assignment #, Problem #
 * INSERT SUMMARY HERE
 */
package cs32.project.GUIs;

import cs32.project.Classes.Account;
import javafx.application.Application;
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

/**
 *
 * @author Emerson
 */
public class MainMenu extends Application {
    
    public static Account current_user;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO: Some kind of login?
        current_user = new Account("Some", "Student", "18001112222");
        
        BorderPane bp = new BorderPane();
        
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        
        Label title = new Label("El Camino Student Used Textbook Portal");
        title.setFont(new Font(28));
        
        HBox hb = new HBox();
        
        Button buy_button = new Button("BUY");
        buy_button.setMinWidth(200);
        buy_button.setMinHeight(40);
        Button sell_button = new Button("SELL");
        sell_button.setMinWidth(200);
        sell_button.setMinHeight(40);
        Button account_button = new Button("ACCOUNT");
        account_button.setMinWidth(200);
        account_button.setMinHeight(40);
        
        AccountGUI acctGUI = new AccountGUI();
        
        buy_button.setOnMouseClicked((MouseEvent e) -> {
            bp.setCenter(null);
            // TODO:
            // bp.setCenter(new BuyGUI());
        });
        
        sell_button.setOnMouseClicked((MouseEvent e) -> {
            bp.setCenter(null);
            // TODO:
            // bp.setCenter(new SellGUI());
        });
        
        account_button.setOnMouseClicked((MouseEvent e) -> {
            bp.setCenter(null);
            bp.setCenter(acctGUI);
        });
        
        // Sets the default page
        bp.setCenter(acctGUI);
        
        hb.getChildren().addAll(buy_button, sell_button, account_button);
        vb.getChildren().addAll(title, hb);
        
        bp.setTop(vb);
        Scene scene = new Scene(bp, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
 