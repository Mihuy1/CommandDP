package com.example.commanddp;

import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cursor {
    private int x = 0;
    private int y = 0;
    private final int rows = 8;
    private final int columns = 8;
    private int pixels[][] = new int[rows][columns];
    private GridPane gridPane = new GridPane();

    private final static Color HIGHLIGHTED_COLOR = Color.DEEPPINK;
    private final static Color SELECTED_COLOR = Color.BLACK;
    private final static Color NOT_SELECTED_COLOR = Color.WHITE;

    public Cursor() {
        initialize();
    }

    private void initialize() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Rectangle rectangle = new Rectangle(60, 55);
                rectangle.setFill(NOT_SELECTED_COLOR);
                rectangle.setStroke(SELECTED_COLOR);
                rectangle.setStrokeWidth(3.0);
                gridPane.add(rectangle, column, row);
            }
        }
        updateCursor();
    }

    public void moveCursor(int dx, int dy) {
        int newX = x + dx;
        int newY = y + dy;
        if (newX < rows && newY < columns) {
            x = newX;
            y = newY;
        }
        updateCursor();
    }

    public void togglePixel() {
        pixels[x][y] = pixels[x][y] == 0 ? 1 : 0;
        updateCell(x, y);
    }

    private void updateCursor() {
        for (Node node : gridPane.getChildren()) {
            if (node instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) node;
                rectangle.setStroke(SELECTED_COLOR);
            }
        }
        Rectangle rectangle = (Rectangle) gridPane.getChildren().get(y * columns + x);
        rectangle.setStroke(HIGHLIGHTED_COLOR);
    }

    private void updateCell(int x, int y) {
        Rectangle rectangle = (Rectangle) gridPane.getChildren().get(y * columns + x);
        rectangle.setFill(pixels[x][y] == 1 ? SELECTED_COLOR : NOT_SELECTED_COLOR);
    }

    public void generateCode() {
        StringBuilder sb = new StringBuilder("int[][] pixelArt = {\n");
        for (int[] row : pixels) {
            sb.append("    {");
            for (int col : row) {
                sb.append(col).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append("},\n");
        }
        sb.setLength(sb.length() - 2);
        sb.append("\n};");
        System.out.println(sb);
    }

    public GridPane getGridPane() {
        return gridPane;
    }
}
