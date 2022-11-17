module com.example.boulderdashg58132 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens g58132.atlg3.boulderdash to javafx.fxml;
    exports g58132.atlg3.boulderdash;
}