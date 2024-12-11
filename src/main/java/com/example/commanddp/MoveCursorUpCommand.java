package com.example.commanddp;

public class MoveCursorUpCommand implements Command {
    private Cursor cursor;

    public MoveCursorUpCommand(Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public void execute() {
        cursor.moveCursor(0, -1);
    }
}
