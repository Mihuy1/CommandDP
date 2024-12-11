package com.example.commanddp;

import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cursor {
    private int x = 0;
    private int y = 0;
    private int rows = 8;
    private int columns = 8;
    private int pixels[][] = new int[rows][columns];
    private GridPane gridPane = new GridPane();

    public Cursor() {
        initializeGrid();
    }

    private void initializeGrid() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Rectangle rectangle = new Rectangle(60, 55);
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.BLACK);
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
                rectangle.setStroke(Color.BLACK);
            }
        }

        Rectangle rectangle = (Rectangle) gridPane.getChildren().get(y * columns + x);
        rectangle.setStroke(Color.RED);
    }

    private void updateCell(int x, int y) {
        Rectangle rectangle = (Rectangle) gridPane.getChildren().get(y * columns + x);
        rectangle.setFill(pixels[x][y] == 1 ? Color.BLACK : Color.WHITE);
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
