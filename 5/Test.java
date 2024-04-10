import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
                System.out.println("Enter a command ('view', 'quit', 'save', 'undo'):");
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
                        break;
                    default:
                        System.out.println("Invalid command. Please try again.");
                }
            } while (!input.equals("quit"));
        } catch (IOException | ClassNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
