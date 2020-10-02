package com.dustinredmond.fxcharts.utils;

import javafx.scene.chart.XYChart;
import javafx.scene.control.ListCell;

/**
 * When set as the cell factory for {@code ListView<XYChart.Data<?,?>>}
 * renders the listview cells in a human-readable way.
 * @param <K> the first type parameter for XYChart.Data
 * @param <V> the second type parameter for XYChar.Data
 */
public class DataViewCell<K,V> extends ListCell<XYChart.Data<String,Number>> {
    @Override
    public void updateItem(XYChart.Data<String,Number> item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            setText(String.format("%s - %s", item.getXValue(), item.getYValue()));
        }
    }
}