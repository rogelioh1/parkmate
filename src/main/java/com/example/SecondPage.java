//2 login page
//features a text field with a button that proceeds to next page

package com.example;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
public class SecondPage {
	public SecondPage(Stage oldStage)
	{
	Stage newStage = new Stage();
	newStage.setTitle("Login Page");
	newStage.initOwner(oldStage);
	Label utrgvLogo = new Label("UTRGV");
	VBox maincontainer = new VBox(utrgvLogo);
	maincontainer.setPadding(new Insets(30, 30, 30, 30));
	Scene currentScene = new Scene(maincontainer,1024,768);
	newStage.setScene(currentScene);
	newStage.show();
	}
}