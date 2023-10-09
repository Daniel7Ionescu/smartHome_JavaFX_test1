module com.dan.smarthomev2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dan.smarthomev2 to javafx.fxml;
    exports com.dan.smarthomev2;
}