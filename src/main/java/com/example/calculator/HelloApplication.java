package com.example.calculator;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Calculator cal = new Calculator();
        Scene scene = new Scene(cal.getRoot(), 320, 240);
        stage.setResizable(false);
        stage.setTitle("Calculator");
        //set the scene on the stage
        stage.setScene(scene);
        //call show to display the window.
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}