public class EnergyCalculator {
    // Метод для знаходження найбільшого значення енергії
    public static double calculateMaxEnergy(double mass, double height) {
        return mass * height * 9.8;
    }

    // Overloading: Додамо версію методу з трьома параметрами
    public static double calculateMaxEnergy(double mass, double height, double gravitationalAcceleration) {
        return mass * height * gravitationalAcceleration;
    }

    // Overloading: Додамо версію методу з параметром CalculationData
    public static double calculateMaxEnergy(CalculationData data) {
        return data.getMass() * data.getHeight() * 9.8;
    }
}