public class TextDisplay implements Displayable {
    private CalculationData data;

    public TextDisplay(CalculationData data) {
        this.data = data;
    }

    @Override
    public void display() {
        System.out.println(data.toString());
    }
}