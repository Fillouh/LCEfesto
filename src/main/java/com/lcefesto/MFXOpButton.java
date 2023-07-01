package com.lcefesto;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.enums.ButtonType;
import javafx.scene.control.TextField;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.lcefesto.EfestoController.DEEP_BLACK;
import static com.lcefesto.EfestoController.LIGHT_GRAY;

public class MFXOpButton extends MFXButton {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 120;
    public static final String FONT_SIZE = "18";

    /**
     * Given a Method, creates a MFXButton with its OnAction option set as an EventHandler that (1) applies the method
     * to the input value, parsed from the inputText TextField and (2) displays the result on the outputText TextField.
     *
     * @param method method of a class
     *
     * @return a MFXButton
     */

    public MFXOpButton(String methodName, Method method, TextField inputText, TextField outputText) {
        super(getNameFromMethod(methodName), WIDTH, HEIGHT);
        setupLooks();
        setOnActionMethod(method, inputText, outputText);
    }

    private void setOnActionMethod(Method method, TextField inputText, TextField outputText) {
        this.setOnAction(event -> {
            try {
                outputText.setText(method.invoke(null, Double.parseDouble(inputText.getText())).toString());
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void setupLooks() {
        setButtonType(ButtonType.RAISED);
        setPrefWidth(WIDTH);
        setPrefHeight(HEIGHT);
        setStyle("-fx-background-color: " + DEEP_BLACK + "; -fx-background-radius: 20; -fx-text-fill: " + LIGHT_GRAY + "; -fx-alignment: CENTER; -fx-font-size: " + FONT_SIZE);
    }

    /**
     * Method that, given a camelcase-formatted String, returns a
     * human-readable version of the String.
     *
     * @param methodName name of the method
     *
     * @return the human-readable version of the method as String
     */
    private static String getNameFromMethod(String methodName) {
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
