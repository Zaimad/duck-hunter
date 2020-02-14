package org.academiadecodigo.groupwork;

public class FieldSection {

    //===============================PROPERTIES===============================//

    private int xTopLeft, yTopLeft;
    private int xInnerTopLeft, yInnerTopLeft; //Used for the actual hitbox calculations
    private int width, height; //Used for the IMAGE box, not the hitbox.
    private int innerWidth, innerHeight; //Used for the hitbox calculations
    private Field field;


    //===============================CONSTRUCTOR===============================//

    /*
    public FieldSection(Field field){
        this.field = field;
        xTopLeft = field.getX();
        yTopLeft = field.getY();
    } */

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

    public int getFieldRightLimit() {
        return field.getWidth();
    }

    public int getFieldBottomLimit() {
        return field.getHeight();
    }

    public int getFieldTopLimit() {
        return field.getY();
    }

    public int getFieldLeftLimit() {
        return field.getX();
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
        xInnerTopLeft=xInnerTopLeft+dx;
        yInnerTopLeft=yInnerTopLeft+dy;
    }

    public void setInnerWidth(int wide) {
        innerWidth = wide;
    }

    public void setInnerHeight(int high) {
        innerHeight = high;
    }

    public void setImageWidthAndHeight(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setAbsolutePosition(int imageX, int imageY) {
        xTopLeft = imageX;
        yTopLeft = imageY;
    }

    public void setAbsoluteHitboxPosition(int hitboxX, int hitboxY) {
        xInnerTopLeft = hitboxX;
        yInnerTopLeft = hitboxY;
    }

    public void debugOutputPosition() {
        System.out.println("Hitbox topleft coordinates: x = "+getHitboxTopLeftX()+", y = "+getHitboxTopLeftY());
    }



}
