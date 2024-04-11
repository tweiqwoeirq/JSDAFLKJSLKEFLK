public class DisplayFactory {
    public static Displayable createDisplayable(CalculationData data) {
        return new TextDisplay(data);
    }
}