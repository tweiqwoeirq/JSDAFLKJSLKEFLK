import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CommandManager {
    private static CommandManager instance;
    private Queue<Command> commandQueue;
    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    private CommandManager() {
        commandQueue = new ConcurrentLinkedQueue<>();
    }

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    public void executeCommand(Command command) {
        commandQueue.offer(command); // Додаємо команду до черги
        executor.execute(() -> {
            Command nextCommand;
            while ((nextCommand = commandQueue.poll()) != null) {
                nextCommand.execute(); // Виконуємо команду
            }
        });
    }

    public void undoLastCommand() {
        // Метод undo не потрібен, оскільки команди виконуються автоматично
    }
}