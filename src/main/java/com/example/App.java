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
    public static Label nameText;
    public static Label foodText;
    public static Label socialText;
    public static TextField nameInput = new TextField();
    public static TextField foodInput = new TextField();
    public static TextField socialInput = new TextField();
    
    @Override
    public void start(Stage stage) throws IOException {
    stage.setTitle("Lab12A");
//label 1
    nameText = new Label("What is your name?");
    nameText.setStyle("-fx-font-size:18px");
VBox nameStuff = new VBox(nameText, nameInput);
nameStuff.setPadding(new Insets(0, 0, 20, 0));//label 2
foodText = new Label("What is your favorite food item?");
foodText.setStyle("-fx-font-size:18px");
VBox foodStuff = new VBox(foodText, foodInput);
foodStuff.setPadding(new Insets(0, 0, 20, 0));//label 3
socialText = new Label("What is your favorite social media platform?");
socialText.setStyle("-fx-font-size:18px");
VBox socialStuff = new VBox(socialText, socialInput);
socialStuff.setPadding(new Insets(0, 0, 30, 0));
//SUBMIT BUTTOn
Button submit = new Button("Submit");
submit.setStyle("-fx-background-color: black; -fx-text-fill:white; -fx-font-size: 16px");
submit.setOnAction(e ->
{
new SecondPage(stage);
});
VBox justButton = new VBox(submit);
justButton.setPadding(new Insets(0, 0, 0, 300));
// justButton.setSpacing(90);
VBox layoutContainer = new VBox(nameStuff,foodStuff, socialStuff, justButton);
layoutContainer.setPadding(new Insets(30, 10, 10, 30));
// justButton.setPadding(new Insets(20, 40, 40 ,0));
// submit.setPadding(new Insets(70, 0, 0, 0));
// submit.setAlignment(Pos.CENTER);
scene = new Scene(layoutContainer, 800, 600);
stage.setScene(scene);
stage.show();
}
public static void main(String[] args) {
launch();
}
}