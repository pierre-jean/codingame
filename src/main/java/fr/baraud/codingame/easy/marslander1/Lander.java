package fr.baraud.codingame.easy.marslander1;

public class Lander {
    private static final int LANDING_MAX_SPEED = -40;
    private static final int MAX_POWER = 4;
    final int x;
    final int y;
    final int hSpeed;
    final int vSpeed;
    final int fuel;
    final int rotation;
    final int power;

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

    public Instruction getInstructionToLandOn(Landscape marsLandscape)
    {
        Lander landerWithLessPower = Builder.buildLander()
                .fromLander(this)
                .decreasePower()
                .next()
                .build();
        if (landerWithLessPower.canStopInTimeOn(marsLandscape)){
            return Instruction.decreasePower(this);
        }
        if (this.canStopInTimeOn(marsLandscape)){
            return Instruction.keepGoing(this);
        }
        return Instruction.increasePower(this);
    }

    private boolean canStopInTimeOn(Landscape landscape) {
        if (landscape.collide(getPositionLanding(landscape))){
            return false;
        }
        return true;
    }

    private Position getPositionLanding(Landscape landscape) {
        if (this.vSpeed > LANDING_MAX_SPEED){
            return currentPosition();
        }
        if (Math.abs(landscape.gravity().value()) > MAX_POWER){
            throw new RuntimeException("Gravity too strong to slow down with this engine");
        }
        Lander nextRoundLander = Builder.buildLander()
                .fromLander(this)
                .increasePower()
                .next()
                .build();
        return nextRoundLander.getPositionLanding(landscape);
    }

    private Position currentPosition() {
        return new Position(x, y);
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
