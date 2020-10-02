package com.dustinredmond.fxcharts.ui.controls;


import javafx.scene.control.TextField;

public class NumberField extends TextField {

   public NumberField() {
       TextField theField = this;
       this.textProperty().addListener((observable, oldValue, newValue) -> {
           if (!newValue.matches("\\d*")) {
               theField.setText(oldValue);
           }
       });
   }

   public Integer getInt() {
       try {
           return Integer.parseInt(this.getText());
       } catch (Exception e) {
           return 0;
       }
   }

}
