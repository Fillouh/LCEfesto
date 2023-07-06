package com.lcefesto.customnodes;

import com.lcefesto.EfestoController;
import com.lcefesto.utility.TextFormatterGenerator;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.enums.ButtonType;

import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import static com.lcefesto.EfestoController.DEEP_BLACK;
import static com.lcefesto.EfestoController.LIGHT_GRAY;

public class MFXOpButton extends MFXButton {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 120;
    public static final String FONT_SIZE = "18";
    private final EfestoController controller;
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
        this.method = method;
        this.controller = efestoController;
        this.textFormatter = TextFormatterGenerator.createTextFormatter(method);
        this.setOnAction(value -> {
            controller.getInputText().setEditable(true);
            String oldText = controller.getInputText().getText();

            if (controller.getCurrentButton() != this) {
                controller.setCurrentButton(this);
                controller.getInputText().setTextFormatter(textFormatter);
            }

            if(method.getParameterCount() == 1){
                controller.getInputText().setText(oldText);
            }
        });
        /*if (singleParameter) {
            this.textFormatter = getTypeFormatter(method.getParameters()[0].getType());

            this.setOnAction(value -> {

                efestoController.getInputText().setEditable(true);
                String oldText = efestoController.getInputText().getText();

                if (efestoController.currentButton != this) {
                    efestoController.currentButton = this;
                    efestoController.getInputText().setTextFormatter(textFormatter);
                }

                efestoController.getInputText().setText(oldText);
            });
        } else {
            this.textFormatter = getTypeFormatter(method.getParameters()[0].getType());
            this.setOnAction(value -> {
                if (efestoController.currentButton != this) {
                    efestoController.currentButton = this;
                }
                efestoController.getInputText().setTextFormatter(null);
                efestoController.getInputText().setText(getNameFromMethod(getMethod().getName()) + Arrays.toString((Arrays.stream(getMethod().getParameters()).map(p -> p.getType().getName() + " " + p.getName()).toArray())));

                this.paramDialog = new MFXParamDialog(this);
                efestoController.getInputText().setText( efestoController.getInputText().getText() +
                        " : " + Arrays.toString(this.getArgs()));

            });
        }*/
        setupLooks();
    }

    /** Simple method to set up the opButton's look.*/
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
    public TextFormatter<?> getTextFormatter() {
        return textFormatter;
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getArgs() {
        if( this.textFormatter.getValueConverter().fromString(this.controller.getInputText().getText()) instanceof Object[]) {
            return (Object[]) this.textFormatter.getValueConverter().fromString(this.controller.getInputText().getText());
        }else{
            return new Object[]{this.textFormatter.getValueConverter().fromString(this.controller.getInputText().getText())};
        }
    }

    public void setArgs(Object[] args) {
    }
}
