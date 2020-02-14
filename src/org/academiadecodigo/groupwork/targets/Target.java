package org.academiadecodigo.groupwork.targets;

import org.academiadecodigo.groupwork.Field;
import org.academiadecodigo.groupwork.FieldSection;
import org.academiadecodigo.groupwork.graphics.Color;
import org.academiadecodigo.groupwork.graphics.Rectangle;


public class Target extends FieldSection {

//===============================PROPERTIES===============================//

    //Coordinates.
    //These are in the superclass, FieldSection

    //Status.
    private boolean isDead;

    //Temp: Rectangle shapes!
    Rectangle image;
    Rectangle hitbox;

    //Moving Variables!
    TargetDirection direction;
    double directionChangeProbability=0.97;

//===============================CONSTRUCTOR===============================//


    public Target(Field field) {
        super(field);
        image = new Rectangle(getX(),getY(),80,50);
        image.draw();
        hitbox = new Rectangle(getX()+10,getY()+10,60,30);
        hitbox.setColor(Color.DARK_GRAY);
        hitbox.fill();
    }

    public Target(Field field, int x, int y) {
        super(field, x, y);
        image = new Rectangle(getX(),getY(),80,50);
        image.draw();
        hitbox = new Rectangle(getX()+10,getY()+10,60,30);
        hitbox.setColor(Color.DARK_GRAY);
        hitbox.fill();
    }

//===============================METHODS===============================//

    //Movement. TODO: IMPLEMENT METHOD.
    public void move(){


        direction = chooseDirection();

        if(isHittingWalls()){
            direction=direction.oppositeDirection();
        }

        updatePosition(direction.getDx(),direction.getDy());
        image.translate(direction.getDx(),direction.getDy());
        hitbox.translate(direction.getDx(),direction.getDy());

    }

    //A method to set the directions;
    private TargetDirection chooseDirection(){


        TargetDirection newDirection = direction;


        if (Math.random()>directionChangeProbability){
            newDirection=TargetDirection.values()[(int) (Math.random() * TargetDirection.values().length)];

            /**Can it perform u-Turns**/
        }


        return newDirection;
    }


    //Checks for edges
    private boolean isHittingWalls() {
        int yUpperEdge = getFieldTopLimit();
        int yDownEdge = getFieldBottomLimit() - this.getImageHeight();
        int xLeftEdge = getFieldLeftLimit();
        int xRightEdge = getFieldRightLimit() - this.getImageWidth();


        if (getX() < xLeftEdge || getX() > xRightEdge || getY() < yUpperEdge || getY() > yDownEdge) {
            return true;
        }

        return false;
    }


    //Change status.
    public void setDead(){
        isDead = true;
    }



    //Getters.
    public int getX() {
        return getTopLeftX();
    }


    public int getY() {
        return getTopLeftY();
    }


    public boolean isDead() {
        return isDead;
    }





}
