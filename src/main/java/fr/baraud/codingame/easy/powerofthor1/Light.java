package fr.baraud.codingame.easy.powerofthor1;

class Light {

    private final Position position;

    private Light(Position position){
        this.position = position;
    }

    static Light atPosition(int x, int y){
        return new Light(new Position(x, y));
    }

    String directionFrom(Position position){
        return Direction.from(position).to(this.position);
    }
}
