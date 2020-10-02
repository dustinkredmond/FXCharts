package com.dustinredmond.fxcharts.ui.controls;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class CustomGridPane extends GridPane {

    public CustomGridPane(double gap, double insets) {
        this.setVgap(gap);
        this.setHgap(gap);
        this.setPadding(new Insets(insets));
    }
}
