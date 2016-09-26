package fr.baraud.codingame.easy.powerofthor1;

class Direction {

    final static String NORTH = "N";
    final static String NORTH_EAST = "NE";
    final static String EAST = "E";
    final static String SOUTH_EAST = "SE";
    final static String SOUTH = "S";
    final static String SOUTH_WEST = "SW";
    final static String WEST = "W";
    final static String NORTH_WEST = "NW";

    private Position from;

     private Direction(Position from){
         this.from = from;
     }

    static Direction from(Position position) {
        return new Direction(position);
    }

    String to(Position to){
        return (to.y() > from.y() ? SOUTH : to.y() < from.y() ? NORTH : "") +
                (to.x() > from.x() ? EAST : to.x() < from.x() ? WEST : "");
    }
}
