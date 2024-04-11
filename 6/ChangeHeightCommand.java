public class ChangeHeightCommand implements Command {
    private CalculationData data;
    private double previousHeight;

    public ChangeHeightCommand(CalculationData data, double newHeight) {
        this.data = data;
        this.previousHeight = data.getHeight();
        data.setHeight(newHeight);
    }

    @Override
    public void execute() {
        // Зміна висоти вже відбулася в конструкторі
    }

    @Override
    public void undo() {
        data.setHeight(previousHeight);
    }
}
