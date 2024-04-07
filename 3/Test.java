import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        double Mass = 10.5;
        double Height = 20.0;

        double MaxEnergy = EnergyCalculator.calculateMaxEnergy(Mass, Height);

        CalculationData data = new CalculationData(Mass, Height, MaxEnergy);

        try {
            System.out.println("Serialized data: \n" + data + "\n");

            SerializationDemo.serializeObject(data, "data.ser");
            CalculationData deserializedData = (CalculationData) SerializationDemo.deserializeObject("data.ser");

            System.out.println("Deserialized data: \n" + deserializedData + "\n");

            // Використання фабричного методу для відображення результатів
            Displayable displayable = DisplayFactory.createDisplayable(deserializedData);
            displayable.display();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}