import java.io.*;

// Клас для демонстрації в діалоговому режимі збереження та відновлення стану об'єкта
public class SerializationDemo {
    // Метод для збереження об'єкта у файл
    @SuppressWarnings("hiding")
    public static <CalculationData> void serializeObject(CalculationData data, String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(data);
        }
    }

    // Метод для відновлення об'єкта з файлу
    @SuppressWarnings({ "unchecked", "hiding" })
    public static <CalculationData> CalculationData deserializeObject(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (CalculationData) inputStream.readObject();
        }
    }
}