package com.lcefesto;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXScrollPane;
import io.github.palexdev.materialfx.enums.ButtonType;
import javafx.fxml.FXML;
import javafx.geometry.HPos;

import javafx.geometry.VPos;
import javafx.scene.control.TextField;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.GridPane;

import javafx.scene.paint.Paint;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class EfestoController {
    public static final int NUM_COLS = 4;
    public static final int BUTTON_PREF_WIDTH = 300;
    public static final int BUTTON_PREF_HEIGHT = 120;
    public static final String DEEP_BLACK = "#111111";
    public static final String LIGHT_GRAY = "#d3d3d3";
    public static final String BUTTON_FONT_SIZE = "24";
    public static final String BLACK = "#292929";
    public static final int BUTTON_HEIGHT = 180;
    @FXML
    private MFXButton MathButton;

    private boolean MathSwitch = false;
    @FXML
    private MFXButton StatisticsButton;
    private boolean StatisticsSwitch = false;
    @FXML
    private MFXButton ConverterButton;
    private boolean ConverterSwitch = false;
    @FXML
    private MFXButton GraphsButton;
    private boolean GraphsSwitch = false;
    @FXML
    private MFXScrollPane scrollPane;
    @FXML
    private GridPane gridPane;
    @FXML
    private TextField inputText;
    @FXML
    private TextField outputText;

    @FXML
    public void initialize() {
        scrollPane.setOpacity(0);
        scrollPane.setTrackColor(Paint.valueOf(DEEP_BLACK));
        scrollPane.setThumbColor(Paint.valueOf(BLACK));

        inputText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                inputText.setText(newValue.replaceAll("[^\\d.]", ""));
            }
        });
    }

    @FXML
    protected void onMathButtonClick() {
        if (MathSwitch) {
            this.MathSwitch = false;
            this.scrollPane.setOpacity(0);
        } else {
            this.MathSwitch = true;
            //allocateButtons();
        }
    }

    @FXML
    protected void onStatButtonClick() {

        if (StatisticsSwitch) {
            this.StatisticsSwitch = false;
            this.scrollPane.setOpacity(0);
        } else {
            this.StatisticsSwitch = true;
            //allocateButtons();
        }
    }

    @FXML
    protected void onConvButtonClick() {

        if (ConverterSwitch) {
            this.ConverterSwitch = false;
            this.scrollPane.setOpacity(0);
        } else {
            this.ConverterSwitch = true;
            this.allocateButtons(Arrays.stream(Measure.class.getDeclaredMethods()).toList());
        }
    }

    @FXML
    protected void onGraphsButtonClick() {

        if (GraphsSwitch) {
            this.GraphsSwitch = false;
            this.scrollPane.setOpacity(0);
        } else {
            this.GraphsSwitch = true;
            //allocateButtons();
        }
    }

    private void setScrollPane() {
        this.scrollPane.setOpacity(1);
        this.scrollPane.setStyle("-fx-background-color: transparent");
    }

    private void setGridPane(final int numRows) {
        this.gridPane = new GridPane();
        this.gridPane.setPrefWidth(1430);
        this.gridPane.setPrefHeight(810);
        this.gridPane.setStyle("-fx-background-color: " + BLACK);

        for (int i = 0; i < NUM_COLS; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / NUM_COLS);
            this.gridPane.getColumnConstraints().add(colConst);
        }

        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setMinHeight(BUTTON_HEIGHT);
            rowConst.setPrefHeight(BUTTON_HEIGHT);
            rowConst.setMaxHeight(BUTTON_HEIGHT);
            this.gridPane.getRowConstraints().add(rowConst);
        }
    }

    private int getRowsNumber(List<Method> methodsList) {
        return (int) Math.ceil((double) methodsList.toArray().length / NUM_COLS);
    }

    private MFXButton setMFXButton(Method method) {

        MFXButton button = new MFXButton(methodButtonName(method.getName()));

        button.setButtonType(ButtonType.RAISED);
        button.setPrefWidth(BUTTON_PREF_WIDTH);
        button.setPrefHeight(BUTTON_PREF_HEIGHT);
        button.setStyle("-fx-background-color: " + DEEP_BLACK + "; -fx-background-radius: 20; -fx-text-fill: " + LIGHT_GRAY + "; -fx-alignment: CENTER; -fx-font-size: " + BUTTON_FONT_SIZE);

        button.setOnAction(event -> {
            try {
                outputText.setText(method.invoke(null, Double.parseDouble(inputText.getText())).toString());
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

        return button;
    }

    private boolean isOutOfBounds(List<Method> methodList, int index) {
        return methodList.toArray().length <= index;
    }

    private void allocateButtons(List<Method> methodsList) {
        this.setScrollPane();
        final int numRows = getRowsNumber(methodsList);
        this.setGridPane(numRows);

        for (int row = 0; row < numRows; ++row) {
            for (int col = 0; col < NUM_COLS && !isOutOfBounds(methodsList, row * NUM_COLS + col); ++col) {

                MFXButton button = setMFXButton(methodsList.get(row * NUM_COLS + col));

                GridPane.setHalignment(button, HPos.CENTER);
                GridPane.setValignment(button, VPos.CENTER);

                gridPane.add(button, col, row);
            }
        }

        scrollPane.setContent(this.gridPane);
    }

    /**
     * Method that, given a camelcase-formatted String, returns a
     * human-readable version of the String.
     *
     * @param methodName name of the method
     *
     * @return the human-readable version of the method as String
     */
    private static String methodButtonName(String methodName) {
        StringBuilder buttonName = new StringBuilder();

        /*
            The new String contains all words of the input String,
            but all uppercase letters are preceded by a whitespace,
            and the first letter must be upper case.
         */

        for (int i = 0; i < methodName.length(); ++i) {

            Character c = methodName.charAt(i);

            if (Character.isUpperCase(c) && (i + 1 < methodName.length() && i > 0)) {
                if (Character.isLowerCase(methodName.charAt(i + 1)) || !Character.isUpperCase(methodName.charAt(i - 1))) {
                    buttonName.append(" ");
                }
            } else if (i == 0 && Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            }

            buttonName.append(c);
        }

        return buttonName.toString();
    }
}