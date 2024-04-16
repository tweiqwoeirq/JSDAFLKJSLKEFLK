// Фабричний клас для створення об'єктів типу Displayable
public class DisplayFactory {
    // Метод для створення об'єкта типу Displayable на основі CalculationData
    public static Displayable createDisplayable(CalculationData data) {
        return new TextDisplay(data);
    }
}
