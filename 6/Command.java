public interface Command {
    void execute(); // Інтерфейс команди для виконання дії
    void undo(); // Інтерфейс команди для відміни останньої дії
}
