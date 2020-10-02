package com.dustinredmond.fxcharts.charts;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class StackedAreaChartPane extends GridPane {

    public StackedAreaChartPane() {
        String warning = String.format("Implementation for %s not yet ready.", getClass().getName());
        this.add(new Label(warning), 0, 0);
    }
}
