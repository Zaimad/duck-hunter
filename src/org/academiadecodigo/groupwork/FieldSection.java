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

    public int getTopLeftX() {
    	return xTopLeft;
    }

    public int getTopLeftY() {
    	return yTopLeft;
    }

    public int getHitboxTopLeftX() {
    	return xInnerTopLeft;
    }

    public int getHitboxTopLeftY() {
    	return yInnerTopLeft;
    }

    public int getImageWidth() {
    	return width;
    }

    public int getImageHeight() {
    	return height;
    }

    public int getHitboxWidth() {
    	return innerWidth;
    }

    public int getHitboxHeight() {
    	return innerHeight;
    }

    //Use this method in the constructor OR an init() method, maybe both if in doubt
    public void setNewInnerHitbox(int dx, int dy) {
    	xInnerTopLeft = xTopLeft + dx;
    	yInnerTopLeft = yTopLeft + dy;
    }


    //Method to compare if a point (x,y) is inside the HITBOX
    public boolean compareHitbox(int x, int y) {
    	if (x <= xInnerTopLeft + innerWidth && x >= xInnerTopLeft && y <= yInnerTopLeft + innerHeight && y >= yInnerTopLeft)
    		return true;
    	else return false;
    }

    //This method MUST move BOTH the IMAGE AND HITBOX positions
    public void updatePosition(int dx, int dy) {
        xTopLeft=xTopLeft+dx;
        yTopLeft=yTopLeft+dy;
    }




}
