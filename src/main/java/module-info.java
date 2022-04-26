module com.aetherwars.model {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.aetherwars.model to javafx.fxml;
    exports com.aetherwars.model;
}