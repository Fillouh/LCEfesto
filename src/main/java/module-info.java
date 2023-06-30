module com.lcefesto {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires MaterialFX;

    opens com.lcefesto to javafx.fxml;
    exports com.lcefesto;
}