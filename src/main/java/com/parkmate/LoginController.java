package com.parkmate;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;

import java.io.IOException;

public class LoginController {
    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private TextField username_textfield;

    public String getUsername() {
        return username_textfield.getText();
    }

    @FXML
    public void buttonPressed(KeyEvent e) throws IOException { //enter key can be used to log in instead of sign in button
        if(e.getCode().toString().equals("ENTER"))
        {
            openmainmenu(new ActionEvent());
        }
    }

    public void openmainmenu(ActionEvent event) throws IOException {
        event.consume();

        String username = username_textfield.getText();

        if (username.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Username cannot be empty");
            alert.showAndWait();
        }
        else if (username.length() < 5) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Username must be at least 5 characters long");
            alert.showAndWait();
        }
        else if (!username.matches("^(?=.*[0-9])[a-zA-Z0-9]+$"))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Username can only contain letters and numbers");
            alert.showAndWait();
        }
        else {
            app.login(username);
            app.showScene2();
 //sets username for use in next scene
        }
    }
}
