package com.dustinredmond.fxcharts.charts;

import com.dustinredmond.fxcharts.controller.AreaChartController;
import com.dustinredmond.fxcharts.model.DataSeries;
import com.dustinredmond.fxcharts.utils.ImageWriter;
import javafx.geometry.Insets;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;


public class AreaChartPane extends GridPane {

    private final NumberAxis xAxis = new NumberAxis();
    private final NumberAxis yAxis = new NumberAxis();
    private final AreaChart<Number, Number> areaChart = new AreaChart<>(xAxis, yAxis);
    private final AreaChartController controller = new AreaChartController();

    public AreaChartPane() {
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
        this.add(fieldBox, 0, rowIndex++);

        ListView<DataSeries<Number,Number>> seriesListView = new ListView<>();

        Button buttonAdd = new Button("Add data series");
        buttonAdd.setOnAction(e -> controller.showAddDataSeries(seriesListView, areaChart));

        Button buttonDelete = new Button("Delete data series");
        buttonDelete.setOnAction(e -> controller.removeDataSeries(seriesListView, areaChart));

        this.add(new HBox(5, buttonAdd, buttonDelete), 0, rowIndex++);

        this.add(seriesListView, 0, rowIndex++);

        this.add(areaChart, 0, rowIndex++);

        Button buttonSaveImage = new Button("Save Image");
        this.add(buttonSaveImage, 0, rowIndex);
        buttonSaveImage.setOnAction(e -> ImageWriter.promptWriteImage(areaChart));

        GridPane.setVgrow(areaChart, Priority.ALWAYS);
        GridPane.setHgrow(areaChart, Priority.ALWAYS);
    }

}
