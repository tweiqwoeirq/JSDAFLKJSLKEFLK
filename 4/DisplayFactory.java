public class DisplayFactory {
    // Фабричний метод для створення об'єкта, який реалізує інтерфейс Displayable
    public static Displayable createDisplayable(CalculationData data) {
        return new TextDisplay(data);
    }
}
