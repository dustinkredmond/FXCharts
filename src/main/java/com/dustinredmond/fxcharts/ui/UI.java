package com.dustinredmond.fxcharts.ui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        UI.stage = stage;
        stage.setTitle(APPLICATION_TITLE);
        Group rootGroup = new Group();
        stage.setScene(new Scene(rootGroup));
        new MainWindow().show();
        stage.show();
    }

    public void startUi(String... args) {
        Application.launch(UI.class, args);
    }


    public static Stage getStage() { return UI.stage; }

    public static final String APPLICATION_TITLE = "FXCharts";
    private static Stage stage;
}
