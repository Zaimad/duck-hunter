package org.academiadecodigo.groupwork.targets;

public enum TargetDirection {

    NORTH(0,-10),
    NORTHEAST(-10,10),
    EAST(10,0),
    SOUTHEAST(10,10),
    SOUTH(0,10),
    SOUTHWEST(-10,10),
    WEST(-10,0),
    NORTHWEST(-10,-10);

    private int dx;
    private int dy;

    TargetDirection(int dx, int dy){
        this.dx=dx;
        this.dy=dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public TargetDirection oppositeDirection(){
        TargetDirection opposite=null;

        switch (this) {
            case NORTH:
                opposite = SOUTH;
                break;
            case NORTHEAST:
                opposite=SOUTHWEST;
                break;
            case EAST:
                opposite=WEST;
            case SOUTHEAST:
                opposite=NORTHWEST;
                break;
            case SOUTH:
                opposite=NORTH;
                break;
            case SOUTHWEST:
                opposite=NORTHEAST;
                break;
            case WEST:
                opposite=EAST;
                break;
            case NORTHWEST:
                opposite=SOUTHEAST;
                break;
        }

        return opposite;
    }
}
