package com.example.commanddp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        Cursor editor = new Cursor();

        BorderPane root = new BorderPane();
        root.setCenter(editor.getGridPane());

        Button generateButton = new Button("Create Code");
        generateButton.setOnAction(e -> new GenerateCodeCommand(editor).execute());
        root.setBottom(generateButton);

        Scene scene = new Scene(root, 500, 500);
        scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            if (code == KeyCode.UP) {
                new MoveCursorUpCommand(editor).execute();
            } else if (code == KeyCode.DOWN) {
                new MoveCursorDownCommand(editor).execute();
            } else if (code == KeyCode.LEFT) {
                new MoveCursorLeftCommand(editor).execute();
            } else if (code == KeyCode.RIGHT) {
                new MoveCursorRightCommand(editor).execute();
            } else if (code == KeyCode.SPACE) {
                new TogglePixelCommand(editor).execute();
            }
        });

        scene.getRoot().requestFocus();
        stage.setScene(scene);
        stage.setTitle("Pixel Art Editor");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}