module com.example.boulderdashg58132 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.boulderdashg58132 to javafx.fxml;
    exports com.example.boulderdashg58132;
}