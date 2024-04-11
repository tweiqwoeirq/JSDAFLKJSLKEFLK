public class ChangeMassCommand implements Command {
    private CalculationData data;
    private double previousMass;

    public ChangeMassCommand(CalculationData data, double newMass) {
        this.data = data;
        this.previousMass = data.getMass();
        data.setMass(newMass);
    }

    @Override
    public void execute() {
        // Зміна маси вже відбулася в конструкторі
    }

    @Override
    public void undo() {
        data.setMass(previousMass);
    }
}
