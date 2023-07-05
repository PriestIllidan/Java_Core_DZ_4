package task_02;

public enum Discount {
    ZERO(1),
    FIVE(0.95),
    TEN(0.9),
    FIFTEEN(0.85),
    TWENTY(0.8);

    private double VALUE;

    Discount(double value) {
        this.VALUE = value;
    }

    public double getVALUE() {
        return VALUE;
    }
}

