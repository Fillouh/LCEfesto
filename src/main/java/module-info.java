module com.lcefesto.lcefesto {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.lcefesto to javafx.fxml;
    exports com.lcefesto;
}