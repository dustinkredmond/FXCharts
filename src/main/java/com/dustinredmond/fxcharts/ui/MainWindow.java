package com.dustinredmond.fxcharts.ui;

import com.dustinredmond.fxcharts.charts.*;
import com.dustinredmond.fxcharts.ui.controls.CustomGridPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow implements IScreen {

    private final ComboBox<ChartType> comboBoxChart = new ComboBox<>();

    @Override
    public void show() {
        BorderPane root = new BorderPane();
        Stage stage = UI.getStage();
        stage.getScene().setRoot(root);

        CustomGridPane grid = new CustomGridPane(5, 10);
        root.setCenter(grid);

        grid.add(new Label("Select a chart:"), 0, 0);
        comboBoxChart.getItems().addAll(ChartType.values());
        grid.add(comboBoxChart, 1, 0);

        comboBoxChart.getSelectionModel().selectedItemProperty().addListener(e -> {
            ChartType chart = comboBoxChart.getSelectionModel().getSelectedItem();
            stage.setTitle(String.format("%s - %s", UI.APPLICATION_TITLE, chart.toString()));
            switch (chart) {
                case AREA_CHART:
                    root.setCenter(new AreaChartPane());
                    break;
                case BAR_CHART:
                    root.setCenter(new BarChartPane());
                    break;
                case BUBBLE_CHART:
                    root.setCenter(new BubbleChartPane());
                    break;
                case LINE_CHART:
                    root.setCenter(new LineChartPane());
                    break;
                case PIE_CHART:
                    root.setCenter(new PieChartPane());
                    break;
                case SCATTER_CHART:
                    root.setCenter(new ScatterChartPane());
                    break;
                case STACKED_AREA_CHART:
                    root.setCenter(new StackedAreaChartPane());
                    break;
                case STACKED_BAR_CHART:
                    root.setCenter(new StackedBarChartPane());
                    break;
                default:
                    throw new RuntimeException(String.format("No implementation for %s", chart));
            }
            stage.setMaximized(true);
        });

    }
}
