package com.parkmate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.*;

public class App extends Application {
    private static Stage stage;
    private static Scene scene1; //login scene
    private static Scene scene2; // homescreen, user has already logged in in scene 1
    private static Scene scene3;
    private static Scene scene4;
    private static Scene scene5;
    private LoginController loginController;
    private MainController mainController;

    @Override
    //start method takes
    public void start(Stage mainStage) throws IOException {
        stage = mainStage;
        showScene1();
    }

    //scene 1, default, log in screen
    public void showScene1() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        loginController = loader.getController();
        loginController.setApp(this);

        Scene scene = new Scene(root, 480, 720);
        root.requestFocus();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public void showScene2() throws IOException {
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("mainpage.fxml"));
        Parent root = loader2.load();
        mainController = loader2.getController();
        mainController.setApp(this);
        mainController.setButtonText("Hello World");  //this is how you would edit an fxml variable in this main file
        mainController.load_url("https://www.google.com");

        scene2 = new Scene(root, 480, 720);
        stage.setTitle("ParkMate");
        stage.setScene(scene2);
        stage.show();
    }

    public void showScene3() // show lots
    {
//        availLotsHeader.setText("Available Slots:"); //center this
        String[] lots = {"Lot 1", "Lot 2", "Lot 3", "Lot 4", "Lot5"};
        VBox lotBtnContainer = new VBox();
        for (String lot : lots) {
            Button lotBtn = new Button(lot);
//            lotBtn.setOnAction(e -> handleButtonClick(lotBtn));
            lotBtnContainer.getChildren().add(lotBtn);
        }
        Button testo = new Button();
        testo.setText("Total Slots: 500 \nSlots available: " + parkinglot.getTotalSlots());
        VBox parkingLotScreen = new VBox(testo);
        scene3 = new Scene(parkingLotScreen, 800, 400);
        stage.setScene(scene3);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}