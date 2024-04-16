// Клас, що реалізує інтерфейс Displayable для відображення даних у текстовому форматі
public class TextDisplay implements Displayable {
    private CalculationData data; // Поля для зберігання даних про обчислення

    // Конструктор класу для ініціалізації даних
    public TextDisplay(CalculationData data) {
        this.data = data;
    }

    // Метод для відображення даних у вигляді таблиці
    @Override
    public void display() {
        System.out.println("--------------------------------------------------");
        System.out.println("| Параметр           | Значення               |");
        System.out.println("--------------------------------------------------");
        System.out.println(String.format("| %-20s | %-20.2f |", "Маса", data.getMass())); // Виведення маси
        System.out.println(String.format("| %-20s | %-20.2f |", "Висота", data.getHeight())); // Виведення висоти
        System.out.println(String.format("| %-20s | %-20.2f |", "Максимальна енергія", data.getMaxEnergy())); // Виведення максимальної енергії
        System.out.println("--------------------------------------------------");
    }
}
