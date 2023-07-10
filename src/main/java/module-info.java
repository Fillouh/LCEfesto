module com.lcefesto {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires MaterialFX;
    requires org.reflections;

    exports com.lcefesto;
    exports com.lcefesto.ops;
    //exports com.lcefesto.customnodes;
    exports com.lcefesto.utility;

    opens com.lcefesto to javafx.fxml;
    opens com.lcefesto.ops to javafx.fxml;
    opens com.lcefesto.customnodes to javafx.fxml;
    opens com.lcefesto.utility to javafx.fxml;
}