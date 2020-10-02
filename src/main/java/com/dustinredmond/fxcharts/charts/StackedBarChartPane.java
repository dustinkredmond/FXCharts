package com.dustinredmond.fxcharts.charts;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class StackedBarChartPane extends GridPane {

    public StackedBarChartPane() {
        String warning = String.format("Implementation for %s not yet ready.", getClass().getName());
        this.add(new Label(warning), 0, 0);
    }
}
