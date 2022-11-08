module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens controlerView to javafx.fxml;
    exports controlerView;
}