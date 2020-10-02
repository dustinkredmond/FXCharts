package com.dustinredmond.fxcharts.charts;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ScatterChartPane extends GridPane {

    public ScatterChartPane() {
        String warning = String.format("Implementation for %s not yet ready.", getClass().getName());
        this.add(new Label(warning), 0, 0);
    }
}
