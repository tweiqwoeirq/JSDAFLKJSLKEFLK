import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) {
        double mass = 10.5;
        double height = 20.0;

        double maxEnergy = EnergyCalculator.calculateMaxEnergy(mass, height);

        CalculationData data = new CalculationData(mass, height, maxEnergy);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input;
            do {
                System.out.println("Enter a command ('view', 'quit', 'save'):");
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
                    default:
                        System.out.println("Invalid command. Please try again.");
                }
            } while (!input.equals("quit"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
