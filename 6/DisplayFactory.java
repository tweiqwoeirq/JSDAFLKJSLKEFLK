public class DisplayFactory {
    public static Displayable createDisplayable(CalculationData data) {
        return new TextDisplay(data); // Фабрика створює об'єкт відображення на основі даних обчислень
    }
}
