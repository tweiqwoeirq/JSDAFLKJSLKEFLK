import java.util.List;

public class EnergyCalculator {
    public static double calculateMaxEnergy(double mass, double height) {
        return mass * height * 9.8;
    }

    public static double calculateMaxEnergy(double mass, double height, double gravitationalAcceleration) {
        return mass * height * gravitationalAcceleration;
    }

    public static double calculateMaxEnergy(CalculationData data) {
        return data.getMass() * data.getHeight() * 9.8;
    }

    // Паралельна обробка елементів колекції для пошуку мінімуму, максимуму та обчислення середнього значення
    public static void processCollection(List<CalculationData> collection) {
        double minMass = collection.parallelStream().mapToDouble(CalculationData::getMass).min().orElse(0);
        double maxHeight = collection.parallelStream().mapToDouble(CalculationData::getHeight).max().orElse(0);
        double averageMaxEnergy = collection.parallelStream().mapToDouble(CalculationData::getMaxEnergy).average().orElse(0);

        System.out.println("Minimum Mass: " + minMass);
        System.out.println("Maximum Height: " + maxHeight);
        System.out.println("Average Max Energy: " + averageMaxEnergy);
    }
}