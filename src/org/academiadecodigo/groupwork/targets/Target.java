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
    public void move(){}




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
