package com.lcefesto;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.enums.ButtonType;
import javafx.scene.control.TextFormatter;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.StringConverter;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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

    /** Constructor of MFXPageButton class. Given a class consisting
     * only of static methods, the constructor instantiates an MFXButton
     * object with a specific style, the class's name as title, and its
     * methods enumerated as List<Method> methodList.
     *
     * @param opClass the static method container class
     * */
    public MFXPageButton(Class<?> opClass) {

        super(opClass.getSimpleName(), PAGE_BUTTON_WIDTH, PAGE_BUTTON_HEIGHT);
        this.setMethodList(opClass);
        this.setupLooks();
    }

    /** Sets up the Default Looks for an MFXPageButton.*/
    private void setupLooks() {
        this.setButtonType(ButtonType.RAISED);
        this.setRippleAnimateShadow(true);
        this.setRippleBackgroundOpacity(0.05);
        this.setRippleColor(Paint.valueOf(BONE));
        this.setRippleRadius(5.0);
        this.setFont(Font.font("Arial", 24));
        this.setStyle(PAGE_BUTTON_STYLE);
    }

    /** Creates an alphabetically ordered list of methods starting
     * from the list of declared methods of the passed class.
     * */
    public void setMethodList(Class<?> opClass) {
        this.methodList =
                new ArrayList<>(Arrays.stream(opClass.getDeclaredMethods())
                        .filter(m -> Modifier.isStatic(m.getModifiers()))
                        .sorted((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName()))
                        .toList());
    }

    public List<Method> getMethodList() {
        return methodList;
    }
}
