package com.lcefesto;

import com.lcefesto.customNodes.MFXOpButton;
import com.lcefesto.customNodes.MFXPageButton;
import io.github.palexdev.materialfx.controls.MFXScrollPane;
import javafx.fxml.FXML;
import javafx.geometry.HPos;

import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

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
    @FXML
    private MFXScrollPane scrollPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    public TextField inputText;
    @FXML
    public TextField outputText;

    public MFXOpButton currentButton;

    public void initialize() {

        try {
            List<Node> list = OpsPackage.findAllClassesUsingGoogleGuice("com.lcefesto.ops").stream().map(this::createPageButton).collect(Collectors.toList());
            GridPane pagesGridPane = createGridPane(PAGES_GRID_WIDTH, PAGES_GRID_HEIGHT, BACKGROUND_COLOR + "transparent;", getRowsNumber(list.size(), PAGES_GRID_COLS), PAGES_GRID_COLS, MFXPageButton.PAGE_BUTTON_HEIGHT + 60);
            populateGridpane(pagesGridPane, list);
            pagesGridPane.setAlignment(Pos.TOP_LEFT);
            anchorPane.getChildren().setAll(pagesGridPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onEqualsButtonClick() throws InvocationTargetException, IllegalAccessException {
        if(currentButton.isSingleParameter()){
            if(currentButton.getMethod().getParameters()[0].getParameterizedType() == double.class) {
                outputText.setText(currentButton.getMethod().invoke(null, Double.parseDouble(inputText.getText())).toString());
            }else if (currentButton.getMethod().getParameters()[0].getParameterizedType() == int.class){
                outputText.setText(currentButton.getMethod().invoke(null, Integer.parseInt(inputText.getText())).toString());
            }
        }else{
            outputText.setText(currentButton.getMethod().invoke(null, currentButton.getArgs()).toString());
        }
    }

    /**
     * Sets the current inputText TextField text property
     * to the String representation of 0.0d.
     */
    public void onClearButtonClick() {
        inputText.setText("");
    }

    /**
     * Sets the current inputText TextField text as the outputText text.
     */
    public void onAnsButtonClick() {
        inputText.setText(outputText.getText());
    }

    /**
     * Used to create an instance of MFXPageButton, starting from a class.
     * An MFXPageButton represents a set of operations to perform on the input,
     * consisting of methods declared in the same class, and is named after it.
     *
     * @param c the class, a collection of static methods and constants
     */
    private MFXPageButton createPageButton(Class<?> c) {

        MFXPageButton pageButton = new MFXPageButton(c);

        GridPane.setHalignment(pageButton, HPos.CENTER);
        GridPane.setValignment(pageButton, VPos.CENTER);

        pageButton.setOnAction(event -> {
            showScrollPane();

            MFXPageButton mfxPageButton = (MFXPageButton) event.getSource();

            GridPane pane = createGridPane(OPS_GRID_WIDTH, OPS_GRID_HEIGHT, BACKGROUND_COLOR + BLACK + ";", getRowsNumber(mfxPageButton.getMethodList().size(), OPS_GRID_COLS), OPS_GRID_COLS, MFXOpButton.HEIGHT + 60);

            List<Node> buttonList =
                    mfxPageButton.getMethodList().stream().map(m -> new MFXOpButton(this, m)).collect(Collectors.toList());

            populateGridpane(pane, buttonList);

            scrollPane.setContent(pane);
        });

        return pageButton;
    }

    /**
     * Simple method to set up the ScrollPane's looks for usage.
     */
    private void showScrollPane() {
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
    public static GridPane createGridPane(final int width, final int height, String style, int numRows, final int numCols, final int rowHeight) {

        GridPane pane = new GridPane();

        pane.setPrefWidth(width);
        pane.setPrefHeight(height);
        pane.setStyle(style);
        //pane.setGridLinesVisible(true);

        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            pane.getColumnConstraints().add(colConst);
        }

        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setMinHeight(rowHeight);
            rowConst.setPrefHeight(rowHeight);
            pane.getRowConstraints().add(rowConst);
        }

        return pane;
    } //final int colWidth,

    /**
     * Method returning the number of rows necessary to display n elements.
     *
     * @param n number of elements
     * @param numCols number of columns
     *
     * @return number of rows
     */
    public static int getRowsNumber(final int n, final int numCols) {
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
    public static boolean isInBounds(List<?> list, int index) {
        return list.toArray().length > index;
    }

    /**
     * A method that populates and  GridPane with MFXButtons, on the basis of the number of columns.
     *
     * @param pane the GridPane instance we want to populate
     * @param buttons list of MFXButtons that will populate it
     */
    public static void populateGridpane(GridPane pane, List<? extends Node> buttons) {

        final int numRows = pane.getRowCount();
        final int numCols = pane.getColumnCount();

        for (int row = 0; row < numRows; ++row) {
            for (int col = 0; col < numCols && isInBounds(buttons, row * numCols + col); ++col) {

                Node button = buttons.get(row * numCols + col);

                GridPane.setHalignment(button, HPos.CENTER);
                GridPane.setValignment(button, VPos.CENTER);

                pane.add(button, col, row);
            }
        }
    }
}