package com.parkmate;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class LoginController {

    private App app;

    public void setApp(App app) {
        this.app = app;
    }
    @FXML
    private TextField username_textfield;

    public void openmainmenu(ActionEvent event) throws IOException {
        event.consume();

        String username = username_textfield.getText();

        if (username.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Username cannot be empty");
            alert.showAndWait();
        } else {
            app.showScene2();
        }
    }
}
