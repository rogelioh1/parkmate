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
    @FXML
    private Button lot1button;
    @FXML private WebView webmap;

    @FXML private WebView parking_services;

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

    public void setButtonText(String hello) throws IOException {
        lot1button.setText(hello);
    }
}