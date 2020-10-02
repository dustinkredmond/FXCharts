package com.dustinredmond.fxcharts.charts;

import com.dustinredmond.fxcharts.controller.BarChartController;
import com.dustinredmond.fxcharts.utils.ImageWriter;
import javafx.geometry.Insets;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class BarChartPane extends GridPane {

    private final CategoryAxis xAxis = new CategoryAxis();
    private final NumberAxis yAxis = new NumberAxis();
    private final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
    private final BarChartController controller = new BarChartController();

    public BarChartPane() {
        this.setHgap(5);
        this.setVgap(5);
        this.setPadding(new Insets(10));
        int rowIndex = 0;

        TextField textFieldX = new TextField();
        textFieldX.setPromptText("Enter x axis name");
        textFieldX.setOnKeyReleased(e -> xAxis.setLabel(textFieldX.getText()));

        TextField textFieldY = new TextField();
        textFieldY.setPromptText("Enter y axis name");
        textFieldY.setOnKeyReleased(e -> yAxis.setLabel(textFieldY.getText()));

        HBox fieldBox = new HBox(5, new Label("Axes: "), textFieldX, textFieldY);
        this.add(fieldBox, 0, rowIndex++, 3, 1);

        VBox chartBox = new VBox(5);
        Button buttonAdd = new Button("Add data series");
        buttonAdd.setOnAction(e -> {
            controller.addSeries(barChart);

            // Note: Unlike other charts, when updated,
            // bar chart must be re-added to the scene
            // graph before it will visually update
            chartBox.getChildren().clear();
            chartBox.getChildren().add(barChart);
        });
        this.add(buttonAdd, 0, rowIndex++);

        chartBox.getChildren().add(barChart);
        this.add(chartBox, 0, rowIndex++);

        Button buttonSaveImage = new Button("Save Image");
        this.add(buttonSaveImage, 0, rowIndex);
        buttonSaveImage.setOnAction(e -> ImageWriter.promptWriteImage(barChart));

        GridPane.setHgrow(chartBox, Priority.ALWAYS);
        GridPane.setVgrow(chartBox, Priority.ALWAYS);
    }

}
