package com.parkmate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.*;
import java.io.IOException;
import java.util.Random;

public class MainController {

    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML private WebView webmap;
    @FXML private WebView parking_services;
    @FXML private Button lot1button;
    @FXML private Button lot2button;
    @FXML private Button lot3button;
    @FXML private Button lot4button;
    @FXML private Button checkinbutton;
    @FXML private Label lot_info_textdisplay;
    @FXML private Label lot_info_spacesdisplay;

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

    //lot functions
    private boolean checkinactivated = false; // if this is false, the check in button will be disabled (there is no lot selected)

    parkinglot E16 = new parkinglot("Lot E16",400); //creates parking lots
    parkinglot E19 = new parkinglot("Lot E19",300);
    parkinglot E31 = new parkinglot("Lot E31",150);
    parkinglot E34 = new parkinglot("Lot E34", 100);


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
        checkinbutton.setStyle("-fx-background-color: grey; "); //sets the check in button to grey until a lot is selected
    }

    public void handleLot1 (ActionEvent event)
    {
        lot_info_textdisplay.setText(E16.name);
        lot_info_spacesdisplay.setText(E16.occupancy + "/" + E16.capacity +" spaces occupied");
        checkinactivated = true;
        checkinbutton.setStyle("-fx-background-color: #DE4B2A; "); //sets the check in button to orange
    }
    public void handleLot2 (ActionEvent event)
    {
        lot_info_textdisplay.setText(E19.name);
        lot_info_spacesdisplay.setText(E19.occupancy + "/" + E19.capacity +" spaces occupied");
        checkinactivated = true;
        checkinbutton.setStyle("-fx-background-color: #DE4B2A; ");
    }
    public void handleLot3 (ActionEvent event)
    {
        lot_info_textdisplay.setText(E31.name);
        lot_info_spacesdisplay.setText(E31.occupancy + "/" + E31.capacity +" spaces occupied");
        checkinactivated = true;
        checkinbutton.setStyle("-fx-background-color: #DE4B2A; ");
    }
    public void handleLot4 (ActionEvent event)
    {
        lot_info_textdisplay.setText(E34.name);
        lot_info_spacesdisplay.setText(E34.occupancy + "/" + E34.capacity +" spaces occupied");
        checkinactivated = true;
        checkinbutton.setStyle("-fx-background-color: #DE4B2A; ");
    }

}