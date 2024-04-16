public class DisplayFactory {
    // Метод для створення об'єкта для відображення
    public static Displayable createDisplayable(CalculationData data) {
        return new TextDisplay(data);
    }
}
