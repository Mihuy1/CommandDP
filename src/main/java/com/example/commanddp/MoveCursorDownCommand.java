package com.example.commanddp;

public class MoveCursorDownCommand implements Command {
    private Cursor cursor;

    public MoveCursorDownCommand(Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public void execute() {
        cursor.moveCursor(0, 1);
    }
}
