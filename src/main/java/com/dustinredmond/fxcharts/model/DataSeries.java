package com.dustinredmond.fxcharts.model;

import javafx.scene.chart.XYChart;


public class DataSeries <X,Y> {

    private String name;
    private final XYChart.Series<X, Y> dataSeries = new XYChart.Series<>();

    public DataSeries() {
        super();
    }

    public void setName(String name) {
        dataSeries.setName(name);
        this.name = name;
    }

    public int size() {
        return dataSeries.getData().size();
    }
    public XYChart.Series<X, Y> getDataSeries() {
        return dataSeries;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
