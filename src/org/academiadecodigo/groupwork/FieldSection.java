package org.academiadecodigo.groupwork;

public class FieldSection {

    //===============================PROPERTIES===============================//

    private int xTopLeft, yTopLeft;
    private int xInnerTopLeft, yInnerTopLeft; //Used for the actual hitbox calculations
    private int width, height; //Used for the IMAGE box, not the hitbox.
    private int innerWidth, innerHeight; //Used for the hitbox calculations
    private Field field;


    //===============================CONSTRUCTOR===============================//

    public FieldSection(Field field){
        this.field = field;
        xTopLeft = field.getX();
        yTopLeft = field.getY();
    }

    public FieldSection(Field field, int x, int y){
        this.field = field;
        xTopLeft = x + field.getX();
        yTopLeft = y + field.getY();
    }

    //===============================METHODS===============================//

    public boolean compareHitbox(int x, int y) {
    	if (x <= xInnerTopLeft + innerWidth && x >= xInnerTopLeft && y <= yInnerTopLeft + innerHeight && y >= yInnerTopLeft)
    		return true;
    	else return false;
    }






}
