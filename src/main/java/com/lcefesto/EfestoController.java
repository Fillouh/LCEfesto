package com.lcefesto;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXScrollPane;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.geometry.HPos;

import javafx.geometry.VPos;
import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EfestoController {
    public static final int OPS_GRID_COLS = 4;
    public static final int OPS_GRID_WIDTH = 1430;
    public static final int OPS_GRID_HEIGHT = 810;
    public static final String BACKGROUND_COLOR = "-fx-background-color:";
    public static final int PAGES_GRID_COLS = 1;
    public static final int PAGES_GRID_WIDTH = 480;
    public static final int PAGES_GRID_HEIGHT = 640;

    public static final String DEEP_BLACK = "#111111";
    public static final String LIGHT_GRAY = "#d3d3d3";
    public static final String BLACK = "#292929";

    public static final String NUM_MATCH_REGEX = "[0-9]{1,13}(\\.[0-9]*)?";
    public static final String NUM_CORRECT_REGEX = "[^\\d.]";

    @FXML
    private MFXScrollPane scrollPane;
    @FXML
    private AnchorPane anchorPane;
    private GridPane gridPane;
    @FXML
    private TextField inputText;
    @FXML
    private TextField outputText;
    private ChangeListener changeListener;

    public void initialize() {
        List<MFXButton> list = new ArrayList<>();
        try {
            List<Class<?>> opClasses = new ArrayList<>(OpsPackage.findAllClassesUsingGoogleGuice("com.lcefesto.ops"));

            for (Class<?> c : opClasses) {
                list.add(createPageButton(c));
            }

            GridPane pagesGridPane = createGridPane(PAGES_GRID_WIDTH, PAGES_GRID_HEIGHT, BACKGROUND_COLOR +
                    "transparent;", getRowsNumber(opClasses.size(), PAGES_GRID_COLS), PAGES_GRID_COLS,
                    MFXPageButton.PAGE_BUTTON_WIDTH, MFXPageButton.PAGE_BUTTON_HEIGHT + 60);
            populateGridpane(pagesGridPane, list);

            anchorPane.getChildren().setAll(pagesGridPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setListener(String matchRegex, String correctRegex) {

        this.inputText.setEditable(true);

        if (changeListener != null) {
            inputText.textProperty().removeListener(changeListener);
        }

        changeListener = (observable, oldValue, newValue) -> {
            if (!((String) newValue).matches(matchRegex)) {
                inputText.setText(((String) newValue).replaceAll(correctRegex, ""));
            }
        };

        inputText.textProperty().addListener(changeListener);
    }

    private MFXPageButton createPageButton(Class<?> c) {
        MFXPageButton pageButton = new MFXPageButton(c.getSimpleName(), c, NUM_MATCH_REGEX, NUM_CORRECT_REGEX);

        GridPane.setHalignment(pageButton, HPos.CENTER);
        GridPane.setValignment(pageButton, VPos.CENTER);

        pageButton.setOnAction(event -> {
            setScrollPane();
            MFXPageButton mfxPageButton = (MFXPageButton) event.getSource();

            GridPane pane = createGridPane(OPS_GRID_WIDTH, OPS_GRID_HEIGHT, BACKGROUND_COLOR + BLACK + ";",
                    getRowsNumber(mfxPageButton.getMethodList().size(), OPS_GRID_COLS), OPS_GRID_COLS, MFXOpButton.WIDTH, MFXOpButton.HEIGHT + 60);

            List<MFXButton> buttonList = new ArrayList<>();

            for (Method m : mfxPageButton.getMethodList()) {
                buttonList.add(new MFXOpButton(m.getName(), m, inputText, outputText));
            }

            populateGridpane(pane, buttonList);

            setListener(mfxPageButton.getMatchRegex(), mfxPageButton.getCorrectRegex());

            scrollPane.setContent(pane);
        });

        return pageButton;
    }

    /** Simple method to set up the ScrollPane's looks for usage */
    private void setScrollPane() {
        scrollPane.setOpacity(1);
        scrollPane.setStyle("-fx-background-color: transparent");
    }

    /**
     * Creates a new GridPane instance with:
     *
     * @param width GridPane width in pixels
     * @param height GridPane height in pixels
     * @param style GridPane CSS style String
     * @param numRows number of rows
     * @param numCols number of columns
     *
     * @return a GridPane object
     */
    private GridPane createGridPane(final int width, final int height, String style, int numRows, final int numCols, final int colWidth, final int rowHeight) {

        GridPane pane = new GridPane();

        pane.setPrefWidth(width);
        pane.setPrefHeight(height);
        pane.setStyle(style);

        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            pane.getColumnConstraints().add(colConst);
        }

        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setMinHeight(rowHeight);
            rowConst.setPrefHeight(colWidth);
            pane.getRowConstraints().add(rowConst);
        }

        return pane;
    }

    /**
     * Method returning the number of rows necessary to display n elements.
     *
     * @param n number of elements
     * @param numCols number of columns
     *
     * @return number of rows
     */
    private int getRowsNumber(final int n, final int numCols) {
        return (int) Math.ceil((double) n / (double) numCols);
    }

    /**
     * Checks if passed index doesn't generate an ArrayIndexOutOfBoundsException.
     *
     * @param list Generic List
     * @param index the current index value
     *
     * @return false if the index is out of bounds, true otherwise
     */
    private boolean isInBounds(List<?> list, int index) {
        return list.toArray().length > index;
    }

    /**
     * A method that populates and  GridPane with MFXButtons, on the basis of the number of columns.
     *
     * @param pane the GridPane instance we want to populate
     * @param buttons list of MFXButtons that will populate it
     */
    private void populateGridpane(GridPane pane, List<MFXButton> buttons) {

        final int numRows = pane.getRowCount();
        final int numCols = pane.getColumnCount();

        for (int row = 0; row < numRows; ++row) {
            for (int col = 0; col < numCols && isInBounds(buttons, row * numCols + col); ++col) {

                MFXButton button = buttons.get(row * numCols + col);

                GridPane.setHalignment(button, HPos.CENTER);
                GridPane.setValignment(button, VPos.CENTER);

                pane.add(button, col, row);
            }
        }
    }
}