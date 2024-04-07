import java.io.Serializable;

// Клас для зберігання параметрів і результатів обчислень
public class CalculationData implements Serializable {
    private static final long serialVersionUID = 1L; // версія серіалізації
    
    private double Mass; // маса
    private double Height; // висота
    private double MaxEnergy; // найбільше значення енергії

    // Конструктор класу
    public CalculationData(double mass, double height, double maxEnergy) {
        this.Mass = mass;
        this.Height = height;
        this.MaxEnergy = maxEnergy;
    }

    // Геттери та сеттери для доступу до полів класу
    public double getMass() {
        return Mass;
    }

    public void setMass(double mass) {
        this.Mass = mass;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double height) {
        this.Height = height;
    }

    public double getMaxEnergy() {
        return MaxEnergy;
    }

    public void setMaxEnergy(double maxEnergy) {
        this.MaxEnergy = maxEnergy;
    }

    // Перевизначення методу toString() для зручного виводу
    @Override
public String toString() {
    
    return "CalculationData | Mass = " + Mass + " | Height = " + Height + " | MaxEnergy = " + MaxEnergy;
}

}
