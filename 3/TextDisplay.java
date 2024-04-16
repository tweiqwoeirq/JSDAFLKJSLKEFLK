public class TextDisplay implements Displayable {
    private CalculationData data;

    // Конструктор класу
    public TextDisplay(CalculationData data) {
        this.data = data;
    }

    // Метод для відображення даних
    @Override
    public void display() {
        System.out.println(data.toString());
    }
}
