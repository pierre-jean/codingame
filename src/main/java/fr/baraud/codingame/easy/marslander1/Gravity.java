package fr.baraud.codingame.easy.marslander1;

public class Gravity {

    private final double valueInMeterSecondSquare;

    public Gravity(double valueInMeterSecondSquare) {
        this.valueInMeterSecondSquare = valueInMeterSecondSquare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gravity gravity = (Gravity) o;

        return Double.compare(gravity.valueInMeterSecondSquare, valueInMeterSecondSquare) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(valueInMeterSecondSquare);
        return (int) (temp ^ (temp >>> 32));
    }
}
