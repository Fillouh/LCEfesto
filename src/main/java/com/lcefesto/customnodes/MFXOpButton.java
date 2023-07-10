package com.lcefesto.customnodes;

import com.lcefesto.EfestoController;
import com.lcefesto.utility.TextFormatterGenerator;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.enums.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.lang.reflect.Method;
import java.util.Arrays;

import static com.lcefesto.EfestoController.DEEP_BLACK;
import static com.lcefesto.EfestoController.LIGHT_GRAY;

public class MFXOpButton extends MFXButton {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 120;
    public static final String FONT_SIZE = "18";
    private final EfestoController controller;

    private final String name;
    private final TextFormatter<?> textFormatter;
    private final Method method;

    /**
     * Given its Controller and a Method, creates an MFXButton associated with the method,
     * displaying its name and used by the controller class to execute operations on the input.
     * Each MFXOpButton sets a different textFormatter, depending on the method's signature.
     *
     * @param method method of a class
     */
    public MFXOpButton(EfestoController efestoController, Method method) {
        super(getNameFromMethod(method.getName()), WIDTH, HEIGHT);
        this.name = getNameFromMethod(method.getName());
        this.method = method;
        this.controller = efestoController;
        this.textFormatter = TextFormatterGenerator.createTextFormatter(method);
        this.setOnAction(value -> {
            TextField inputText = controller.getInputText();
            TextField outputText = controller.getOutputText();
            String oldText = inputText.getText();

            if (controller.getCurrentOpButton() != this) {
                if (controller.getCurrentOpButton() != null) {
                    controller.getCurrentOpButton().setSelected(false);
                }
                this.setSelected(true);
                controller.setCurrentOpButton(this);
                inputText.setTextFormatter(textFormatter);
            }

            inputText.setEditable(true);
            inputText.setPromptText(this.name + Arrays.stream(method.getParameters()).map(p -> p.getType().getName() + " " + p.getName()).toList().toString().replace("[", "(").replace("]", ")"));
            outputText.setPromptText("Returns: " + method.getReturnType().getName());

            if (method.getParameterCount() == 1) {
                inputText.setText(oldText);
            }
            else {
                inputText.setText("");
                outputText.setPromptText("Returns: " + method.getReturnType().getName());
            }
        });

        setupLooks();
    }

    /** Simple method to set up the opButton's look. */
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
    static String getNameFromMethod(String methodName) {
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

    /* Getters and Setters */

    public Method getMethod() {
        return method;
    }

    public Object[] getArgs() {
        TextField inputText = this.controller.getInputText();
        if (this.textFormatter.getValueConverter().fromString(inputText.getText()) instanceof Object[]) {
            return (Object[]) this.textFormatter.getValueConverter().fromString(inputText.getText());
        } else {
            return new Object[]{this.textFormatter.getValueConverter().fromString(inputText.getText())};
        }
    }

    public String getName() {
        return name;
    }

    public void setSelected(boolean isSelected) {
        if (isSelected) {
            this.setStyle("-fx-background-color: " + DEEP_BLACK + "; -fx-background" + "-radius:" + " 20; "+ "-fx" +
                    "-text-fill: " + LIGHT_GRAY + "; -fx-alignment: CENTER; -fx-font-size: " + FONT_SIZE + ";" + "-fx-border-color: #C74F39; -fx-border-radius: 20;" );
        }
        else {
            this.setStyle("-fx-background-color: " + DEEP_BLACK + "; -fx-background-radius: 20; -fx-text-fill: " + LIGHT_GRAY + "; -fx-alignment: CENTER; -fx-font-size: " + FONT_SIZE);
        }
    }
}