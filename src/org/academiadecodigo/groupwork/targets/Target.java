package org.academiadecodigo.groupwork.targets;

import org.academiadecodigo.groupwork.Field;
import org.academiadecodigo.groupwork.FieldSection;
import org.academiadecodigo.groupwork.Randomizer;
import org.academiadecodigo.groupwork.graphics.Color;
import org.academiadecodigo.groupwork.graphics.Rectangle;

import static org.academiadecodigo.groupwork.Randomizer.*;

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
    Field field;

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


        System.out.println(getX());
        direction = direction(); //checks edges
        updatePosition(getX()+direction.getDx(),getY()+direction.getDy());
        image.translate(direction.getDx(),direction.getDy());
        hitbox.translate(direction.getDx(),direction.getDy());

    }

    //A method to set the directions;
    public TargetDirection direction(){

        if(getX()==10){
            return TargetDirection.values()[randomNumber(1,5)];
        }

        if(getX()==820){ //10+field.getWidth()-image.getWidth())
            return TargetDirection.values()[specialRandom(1,8,2,3,4)];
        }

        if(getY()==10){
            return TargetDirection.values()[randomNumber(3,7)];
        }



        return TargetDirection.values()[specialRandom(1,8,4,5,6)];

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
