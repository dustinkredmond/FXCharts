package com.dustinredmond.fxcharts.charts;

import javafx.scene.chart.AreaChart;
import javafx.scene.chart.Chart;

public enum ChartType {
    AREA_CHART,
    BAR_CHART,
    BUBBLE_CHART,
    LINE_CHART,
    PIE_CHART,
    SCATTER_CHART,
    STACKED_AREA_CHART,
    STACKED_BAR_CHART;

    @Override
    public String toString() {
        final String inEnumString = super.toString();
        switch (inEnumString) {
            case "AREA_CHART"           : return "Area Chart";
            case "BAR_CHART"            : return "Bar Chart";
            case "BUBBLE_CHART"         : return "Bubble Chart";
            case "LINE_CHART"           : return "Line Chart";
            case "PIE_CHART"            : return "Pie Chart";
            case "SCATTER_CHART"        : return "Scatter Chart";
            case "STACKED_AREA_CHART"   : return "Stacked Area Chart";
            case "STACKED_BAR_CHART"    : return "Stacked Bar Chart";
            default :
                throw new RuntimeException(String.format("%s not defined.", inEnumString));
        }
    }
}
