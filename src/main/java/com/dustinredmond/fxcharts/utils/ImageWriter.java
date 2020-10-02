package com.dustinredmond.fxcharts.utils;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.Chart;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageWriter {

    public static void promptWriteImage(Node node) {

        // otherwise we'd render the frame before the axis labels gets added
        // Node itself doesn't have an animatedProperty, so we must be more
        // specific and test if the node is an instance of Chart
        if (node instanceof Chart) {
            ((Chart) node).setAnimated(false);
        }

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
        fc.setInitialFileName(String.format("fxcharts-%s", SDF.format(new Date())));
        File file = fc.showSaveDialog(node.getScene().getWindow());

        WritableImage image = node.snapshot(new SnapshotParameters(), null);
        if (file != null) {
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd-hhmmss");
}
