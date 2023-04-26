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

    public void load_url(String url) throws IOException {
        WebEngine webEngine = webmap.getEngine();
        webEngine.setJavaScriptEnabled(true);
        webmap.getEngine().load(url);

    }

    public void setButtonText(String hello) throws IOException {
        lot1button.setText(hello);
    }
}