package com.lcefesto;

import io.github.palexdev.materialfx.dialogs.MFXGenericDialog;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class MFXParamDialog extends MFXGenericDialog {
    public static final String DIALOG_STYLE = "-fx-background-color: #A93621; -fx-border-color: transparent";
    private List<Node> textFields;

    public MFXParamDialog(Method m) {
        super();
        setLooks();
        setTextFields(m);
        GridPane pane = EfestoController.createGridPane((int) this.getWidth(),(int)  this.getHeight(),
                EfestoController.BACKGROUND_COLOR +
                "transparent", EfestoController.getRowsNumber(textFields.size(), 1), 1, 48);
        EfestoController.populateGridpane(pane, textFields);
    }

    private void setTextFields(Method m){
        Arrays.stream(m.getParameters()).map(p -> new ParamTextField(p.getName(), p.getType()));
    }
    private void setLooks(){
        this.setAlwaysOnTop(true);
        this.setShowMinimize(false);
        this.setShowAlwaysOnTop(false);
        this.setStyle(DIALOG_STYLE);
    }


}
