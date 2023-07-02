package com.lcefesto;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.enums.ButtonType;
import javafx.scene.control.TextFormatter;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.StringConverter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class MFXPageButton extends MFXButton {
    public static final int PAGE_BUTTON_WIDTH = 320;
    public static final int PAGE_BUTTON_HEIGHT = 60;
    public static final String PAGE_BUTTON_STYLE = "-fx-background-color: #C74F39; -fx-background-radius: 24; -fx-text-fill: #f7f5ed; -mfx-auto-clip: true;";
    public static final String BONE = "#f2f1eb";
    private List<Method> methodList;
    private String matchRegex;
    private String correctRegex;

    private TextFormatter textFormatter;

    public MFXPageButton(String text, Class opClass, String regex) {
        super(text, PAGE_BUTTON_WIDTH, PAGE_BUTTON_HEIGHT);
        this.setMethodList(opClass);
        this.setMatchRegex(matchRegex);
        this.setCorrectRegex(correctRegex);
        this.setupLooks();
        setTextFormatter(regex);
    }

    private void setTextFormatter(String regex){

        Pattern validEditingState = Pattern.compile(regex);

        UnaryOperator<TextFormatter.Change> filter = c -> {
            String text = c.getControlNewText();
            if (validEditingState.matcher(text).matches()) {
                return c;
            } else {
                return null;
            }
        };

        StringConverter<Double> converter = new StringConverter<Double>() {

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
                return d.toString();
            }
        };

        textFormatter = new TextFormatter<>(converter, 0.0, filter);
    }

    public TextFormatter getTextFormatter() {
        return textFormatter;
    }
    private void setupLooks() {
        this.setButtonType(ButtonType.RAISED);
        this.setRippleAnimateShadow(true);
        this.setRippleBackgroundOpacity(0.05);
        this.setRippleColor(Paint.valueOf(BONE));
        this.setRippleRadius(5.0);
        this.setFont(Font.font("Arial", 24));
        this.setStyle(PAGE_BUTTON_STYLE);
    }

    public void setMethodList(Class opClass) {
        List<Method> methods = new ArrayList<>(Arrays.stream(opClass.getDeclaredMethods()).toList());
        methods.sort((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName()));
        this.methodList = methods;
    }

    public List<Method> getMethodList() {
        return methodList;
    }

    public String getMatchRegex() {
        return matchRegex;
    }

    public void setMatchRegex(String matchRegex) {
        this.matchRegex = matchRegex;
    }

    public String getCorrectRegex() {
        return correctRegex;
    }

    public void setCorrectRegex(String correctRegex) {
        this.correctRegex = correctRegex;
    }


}
