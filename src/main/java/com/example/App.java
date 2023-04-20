//main controller page, extends to other pages

package com.example;

import javafx.application.Application;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.IOException;
public class App extends Application {
    private static Stage stage;
    private static Scene scene1; //login scene
    private static Scene scene2; // homescreen, user has already logged in in scene 1
    private static Scene scene3;
    private static Scene scene4;
    private static Scene scene5;
    // public static Label loginPage;
    @Override
    //start method takes 
    public void start(Stage mainStage)
    {
        
        stage = mainStage;
        mainStage.setTitle("Login Screen");
        showScene1();
    }
    
    
    //scence 1, default, log in screen
    private void showScene1()
    {
        Button loginBtn = new Button("LOG IN"); //will listen for click and then go to scene 2
        loginBtn.setOnAction(e-> showScene2()); //scnence 2 will be homescreen 
        VBox screen1 = new VBox(loginBtn);
        scene1 = new Scene(screen1, 400, 400);
        stage.setScene(scene1);
        stage.show();
        
    }
    private void showScene2()
    {
        Button checkAvailLotsBtn = new Button("Check available lots");
        Button signOutBtn = new Button("SIGN OUT");
         VBox screen2 = new VBox(signOutBtn, checkAvailLotsBtn);
        scene2 = new Scene(screen2, 800, 400);
        stage.setScene(scene2);
        stage.show();
    }
public static void main(String[] args) {
launch();
}
}