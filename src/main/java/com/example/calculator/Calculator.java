package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Calculator {
    private HBox root;
    private ButtonHandler bh = new ButtonHandler();
    Button minus, plus, divide, multiply;

    public Calculator() {
        root = new HBox();
        root.setAlignment(javafx.geometry.Pos.CENTER);
        root.setPrefSize(320, 240);
        VBox buttonBox = new VBox();
        VBox leftBox = new VBox();

        plus = new Button("+");

        minus = new Button("-");
        multiply = new Button("*");
        divide = new Button("/");
        //add al buttons in buttonBox
        buttonBox.getChildren().addAll(plus, minus, multiply, divide);
        //create a gridpane for the label and Texfields
        GridPane myGrid = new GridPane();
        Label num1Lab = new Label("Num1: ");
        Label num2Lab = new Label("Num2: ");
        TextField num1Text = new TextField();
        TextField num2Text = new TextField();
        myGrid.add(num1Lab, 0, 0);
        myGrid.add(num1Text, 1, 0);
        myGrid.add(num2Lab, 0, 1);
        myGrid.add(num2Text, 1, 1);
        myGrid.setVgap(10); //set spacing between num1 and num2 vertical
        Label resultLabel = new Label("Result: NaN");
        leftBox.setSpacing(40);
        leftBox.getChildren().addAll(myGrid, resultLabel);
        //add both vboxes to the root
        root.getChildren().addAll(leftBox, buttonBox);
        root.setSpacing(30);
        buttonBox.setSpacing(10);
        minus.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(num1Text.getText());
                double num2 = Double.parseDouble(num2Text.getText());
                resultLabel.setText("Result: " + (num1 - num2));
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Invalid input");
                alert.setContentText(ex.getMessage()); // This is valid because 'ex' is an Exception
                alert.showAndWait();
            }
        });

        divide.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(num1Text.getText());
                double num2 = Double.parseDouble(num2Text.getText());
                resultLabel.setText("Result: " + (num1 / num2));
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Invalid input");
                alert.setContentText(ex.getMessage()); // This is valid because 'ex' is an Exception
                alert.showAndWait();
            }
        });

        multiply.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(num1Text.getText());
                double num2 = Double.parseDouble(num2Text.getText());
                resultLabel.setText("Result: " + (num1 * num2));
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Invalid input");
                alert.setContentText(ex.getMessage()); // This is valid because 'ex' is an Exception
                alert.showAndWait();
            }
        });

//        plus.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                //read num1 text and covert into a double
//                String num1 = num1Text.getText();
//                //read num2 text and convert it into a double
//                String num2 = num2Text.getText();
//                //compute the sum.
//
//                //change the resultLabel to display the result
//                resultLabel.setText("Result: " + (Double.parseDouble(num1) + Double.parseDouble(num2)));
//
//
//            }
//        }

        plus.setOnAction(e -> {
                    try {
                        double n1 = Double.parseDouble(num1Text.getText());
                        double n2 = Double.parseDouble(num2Text.getText());
                        resultLabel.setText("Result: " + (n1 + n2));
                    } catch (NumberFormatException ex) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Dialog");
                        alert.setHeaderText("Invalid input");
                        alert.setContentText(ex.getMessage()); // This is valid because 'ex' is an Exception
                        alert.showAndWait();
                    }
                }
        );

        plus.setOnAction(bh);
        minus.setOnAction(bh);
        multiply.setOnAction(bh);
        divide.setOnAction(bh);

    }

    public HBox getRoot() {
        return root;
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {


        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == plus) {
                System.out.println("Plus is pressed");
            } else if (actionEvent.getSource() == minus) {
                System.out.println("Minus is pressed");
            } else if (actionEvent.getSource() == multiply) {
                System.out.println("Multiply is pressed");
            } else if (actionEvent.getSource() == divide) {
                System.out.println("Divide is pressed");
            }
        }
    }
}