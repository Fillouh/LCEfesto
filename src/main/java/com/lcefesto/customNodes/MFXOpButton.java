package com.lcefesto.customNodes;

import com.lcefesto.EfestoController;
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

    private final TextFormatter<?> textFormatter;
    public boolean singleParameter;
    private final Method method;
    private MFXParamDialog paramDialog;
    private Object[] args;

    /**
     * Given a Method, creates an MFXButton with its OnAction option set as an EventHandler that (1) applies the method
     * to the input value, parsed from the inputText TextField and (2) displays the result on the outputText TextField.
     *
     * @param method method of a class
     */
    public MFXOpButton(EfestoController efestoController, Method method) {
        super(getNameFromMethod(method.getName()), WIDTH, HEIGHT);
        this.method = method;
        setupLooks();

        singleParameter = (method.getParameterCount() == 1);
        System.out.println(method.getName() + "  " + Arrays.toString(method.getParameterTypes()));
        if (singleParameter) {
            this.textFormatter = getTypeFormatter(method.getParameters()[0].getType());

            this.setOnAction(value -> {
                /*In case the button represents a single parameter method, */
                efestoController.inputText.setEditable(true);
                String oldText = efestoController.inputText.getText();

                if (efestoController.currentButton != this) {
                    efestoController.currentButton = this;
                    efestoController.inputText.setTextFormatter(textFormatter);
                }

                efestoController.inputText.setText(oldText);
            });
        } else {
            this.textFormatter = null;

            this.setOnAction(value -> {
                if (efestoController.currentButton != this) {
                    efestoController.currentButton = this;
                }
                efestoController.inputText.setTextFormatter(null);
                efestoController.inputText.setText(getNameFromMethod(getMethod().getName()) + Arrays.toString((Arrays.stream(getMethod().getParameters()).map(p -> p.getType().getName() + " " + p.getName()).toArray())));

                this.paramDialog = new MFXParamDialog(this);
                efestoController.inputText.setText( efestoController.inputText.getText() +
                        " : " + Arrays.toString(this.getArgs()));
            });
        }
    }

    public static TextFormatter<?> getTypeFormatter(Class<?> type) {

        TextFormatter<?> textFormatter;

        if (type == int.class) {
            textFormatter = getIntTextFormatter();
        } else if (type == double.class) {
            textFormatter = getDoubleTextFormatter();
        } else {
            throw new IllegalArgumentException("Unsupported type: " + type.getName());
        }

        return textFormatter;
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

    public static TextFormatter<Integer> getIntTextFormatter() {
        String regex = "^-?\\d+$";
        Pattern validEditingState = Pattern.compile(regex);

        StringConverter<Integer> converter = new StringConverter<>() {
            @Override
            public Integer fromString(String s) {
                if (s.isEmpty() || "-".equals(s)) {
                    return 0;
                } else {
                    return Integer.valueOf(s);
                }
            }

            @Override
            public String toString(Integer integer) {
                return integer.toString();
            }
        };

        UnaryOperator<TextFormatter.Change> filter = c -> {
            String text = c.getControlNewText();
            if (validEditingState.matcher(text).matches()) {
                return c;
            } else {
                return null;
            }
        };

        return new TextFormatter<>(converter, 0, filter);
    }

    public static TextFormatter<Double> getDoubleTextFormatter() {
        String regex = "-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?([Ee][+-]?[0-9]+)?";
        Pattern validEditingState = Pattern.compile(regex);

        StringConverter<Double> converter = new StringConverter<>() {
            @Override
            public Double fromString(String s) {
                if (s.isEmpty() || "-".equals(s) || ".".equals(s) || "-.".equals(s)) {
                    return 0.0;
                } else {
                    return Double.valueOf(s);
                }
            }

            @Override
            public String toString(Double d) {
                return String.valueOf(d);
            }
        };

        UnaryOperator<TextFormatter.Change> filter = c -> {
            String text = c.getControlNewText();
            if (validEditingState.matcher(text).matches()) {
                return c;
            } else {
                return null;
            }
        };

        return new TextFormatter<>(converter, 0.0, filter);
    }

    public static TextFormatter<int[]> getIntArrayTextFormatter() {
        String regex = "^-?\\d+(,-?\\d+)*$";
        Pattern validEditingState = Pattern.compile(regex);

        StringConverter<int[]> converter = new StringConverter<>() {
            @Override
            public int[] fromString(String s) {
                if (s.isEmpty()) {
                    return new int[0];
                } else {
                    String[] parts = s.split(",");
                    return Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
                }
            }

            @Override
            public String toString(int[] ints) {
                return Arrays.toString(ints).replace("[", "").replace("]", "");
            }
        };

        UnaryOperator<TextFormatter.Change> filter = c -> {
            String text = c.getControlNewText();
            if (validEditingState.matcher(text).matches()) {
                return c;
            } else {
                return null;
            }
        };

        return new TextFormatter<>(converter, new int[0], filter);
    }

    public static TextFormatter<double[]> getDoubleArrayTextFormatter() {
        String regex = "-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?([Ee][+-]?[0-9]+)?(,-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?([Ee][+-]?[0-9]+)?)*";
        Pattern validEditingState = Pattern.compile(regex);

        StringConverter<double[]> converter = new StringConverter<>() {
            @Override
            public double[] fromString(String s) {
                if (s.isEmpty()) {
                    return new double[0];
                } else {
                    String[] parts = s.split(",");
                    return Arrays.stream(parts).mapToDouble(Double::parseDouble).toArray();
                }
            }

            @Override
            public String toString(double[] doubles) {
                return Arrays.toString(doubles).replace("[", "").replace("]", "");
            }
        };

        UnaryOperator<TextFormatter.Change> filter = c -> {
            String text = c.getControlNewText();
            if (validEditingState.matcher(text).matches()) {
                return c;
            } else {
                return null;
            }
        };

        return new TextFormatter<>(converter, new double[0], filter);
    }

    public TextFormatter<?> getTextFormatter() {
        return textFormatter;
    }

    public boolean isSingleParameter() {
        return singleParameter;
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
