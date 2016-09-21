package fr.baraud.codingame.easy.powerofthor1;

public class Light {

    private final Position position;

    public Light(Position position){
        this.position = position;
    }

    public static Light atPosition(int x, int y){
        return new Light(new Position(x, y));
    }

    String directionFrom(Position position){
        return Direction.from(position).to(this.position);
    }
}
