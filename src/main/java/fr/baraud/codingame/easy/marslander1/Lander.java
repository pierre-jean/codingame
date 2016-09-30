package fr.baraud.codingame.easy.marslander1;

public class Lander {

    private final int x;
    private final int y;
    private final int hSpeed;
    private final int vSpeed;
    private final int fuel;
    private final int rotation;
    private final int power;

    Lander(int x, int y, int hSpeed, int vSpeed, int fuel, int rotation, int power){

        this.x = x;
        this.y = y;
        this.hSpeed = hSpeed;
        this.vSpeed = vSpeed;
        this.fuel = fuel;
        this.rotation = rotation;
        this.power = power;
    }

    public boolean hasLanded() {
        return true;
    }

    public Instruction getInstructionToLandOn(Landscape marsLandscape) {
        return new Instruction();
    }

    @Override
    public String toString() {
        return "Lander{" +
                "x=" + x +
                ", y=" + y +
                ", hSpeed=" + hSpeed +
                ", vSpeed=" + vSpeed +
                ", fuel=" + fuel +
                ", rotation=" + rotation +
                ", power=" + power +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lander lander = (Lander) o;

        if (x != lander.x) return false;
        if (y != lander.y) return false;
        if (hSpeed != lander.hSpeed) return false;
        if (vSpeed != lander.vSpeed) return false;
        if (fuel != lander.fuel) return false;
        if (rotation != lander.rotation) return false;
        return power == lander.power;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + hSpeed;
        result = 31 * result + vSpeed;
        result = 31 * result + fuel;
        result = 31 * result + rotation;
        result = 31 * result + power;
        return result;
    }
}
