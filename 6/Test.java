import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the mass:");
            double mass = Double.parseDouble(reader.readLine());

            System.out.println("Enter the height:");
            double height = Double.parseDouble(reader.readLine());

            double maxEnergy = EnergyCalculator.calculateMaxEnergy(mass, height); // Обчислення максимальної енергії

            CalculationData data = new CalculationData(mass, height, maxEnergy);
            CommandManager commandManager = CommandManager.getInstance(); // Отримання єдиного екземпляру менеджера команд

            String input;
            do {
                System.out.println("Enter a command ('view', 'quit', 'save', 'undo', 'process', 'queue'):");
                input = reader.readLine().trim();
                switch (input) {
                    case "view":
                        System.out.println("Serialized data: \n" + data + "\n");
                        CalculationData deserializedData = (CalculationData) SerializationDemo.deserializeObject("data.ser"); // Десеріалізація даних
                        System.out.println("Deserialized data: \n" + deserializedData + "\n");
                        Displayable displayable = DisplayFactory.createDisplayable(data); // Створення об'єкта відображення
                        displayable.display(); // Виведення даних
                        break;
                    case "quit":
                        System.out.println("Exiting program..."); // Вихід з програми
                        break;
                    case "save":
                        SerializationDemo.serializeObject(data, "data.ser"); // Серіалізація даних
                        System.out.println("Data saved successfully."); // Повідомлення про успішне збереження
                        break;
                    case "undo":
                        commandManager.undoLastCommand(); // Відміна останньої команди
                        System.out.println("Successful."); // Повідомлення про успішну операцію
                        break;
                    case "process":
                        processCollection(data); // Обробка колекції даних
                        break;
                    case "queue":
                        System.out.println("Enter the new mass:");
                        double newMass = Double.parseDouble(reader.readLine());
                        System.out.println("Enter the new height:");
                        double newHeight = Double.parseDouble(reader.readLine());
                        addToCommandQueue(data, newMass, newHeight); // Додавання команди до черги
                        break;
                    default:
                        System.out.println("Invalid command. Please try again."); // Повідомлення про невідому команду
                }
            } while (!input.equals("quit"));
        } catch (IOException | ClassNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void processCollection(CalculationData data) {
        List<CalculationData> collection = createSampleCollection(); // Приклад колекції

        // Паралельна обробка колекції для пошуку мінімуму, максимуму та обчислення середнього значення
        double minMass = collection.parallelStream().mapToDouble(CalculationData::getMass).min().orElse(0);
        double maxHeight = collection.parallelStream().mapToDouble(CalculationData::getHeight).max().orElse(0);
        double averageMaxEnergy = collection.parallelStream().mapToDouble(CalculationData::getMaxEnergy).average().orElse(0);

        System.out.println("Minimum Mass: " + minMass); // Виведення мінімальної маси
        System.out.println("Maximum Height: " + maxHeight); // Виведення максимальної висоти
        System.out.println("Average Max Energy: " + averageMaxEnergy); // Виведення середньої максимальної енергії
    }

    private static void addToCommandQueue(CalculationData data, double newMass, double newHeight) {
        Command changeMassCommand = new ChangeMassCommand(data, newMass); // Команда зміни маси
        Command changeHeightCommand = new ChangeHeightCommand(data, newHeight); // Команда зміни висоти
    
        CommandManager commandManager = CommandManager.getInstance(); // Отримання єдиного екземпляру менеджера команд
        commandManager.executeCommand(changeMassCommand); // Виконання команди зміни маси
        commandManager.executeCommand(changeHeightCommand); // Виконання команди зміни висоти
    }
    
    // Приклад створення колекції для обробки
    private static List<CalculationData> createSampleCollection() {
        return List.of(
                new CalculationData(60, 1.8, EnergyCalculator.calculateMaxEnergy(60, 1.8)),
                new CalculationData(70, 1.9, EnergyCalculator.calculateMaxEnergy(70, 1.9)),
                new CalculationData(80, 2.0, EnergyCalculator.calculateMaxEnergy(80, 2.0))
        );
    }
}
