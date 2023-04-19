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
    private static Scene scene;
    public static Label splashTitle;
    
    @Override
    public void start(Stage stage) throws IOException {
    stage.setTitle("SplashScreen");
    splashTitle = new Label("ParkMate");
    splashTitle.setStyle("-fx-font-size:24px");
    VBox justTitle = new VBox(splashTitle);
//After splash screen button
Button continueToNextScreen = new Button("Continue");
continueToNextScreen.setStyle("-fx-background-color: black; -fx-text-fill:white; -fx-font-size: 16px");
continueToNextScreen.setOnAction(e ->
{
new SecondPage(stage);
});
//control the position via padding of button; enclose it in its own box
VBox nextScreenBox = new VBox(continueToNextScreen);
// nextScreenBox.setPadding(new Insets(0, 0, 0, 300));
VBox layoutContainer = new VBox(continueToNextScreen);
scene = new Scene(layoutContainer, 800, 600);
stage.setScene(scene);
stage.show();
}
public static void main(String[] args) {
launch();
}
}