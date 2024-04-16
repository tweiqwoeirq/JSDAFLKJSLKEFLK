import java.util.Stack;

// Клас, що керує командами, використовуючи стек для зберігання історії виконаних команд
public class CommandManager {
    private static CommandManager instance;
    private Stack<Command> history; // Стек для зберігання виконаних команд

    private CommandManager() {
        history = new Stack<>();
    }

    // Метод для отримання єдиного екземпляру CommandManager (шаблон Singleton)
    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    // Метод для виконання команди та додавання її до історії
    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    // Метод для відміни останньої виконаної команди
    public void undoLastCommand() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop();
            lastCommand.undo();
        }
    }
}
