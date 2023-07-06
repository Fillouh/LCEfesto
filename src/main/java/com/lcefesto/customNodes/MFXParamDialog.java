package com.lcefesto.customNodes;

import com.lcefesto.EfestoController;
import javafx.geometry.Pos;

import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.GridPane;

import java.lang.reflect.Method;

import java.util.Arrays;
import java.util.List;

public class MFXParamDialog extends DialogPane {
    public static final String DIALOG_STYLE = "-fx-background-color: #A93621; -fx-border-color: transparent";
    private List<ParamTextField> textFields;

    public MFXParamDialog(MFXOpButton opButton) {
        super();
        setLooks();
        setTextFields(opButton.getMethod());

        GridPane pane = EfestoController.createGridPane(240, textFields.size() * 80, EfestoController.BACKGROUND_COLOR + "transparent", EfestoController.getRowsNumber(textFields.size(), 1), 1, 120);
        EfestoController.populateGridpane(pane, textFields);

        pane.setAlignment(Pos.CENTER);
        pane.setLayoutX(180);
        pane.setLayoutY(132);
        pane.setMinWidth(240);

        this.getChildren().add(pane);

        Dialog dialog = new Dialog<>();
        dialog.setHeight(60 + textFields.size() * 120);
        dialog.setWidth(pane.getWidth());
        dialog.getDialogPane().getScene().getWindow().setOnCloseRequest(value -> {
            opButton.setArgs(textFields.stream().map(ParamTextField::getArguments).toArray());
            dialog.close();
            System.out.println(Arrays.toString(opButton.getArgs()));
        });
        dialog.setDialogPane(this);
        dialog.showAndWait();
    }

    private void setTextFields(Method m) {
        this.textFields = Arrays.stream(m.getParameters()).map(p -> new ParamTextField(p.getName(), p.getType())).toList();
    }

    private void setLooks() {

        this.setStyle(DIALOG_STYLE);

        this.setWidth(480);
        this.setHeight(640);
    }
}
