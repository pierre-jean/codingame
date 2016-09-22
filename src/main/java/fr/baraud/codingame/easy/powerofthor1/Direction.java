package fr.baraud.codingame.easy.powerofthor1;

public class Direction {

    public final static String NORTH = "N";
    public final static String NORTH_EAST = "NE";
    public final static String EAST = "E";
    public final static String SOUTH_EAST = "SE";
    public final static String SOUTH = "S";
    public final static String SOUTH_WEST = "SW";
    public final static String WEST = "W";
    public final static String NORTH_WEST = "NW";

    private Position from;

     private Direction(Position from){
         this.from = from;
     }

    public static Direction from(Position position) {
        return new Direction(position);
    }

    public String to(Position to){
        StringBuffer direction = new StringBuffer();
        direction.append(to.y() > from.y() ? SOUTH : to.y() < from.y() ? NORTH : "");
        direction.append(to.x() > from.x() ? EAST: to.x() < from.x() ? WEST : "");
        return direction.toString();
    }
}
