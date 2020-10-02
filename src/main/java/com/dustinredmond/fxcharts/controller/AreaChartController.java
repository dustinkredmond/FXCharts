package com.dustinredmond.fxcharts.controller;

import com.dustinredmond.fxcharts.model.DataSeries;
import com.dustinredmond.fxcharts.ui.UI;
import com.dustinredmond.fxcharts.ui.controls.CustomGridPane;
import com.dustinredmond.fxcharts.ui.controls.NumberField;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AreaChartController {

    public void showAddDataSeries(ListView<DataSeries<Number,Number>> seriesListView, AreaChart<Number, Number> areaChart) {

        Stage stage = new Stage();
        stage.setTitle(String.format("%s - AreaChart - Create Data Series", UI.APPLICATION_TITLE));
        CustomGridPane grid = new CustomGridPane(5, 10);
        DataSeries<Number,Number> ds = new DataSeries<>();

        grid.add(new Label("Series Name:"), 0, 0);

        TextField textFieldName = new TextField();
        textFieldName.setPromptText("Enter series name");
        grid.add(textFieldName, 1, 0);

        NumberField textFieldX = new NumberField();
        textFieldX.setPromptText("Enter an x coordinate");
        NumberField textFieldY = new NumberField();
        textFieldY.setPromptText("Enter a y coordinate");

        Label labelCount = new Label("0 coordinate(s)");
        Button buttonAddCoordinate = new Button("Add Coordinate");
        buttonAddCoordinate.setOnAction(e -> {
            ds.getDataSeries().getData().add(new XYChart.Data<>(textFieldX.getInt(), textFieldY.getInt()));
            labelCount.setText(String.format("%s coordinate(s)", ds.size()));
        });

        HBox xyBox = new HBox(5, new Label("Coordinate Values:"),
                textFieldX, textFieldY, buttonAddCoordinate);
        grid.add(xyBox, 0, 2, 3, 1);

        grid.add(labelCount, 0, 4);


        Button buttonAddSeries = new Button("Add Series");
        buttonAddSeries.setOnAction(e -> {
            ds.setName(textFieldName.getText());
            seriesListView.getItems().add(ds);
            areaChart.getData().add(ds.getDataSeries());
            stage.hide();
        });
        grid.add(buttonAddSeries, 0, 5);

        stage.setScene(new Scene(grid));
        stage.show();

    }

    public void removeDataSeries(ListView<DataSeries<Number,Number>> seriesListView, AreaChart<Number, Number> areaChart) {
        if (seriesListView.getSelectionModel().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please, first select a " +
                    "series from the list.").showAndWait();
            return;
        }
        DataSeries<Number,Number> ds = seriesListView.getSelectionModel().getSelectedItem();
        areaChart.getData().remove(ds.getDataSeries());
        seriesListView.getItems().remove(ds);
    }

}
