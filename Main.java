public class Main {
    public static void main(String[] args) {
        System.out.println("Кількість аргументів командного рядка: " + args.length);
        
        System.out.println("Передані аргументи:");
        for (int i = 0; i < args.length; i++) {
            System.out.println((i + 1) + ": " + args[i]);
        }
    }
}
