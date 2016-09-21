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

    private final int xCoordFrom;
    private final int yCoordFrom;

     private Direction(int xCoordFrom, int yCoordFrom){
         this.xCoordFrom = xCoordFrom;
         this.yCoordFrom = yCoordFrom;
     }

    public static Direction from(int x, int y) {
        return new Direction(x, y);
    }

    public String to(int xCoordTo, int yCoordTo){
        StringBuffer direction = new StringBuffer();
        direction.append(xCoordTo > xCoordFrom ? SOUTH: xCoordTo < xCoordFrom ? NORTH : "");
        direction.append(yCoordTo > yCoordFrom ? EAST : yCoordTo < yCoordFrom? WEST : "");
        return direction.toString();
    }


}
