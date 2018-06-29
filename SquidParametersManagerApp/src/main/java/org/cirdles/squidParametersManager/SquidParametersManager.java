/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cirdles.squidParametersManager;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;



/**
 *
 * @author ryanb
 */
public class SquidParametersManager extends Application{

    public static Window primaryStageWindow;
    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;

        primaryStage.setMinHeight(700);
        primaryStage.setMinWidth(800);
        
        Parent root = new AnchorPane();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("SquidParametersManagerGUI.fxml")));
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Squid Parameters Manager");

        primaryStageWindow = primaryStage.getScene().getWindow();

        primaryStage.setOnCloseRequest((WindowEvent e) -> {
            Platform.exit();
            System.exit(0);
        });
        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
