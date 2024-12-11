import com.example.commanddp.Command;
import com.example.commanddp.Cursor;

public class GenerateCodeCommand implements Command {
    private Cursor cursor;

    public GenerateCodeCommand(Cursor cursor) {
        this.cursor = cursor;
    }

    public void execute() {
        cursor.generateCode();
    }
}
