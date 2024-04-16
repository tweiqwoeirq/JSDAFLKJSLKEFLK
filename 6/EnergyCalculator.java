import java.util.List;

public class EnergyCalculator {
    public static double calculateMaxEnergy(double mass, double height) {
        return mass * height * 9.8; // Обчислення максимальної енергії
    }

    public static double calculateMaxEnergy(double mass, double height, double gravitationalAcceleration) {
        return mass * height * gravitationalAcceleration; // Обчислення максимальної енергії з урахуванням прискорення вільного падіння
    }

    public static double calculateMaxEnergy(CalculationData data) {
        return data.getMass() * data.getHeight() * 9.8; // Обчислення максимальної енергії з використанням даних обчислень
    }

    // Паралельна обробка елементів колекції для пошуку мінімуму, максимуму та обчислення середнього значення
    public static void processCollection(List<CalculationData> collection) {
        double minMass = collection.parallelStream().mapToDouble(CalculationData::getMass).min().orElse(0); // Мінімальна маса
        double maxHeight = collection.parallelStream().mapToDouble(CalculationData::getHeight).max().orElse(0); // Максимальна висота
        double averageMaxEnergy = collection.parallelStream().mapToDouble(CalculationData::getMaxEnergy).average().orElse(0); // Середня максимальна енергія

        System.out.println("Minimum Mass: " + minMass); // Виведення мінімальної маси
        System.out.println("Maximum Height: " + maxHeight); // Виведення максимальної висоти
        System.out.println("Average Max Energy: " + averageMaxEnergy); // Виведення середньої максимальної енергії
    }
}
