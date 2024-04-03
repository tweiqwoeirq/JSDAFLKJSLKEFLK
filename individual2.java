import java.util.Scanner;

public class individual2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запитайте користувача на введення значень маси та висоти
        System.out.print("Введіть масу: ");
        int mass = scanner.nextInt();
        System.out.print("Введіть висоту: ");
        int height = scanner.nextInt();

        // Обчислення потенційної енергії
        double potentialEnergy = mass * height * 9.81; // Припускаємо прискорення вільного падіння 9.81 м/с^2

        // Перетворення потенційної енергії в двійкове представлення
        String binaryRepresentation = Integer.toBinaryString((int) potentialEnergy);

        // Знаходження найбільшої послідовності одиниць у двійковому представленні
        int maxSequence = findMaxConsecutiveOnes(binaryRepresentation);

        System.out.println("Найбільша послідовність одиниць у двійковому представленні потенційної енергії: " + maxSequence);

        scanner.close();
    }

    // Функція для знаходження найбільшої послідовності одиниць у рядку
    public static int findMaxConsecutiveOnes(String s) {
        int maxCount = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }

        return maxCount;
    }
}
