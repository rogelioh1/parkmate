module com.parkm8 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.parkmate to javafx.fxml;
    exports com.parkmate;
}
