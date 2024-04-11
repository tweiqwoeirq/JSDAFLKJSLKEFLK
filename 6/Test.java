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

            double maxEnergy = EnergyCalculator.calculateMaxEnergy(mass, height);

            CalculationData data = new CalculationData(mass, height, maxEnergy);
            CommandManager commandManager = CommandManager.getInstance();

            String input;
            do {
                System.out.println("Enter a command ('view', 'quit', 'save', 'undo', 'process', 'queue'):");
                input = reader.readLine().trim();
                switch (input) {
                    case "view":
                        System.out.println("Serialized data: \n" + data + "\n");
                        CalculationData deserializedData = (CalculationData) SerializationDemo.deserializeObject("data.ser");
                        System.out.println("Deserialized data: \n" + deserializedData + "\n");
                        Displayable displayable = DisplayFactory.createDisplayable(data);
                        displayable.display();
                        break;
                    case "quit":
                        System.out.println("Exiting program...");
                        break;
                    case "save":
                        SerializationDemo.serializeObject(data, "data.ser");
                        System.out.println("Data saved successfully.");
                        break;
                    case "undo":
                        commandManager.undoLastCommand();
                        System.out.println("Successful.");
                        break;
                    case "process":
                        processCollection(data);
                        break;
                        case "queue":
                        System.out.println("Enter the new mass:");
                        double newMass = Double.parseDouble(reader.readLine());
                        System.out.println("Enter the new height:");
                        double newHeight = Double.parseDouble(reader.readLine());
                        addToCommandQueue(data, newMass, newHeight);
                        break;
                    default:
                        System.out.println("Invalid command. Please try again.");
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

        System.out.println("Minimum Mass: " + minMass);
        System.out.println("Maximum Height: " + maxHeight);
        System.out.println("Average Max Energy: " + averageMaxEnergy);
    }

    private static void addToCommandQueue(CalculationData data, double newMass, double newHeight) {
        Command changeMassCommand = new ChangeMassCommand(data, newMass);
        Command changeHeightCommand = new ChangeHeightCommand(data, newHeight);
    
        CommandManager commandManager = CommandManager.getInstance();
        commandManager.executeCommand(changeMassCommand);
        commandManager.executeCommand(changeHeightCommand);
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
