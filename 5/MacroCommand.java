import java.util.ArrayList;
import java.util.List;

// Клас, що представляє макрокоманду, яка може виконувати групу команд одночасно
public class MacroCommand implements Command {
    private List<Command> commands; // Список команд, що входять до макрокоманди

    public MacroCommand() {
        commands = new ArrayList<>();
    }

    // Метод для додавання команди до макрокоманди
    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute(); // Виконати кожну команду в макрокоманді
        }
    }

    @Override
    public void undo() {
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo(); // Відмінити кожну команду в макрокоманді у зворотньому порядку
        }
    }
}
