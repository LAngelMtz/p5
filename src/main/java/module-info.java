module com.example.p5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.p5 to javafx.fxml;
    exports com.example.p5;
}