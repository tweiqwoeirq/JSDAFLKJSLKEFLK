import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CommandManager {
    private static CommandManager instance; // Єдиний екземпляр менеджера команд
    private Queue<Command> commandQueue; // Черга команд
    private static final ExecutorService executor = Executors.newFixedThreadPool(5); // Створення постійного пулу потоків

    private CommandManager() {
        commandQueue = new ConcurrentLinkedQueue<>(); // Ініціалізація черги команд
    }

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager(); // Створення єдиного екземпляру менеджера команд, якщо він ще не існує
        }
        return instance; // Повернення єдиного екземпляру менеджера команд
    }

    public void executeCommand(Command command) {
        commandQueue.offer(command); // Додавання команди до черги
        executor.execute(() -> {
            Command nextCommand;
            while ((nextCommand = commandQueue.poll()) != null) {
                nextCommand.execute(); // Виконання наступної команди з черги
            }
        });
    }

    public void undoLastCommand() {
        // Метод undo не потрібен, оскільки команди виконуються автоматично
    }
}
