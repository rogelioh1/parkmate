package com.parkmate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.*;

public class App extends Application {
    private static Stage stage;
    private static Scene scene2; // home screen, user has already logged in in scene 1
    private LoginController loginController;
    private MainController mainController;
    public String username;

    @Override
    //start method takes
    public void start(Stage mainStage) throws IOException {
        stage = mainStage;
        stage.getIcons().add(new Image("file:src/main/resources/com/parkmate/parking-symbol.png"));
        showScene1();
    }

    public void login(String username) {
        this.username = username;
    }

    //scene 1, default, log in screen
    public void showScene1() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        loginController = loader.getController();
        loginController.setApp(this);
        Scene scene = new Scene(root, 488, 750);
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
        mainController.setUsername(username);
        mainController.setbuttonnames();
        mainController.load_map();
        mainController.load_services();
        scene2 = new Scene(root, 488, 750);
        stage.setTitle("ParkMate");
        stage.setScene(scene2);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}