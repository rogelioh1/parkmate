package com.parkmate;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.*;
import java.io.IOException;

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
    @FXML private Button lot_info_textdisplay;
    @FXML private Button lot_info_spacesdisplay;

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
}