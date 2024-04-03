import java.io.Serializable;

// Клас для зберігання параметрів і результатів обчислень
public class CalculationData implements Serializable {
    private static final long serialVersionUID = 1L; // версія серіалізації
    
    private double mass; // маса
    private double height; // висота
    private double maxEnergy; // найбільше значення енергії

    // Конструктор класу
    public CalculationData(double mass, double height, double maxEnergy) {
        this.mass = mass;
        this.height = height;
        this.maxEnergy = maxEnergy;
    }

    // Геттери та сеттери для доступу до полів класу
    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(double maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    // Перевизначення методу toString() для зручного виводу
    @Override
    public String toString() {
        return "CalculationData{" +
                "mass=" + mass +
                ", height=" + height +
                ", maxEnergy=" + maxEnergy +
                '}';
    }
}
