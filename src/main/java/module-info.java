module com.example.minimalrotation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.minimalrotation to javafx.fxml;
    exports com.example.minimalrotation;
}