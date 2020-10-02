package com.dustinredmond.fxcharts.controller;

import com.dustinredmond.fxcharts.model.DataSeries;
import com.dustinredmond.fxcharts.ui.UI;
import com.dustinredmond.fxcharts.ui.controls.CustomGridPane;
import com.dustinredmond.fxcharts.ui.controls.NumberField;
import com.dustinredmond.fxcharts.utils.DataViewCell;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class BarChartController {

    public void addSeries(BarChart<String, Number> barChart) {
        XYChart.Series<String,Number> series = new XYChart.Series<>();

        Stage stage = new Stage();
        stage.setTitle(String.format("%s - BarChar - Create Data Series", UI.APPLICATION_TITLE));
        CustomGridPane grid = new CustomGridPane(5, 10);
        stage.setScene(new Scene(grid));
        int rowIndex = 0;

        TextField textFieldSeriesName = new TextField();
        textFieldSeriesName.setOnKeyReleased(e -> {
            series.setName(textFieldSeriesName.getText());
        });

        HBox seriesNameBox = new HBox(5, new Label("Series Name:"), textFieldSeriesName);
        grid.add(seriesNameBox, 0, rowIndex++);

        TextField textFieldEntity = new TextField();
        textFieldEntity.setPromptText("Enter an entity name");
        NumberField numberField = new NumberField();
        numberField.setPromptText("Enter a value");
        Button buttonAdd = new Button("Add Data");
        HBox hBox = new HBox(5, textFieldEntity, numberField, buttonAdd);
        grid.add(hBox, 0, rowIndex++);

        ListView<XYChart.Data<String,Number>> listViewData = new ListView<>();
        listViewData.setCellFactory(e -> new DataViewCell<String, Number>());
        grid.add(listViewData, 0, rowIndex++);

        buttonAdd.setOnAction(e -> {
            XYChart.Data<String, Number> data = new XYChart.Data<>(textFieldEntity.getText(), numberField.getInt());
            listViewData.getItems().add(data);
            series.getData().add(data);
        });

        Button buttonClose = new Button("Close Window");
        grid.add(buttonClose, 0, rowIndex);
        buttonClose.setOnAction(e -> stage.hide());

        barChart.getData().add(series);
        stage.show();

    }

}
