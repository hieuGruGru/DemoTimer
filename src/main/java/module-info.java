module com.example.timerdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.timerdemo to javafx.fxml;
    exports com.example.timerdemo;
}