package com.example;
//import library that uses stage
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
public class SecondPage {//constructor, pass in the stage it comes from
	public SecondPage(Stage oldStage)
	{ //create the actual stage for this new stage
	Stage newStage = new Stage();
	newStage.setTitle("Lab12A - Results");
//give control to the new stage by passing the stage that is GIVING control
	newStage.initOwner(oldStage);
	Label nameText = new Label("Thank you for answering all the questions " + App.nameInput.getText());
	nameText.setStyle("-fx-font-size:20px");
	nameText.setPadding(new Insets(0,0,20,0));
	Label foodText = new Label("It is true that " + App.foodInput.getText() + " is a delicious food item.");
	foodText.setStyle("-fx-font-size:20px");
	foodText.setPadding(new Insets(0, 0, 20, 0));
	Label socialText = new Label("Well, guess you better get back on " + App.socialInput.getText() + " now.");
	socialText.setStyle("-fx-font-size:20px");
	socialText.setPadding(new Insets(0, 0, 20, 0));
	VBox maincontainer = new VBox(nameText, foodText, socialText);
	maincontainer.setPadding(new Insets(30, 30, 30, 30));
//can specify size of scene
	Scene currentScene = new Scene(maincontainer,1024,768);
	newStage.setScene(currentScene);
//creates newstage and takes control from oldstage and creates the scene and sets size
	newStage.show();
	}
}