package org.academiadecodigo.groupwork.targets;

public enum TargetDirection {

    NORTH(0,-3),
    NORTHEAST(2,-2),
    EAST(3,0),
    SOUTHEAST(2,2),
    SOUTH(0,3),
    SOUTHWEST(-2,2),
    WEST(-3,0),
    NORTHWEST(-2,-2);

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
