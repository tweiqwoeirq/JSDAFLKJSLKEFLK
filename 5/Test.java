import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Клас, що містить метод main для демонстрації функціональності програми
public class Test {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the mass:");
            double mass = Double.parseDouble(reader.readLine()); // Отримання маси від користувача

            System.out.println("Enter the height:");
            double height = Double.parseDouble(reader.readLine()); // Отримання висоти від користувача

            double maxEnergy = EnergyCalculator.calculateMaxEnergy(mass, height); // Обчислення максимальної енергії

            CalculationData data = new CalculationData(mass, height, maxEnergy); // Створення об'єкту CalculationData
            CommandManager commandManager = CommandManager.getInstance(); // Отримання екземпляру CommandManager

            String input;
            do {
                System.out.println("Enter a command ('view', 'quit', 'save', 'undo'):");
                input = reader.readLine().trim(); // Отримання команди від користувача
                switch (input) {
                    case "view":
                        System.out.println("Serialized data: \n" + data + "\n"); // Відображення серіалізованих даних
                        CalculationData deserializedData = (CalculationData) SerializationDemo.deserializeObject("data.ser");
                        System.out.println("Deserialized data: \n" + deserializedData + "\n"); // Відображення десеріалізованих даних
                        Displayable displayable = DisplayFactory.createDisplayable(data); // Створення об'єкту Displayable
                        displayable.display(); // Відображення даних
                        break;
                    case "quit":
                        System.out.println("Exiting program..."); // Повідомлення про завершення програми
                        break;
                    case "save":
                        SerializationDemo.serializeObject(data, "data.ser"); // Збереження даних
                        System.out.println("Data saved successfully."); // Повідомлення про успішне збереження
                        break;
                    case "undo":
                        commandManager.undoLastCommand(); // Відміна останньої виконаної команди
                        break;
                    default:
                        System.out.println("Invalid command. Please try again."); // Повідомлення про недійсну команду
                }
            } while (!input.equals("quit")); // Повторення циклу до введення команди "quit"
        } catch (IOException | ClassNotFoundException | NumberFormatException e) {
            e.printStackTrace(); // Обробка винятків та виведення їх на консоль
        }
    }
}
