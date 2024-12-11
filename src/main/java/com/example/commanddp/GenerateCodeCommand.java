package com.example.commanddp;

public class GenerateCodeCommand implements Command {
    private Cursor cursor;

    public GenerateCodeCommand(Cursor cursor) {
        this.cursor = cursor;
    }

    public void execute() {
        cursor.generateCode();
    }
}
