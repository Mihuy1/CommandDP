package com.example.commanddp;

public class MoveCursorRightCommand implements Command {
    private Cursor cursor;

    public MoveCursorRightCommand(Cursor cursor) {
        this.cursor = cursor;
    }

    public void execute() {
        cursor.moveCursor(1, 0);
    }
}
