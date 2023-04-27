package com.parkmate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.web.*;
import java.io.IOException;
import java.util.Random;
import javafx.scene.effect.BoxBlur;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.*;
import javafx.util.Duration;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Date;

public class MainController {

    private App app;

    public void setApp(App app) {
        this.app = app;
    }


    //declaration of fxml objects
    @FXML private WebView webmap;
    @FXML private WebView parking_services;
    @FXML private Button lot1button;
    @FXML private Button lot2button;
    @FXML private Button lot3button;
    @FXML private Button lot4button;
    @FXML private Button checkinbutton;
    @FXML private Label lot_info_textdisplay;
    @FXML private Label lot_info_spacesdisplay;
    @FXML private StackPane invisiblepane;
    @FXML private Label checkintolabel;
    @FXML private Button checkoutbutton;
    @FXML private HBox mainpageitems;

    public void load_map() throws IOException {
        WebEngine webEngine = webmap.getEngine();
        webEngine.setJavaScriptEnabled(true);
        webmap.getEngine().load("https://www.google.com/maps/d/embed?mid=1PYwVoz0QVNU9oTxg9IIuuLcXNW0&ehbc=2E312F"); //loads google map
    }

    public void load_services() {
        WebEngine webEngine = parking_services.getEngine();
        webEngine.setJavaScriptEnabled(true);
        parking_services.getEngine().load("https://www.utrgv.edu/parking-and-transportation-services/parking-services/index.htm"); //loads parking services webpage
    }

    public void setButton1Text(String hello) throws IOException {
        lot1button.setText(hello);
    }
    public void setButton2Text(String hello) throws IOException {
        lot2button.setText(hello);
    }
    public void setButton3Text(String hello) throws IOException {
        lot3button.setText(hello);
    }
    public void setButton4Text(String hello) throws IOException {
        lot4button.setText(hello);
    }

    //lot functions / declarations
    private boolean checkinactivated = false; // if this is false, the check in button will be disabled (there is no lot selected)

    parkinglot E16 = new parkinglot("Lot E16",400); //creates parking lots
    parkinglot E19 = new parkinglot("Lot E19",300);
    parkinglot E31 = new parkinglot("Lot E31",150);
    parkinglot E34 = new parkinglot("Lot E34", 100);

    parkinglot currentlot;

    void setbuttonnames() { //sets the names of buttons to the names of the lots
        try {
            setButton1Text(E16.name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            setButton2Text(E19.name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            setButton3Text(E31.name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            setButton4Text(E34.name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        checkinbutton.setStyle("-fx-background-color: grey; -fx-background-radius: 20;"); //sets the check in button to grey until a lot is selected
    }

    public void handleLot1 (ActionEvent event)
    {
        lot_info_textdisplay.setText(E16.name);
        lot_info_spacesdisplay.setText(E16.occupancy + "/" + E16.capacity +" spaces occupied");
        checkinactivated = true; //activates the check in button
        checkinbutton.setStyle("-fx-background-color: #DE4B2A; -fx-background-radius: 20;"); //sets the check in button to orange
        currentlot = E16;
    }
    public void handleLot2 (ActionEvent event)
    {
        lot_info_textdisplay.setText(E19.name);
        lot_info_spacesdisplay.setText(E19.occupancy + "/" + E19.capacity +" spaces occupied");
        checkinactivated = true;
        checkinbutton.setStyle("-fx-background-color: #DE4B2A; -fx-background-radius: 20;");
        currentlot = E19;
    }
    public void handleLot3 (ActionEvent event)
    {
        lot_info_textdisplay.setText(E31.name);
        lot_info_spacesdisplay.setText(E31.occupancy + "/" + E31.capacity +" spaces occupied");
        checkinactivated = true;
        checkinbutton.setStyle("-fx-background-color: #DE4B2A; -fx-background-radius: 20;");
        currentlot = E31;
    }
    public void handleLot4 (ActionEvent event)
    {
        lot_info_textdisplay.setText(E34.name);
        lot_info_spacesdisplay.setText(E34.occupancy + "/" + E34.capacity +" spaces occupied");
        checkinactivated = true;
        checkinbutton.setStyle("-fx-background-color: #DE4B2A; -fx-background-radius: 20;");
        currentlot = E34;
    }
    String username;

    public void setUsername(String name) { //username that was entered in login screen
        username = name;
    }

    public void handleCheckIn(ActionEvent event) throws IOException {
        if (checkinactivated) {
            invisiblepane.setVisible(true);
            BoxBlur blur = new BoxBlur(10, 10, 3);
            mainpageitems.setEffect(blur);
            currentlot.occupancy = currentlot.occupancy + 1;
            checkintolabel.setText("Checked in to " + currentlot.name + " at \n" + formatTime() + "\n" + currentlot.occupancy + "/" + currentlot.capacity + " spaces occupied");
            resetTime();
        }
    }

    public void handleCheckOut(ActionEvent event) throws IOException {
        currentlot.occupancy = currentlot.occupancy - 1;
        mainpageitems.setEffect(null);
        invisiblepane.setVisible(false);
    }

    //timer functions
    private Timeline timer;
    private int secCount;

    @FXML
    private Label setLotTime;

    private String formatTime()
    {
        Date todayDate = new Date();
        DateFormat timeForm = new SimpleDateFormat("hh:mm a");
        return timeForm.format(todayDate);
    }

    public void timeInitalize() {
        timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            secCount++;

            int hrs = secCount / 3600;
            int min = (secCount % 3600) / 60;
            int sec = secCount % 60;
            setLotTime.setText("Time Elapsed: \n" + String.format("%02d:%02d:%02d", hrs, min, sec));
        }));
        timer.setCycleCount(Animation.INDEFINITE);
    }

    public void resetTime() {
        if (timer != null)
        {
            timer.stop();
        }
        timeInitalize();
        secCount = 0;
        timer.play();
    }

}