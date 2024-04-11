import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerThread {
    private static final int THREAD_POOL_SIZE = 5; // Кількість потоків у пулі
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public static void executeTask(Runnable task) {
        executor.execute(task);
    }

    public static void shutdown() {
        executor.shutdown();
    }
}
