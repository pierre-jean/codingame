package fr.baraud.codingame.easy.powerofthor1;

import java.util.Objects;

class Position {
    private final int x;
    private final int y;

    Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    int x(){
        return x;
    }

    int y(){
        return y;
    }

    Position moveTo(String direction) {
        int newX =  direction.contains(Direction.WEST) ?  x-1 :
                direction.contains(Direction.EAST) ? x + 1 : x;
        int newY = direction.contains(Direction.NORTH) ? y-1 :
                direction.contains(Direction.SOUTH) ? y+1 : y;
        return new Position(newX, newY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null){
            return false;
        }
        if (this.getClass() != o.getClass()){
            return false;
        }
        Position position = (Position) o;
        return Objects.equals(x, position.x())
                && Objects.equals(y, position.y());
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("Position [ %d, %d ]", x, y);
    }
}
