package org.academiadecodigo.groupwork.targets;

import org.academiadecodigo.groupwork.Field;
import org.academiadecodigo.groupwork.FieldSection;
import org.academiadecodigo.groupwork.graphics.Color;
import org.academiadecodigo.groupwork.graphics.Rectangle;
import org.academiadecodigo.groupwork.pictures.Picture;


public class Target extends FieldSection {

//===============================PROPERTIES===============================//

    //Coordinates.
    //These are in the superclass, FieldSection

    //Status.
    private boolean isDead;

    //Temp: Rectangle shapes!
    Picture image;
    //Rectangle hitbox;

    //Moving Variables!
    TargetDirection direction;
    double directionChangeProbability=0.95;

//===============================CONSTRUCTOR===============================//

    /*
    public Target(Field field) {
        super(field);
        image = new Rectangle(getX(),getY(),80,50);
        image.draw();
        hitbox = new Rectangle(getX()+10,getY()+10,60,30);
        hitbox.setColor(Color.DARK_GRAY);
        hitbox.fill();
    } */

    public Target(Field field, int x, int y, String image) {
        super(field, x, y);
        this.image = new Picture(90,85,image);
        this.image.draw();
        this.image.translateToAbsolutePosition(x,y);

        setImageWidthAndHeight(90,85);

        super.setAbsoluteHitboxPosition(x,y);

        super.setNewInnerHitbox(0,0);

        super.setInnerWidth(90);
        super.setInnerHeight(85);

        //hitbox = new Rectangle(x+10,y+10,60,30);
        //hitbox.setColor(Color.DARK_GRAY);
        //hitbox.fill();
    }

//===============================METHODS===============================//

    //Movement. TODO: IMPLEMENT METHOD.
    public void move(){


        direction = chooseDirection();

        if(isHittingWalls()){
            direction=direction.oppositeDirection();
        }
        //debugOutputPosition();

        updatePosition(direction.getDx()*3,direction.getDy()*3);
        image.translate(direction.getDx()*3,direction.getDy()*3);
        //hitbox.translate(direction.getDx()*3,direction.getDy()*3);

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


        if (getX() + 10 <= xLeftEdge || getX() > xRightEdge
                || getY() + 10 <= yUpperEdge || getY() > yDownEdge) {
            return true;
        }

        return false;
    }


    //Change status.
    public void setDead(){
        isDead = true;
        image.delete();
        //hitbox.delete();
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
