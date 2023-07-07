package com.lcefesto.customnodes;

import com.lcefesto.EfestoController;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.enums.ButtonType;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.lcefesto.EfestoController.*;

public class MFXPageButton extends MFXButton {
    public static final int PAGE_BUTTON_WIDTH = 320;
    public static final int PAGE_BUTTON_HEIGHT = 60;
    public static final String PAGE_BUTTON_STYLE = "-fx-background-color: #C74F39; -fx-background-radius: 24; -fx-text-fill: #f7f5ed; -mfx-auto-clip: true;";
    public static final String BONE = "#f2f1eb";
    private List<Method> methodList;

    /**
     * Constructor of MFXPageButton class. Given a class consisting
     * only of static methods, the constructor instantiates an MFXButton
     * object with a specific style, the class's name as title, and its
     * methods enumerated as List<Method> methodList.
     *
     * @param opClass the static method container class
     */
    public MFXPageButton(EfestoController controller, Class<?> opClass) {

        super(opClass.getSimpleName(), PAGE_BUTTON_WIDTH, PAGE_BUTTON_HEIGHT);
        this.setMethodList(opClass);
        this.setupLooks();
        this.getStyleClass().add("toggle");

        this.setOnAction(event -> {
            // Create the left animation
            TranslateTransition leftAnimation = new TranslateTransition(Duration.seconds(0.3),this);
            leftAnimation.setFromX(0);
            leftAnimation.setToX(-40);
            leftAnimation.setCycleCount(2);
            leftAnimation.setAutoReverse(true);
            leftAnimation.setInterpolator(Interpolator.SPLINE(0.1, 0.9, 0.3, 1.0));

            // Create the right animation
            TranslateTransition rightAnimation = new TranslateTransition(Duration.seconds(0.3),this);
            rightAnimation.setFromX(0);
            rightAnimation.setToX(40);
            rightAnimation.setCycleCount(2);
            rightAnimation.setAutoReverse(true);
            rightAnimation.setInterpolator(Interpolator.SPLINE(0.1, 0.9, 0.3, 1.0));

            if (leftAnimation.getStatus() != javafx.animation.Animation.Status.RUNNING) {
                leftAnimation.play();
            }
            controller.showScrollPane();
            GridPane pane = createGridPane(OPS_GRID_WIDTH, OPS_GRID_HEIGHT, BACKGROUND_COLOR + BLACK + ";", getRowsNumber(this.getMethodList().size(), OPS_GRID_COLS), OPS_GRID_COLS, MFXOpButton.HEIGHT + 60);
            List<Node> buttonList = this.getMethodList().stream().map(m -> new MFXOpButton(controller, m)).collect(Collectors.toList());
            populateGridpane(pane, buttonList);
            controller.getScrollPane().setContent(pane);
        });
    }

    /** Sets up the Default Looks for an MFXPageButton. */
    private void setupLooks() {
        this.setButtonType(ButtonType.RAISED);
        this.setRippleAnimateShadow(true);
        this.setRippleBackgroundOpacity(0.05);
        this.setRippleColor(Paint.valueOf(BONE));
        this.setRippleRadius(5.0);
        this.setFont(Font.font("Arial", 24));
        this.setStyle(PAGE_BUTTON_STYLE);
        GridPane.setHalignment(this, HPos.CENTER);
        GridPane.setValignment(this, VPos.CENTER);
    }

    /**
     * Creates an alphabetically ordered list of methods starting
     * from the list of declared methods of the passed class.
     *
     * @param opClass class meeting requirements
     */
    public void setMethodList(Class<?> opClass) {
        this.methodList = new ArrayList<>(Arrays.stream(opClass.getDeclaredMethods()).filter(m -> Modifier.isStatic(m.getModifiers())).sorted((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName())).toList());
    }

    public List<Method> getMethodList() {
        return methodList;
    }
}
