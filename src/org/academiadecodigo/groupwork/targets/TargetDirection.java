package org.academiadecodigo.groupwork.targets;

public enum TargetDirection {

    NORTH(0,-10),
    NORTHEAST(-10,10),
    EAST(10,0),
    SOUTHEAST(10,10),
    SOUTH(0,10),
    SOUTHWEST(-10,10),
    WEST(-10,0);

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
}
