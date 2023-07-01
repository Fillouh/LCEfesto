module com.lcefesto {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires MaterialFX;
    requires org.reflections;

    opens com.lcefesto to javafx.fxml;
    exports com.lcefesto;
    exports com.lcefesto.ops;
    opens com.lcefesto.ops to javafx.fxml;
}