import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {
    private List<Command> commands;

    public MacroCommand() {
        commands = new ArrayList<>();
    }

    public void addCommand(Command command) {
        commands.add(command); // Додавання команди до списку команд
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute(); // Виконання всіх команд
        }
    }

    @Override
    public void undo() {
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo(); // Відміна всіх команд у зворотньому порядку
        }
    }
}
