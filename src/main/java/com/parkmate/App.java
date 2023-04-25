package com.parkmate;

import javafx.application.Application;
import javafx.event.*;
import javafx.fxml.FXML;
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

    @FXML private TextField username_textfield; //login page
    @FXML public Button lot1button;
    @FXML public Button lot2button;

    @FXML
    private void openmainmenu(ActionEvent event) throws IOException { //login button opens main menu only if username is not empty
        event.consume();
        if (username_textfield.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Username cannot be empty");
            alert.showAndWait();
        }
        else {
            showScene2();
        }
    }

    // public static Label loginPage;
    @Override
    //start method takes
    public void start(Stage mainStage) throws IOException {
        stage = mainStage;
        showScene1();
    }

    //scene 1, default, log in screen
    private void showScene1() throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource("login.fxml")); //loads the scenebuilder file, use scenebuilder if you want to edit the layout
        Scene scene = new Scene(root, 480, 720);
        root.requestFocus();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    public void showScene2() throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource("mainpage.fxml"));
        scene2 = new Scene(root, 480, 720);
        stage.setTitle("ParkMate");
        stage.setScene(scene2);
        stage.show();
    }

    private void showScene3() // show lots
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
    //    private void showScene4() //show lots and zones
//    {
//
//        Button testo1 = new Button();
//        VBox lotAndZonesScreen = new VBox(testo1);
//        scene4 = new Scene(lotAndZonesScreen);
//
//
//    }
    public static void main(String[] args) {
        launch();
    }
}