import java.io.IOException;

// Клас для тестування
public class Test {
    public static void main(String[] args) {
        // Параметри для обчислень
        double mass = 10.5;
        double height = 20.0;

        // Обчислення максимальної енергії
        double maxEnergy = EnergyCalculator.calculateMaxEnergy(mass, height);

        // Створення об'єкта з результатами обчислень
        CalculationData data = new CalculationData(mass, height, maxEnergy);

        // Серіалізація та десеріалізація об'єкта
        try {
            SerializationDemo.serializeObject(data, "data.ser");
            CalculationData deserializedData = (CalculationData) SerializationDemo.deserializeObject("data.ser");

            // Перевірка коректності серіалізації/десеріалізації
            System.out.println("Serialized data: " + data);
            System.out.println("Deserialized data: " + deserializedData);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
