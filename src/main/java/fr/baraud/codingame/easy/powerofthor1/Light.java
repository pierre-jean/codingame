package fr.baraud.codingame.easy.powerofthor1;

public class Light {

    private int x;
    private int y;

    public Light(int x, int y){
        this.x = x;
        this.y = y;
    }

    String directionFrom(int xFrom, int yFrom){
        return Direction.from(xFrom, yFrom).to(x, y);
    }
}
