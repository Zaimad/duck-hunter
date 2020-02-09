package org.academiadecodigo.groupwork.targets;

import org.academiadecodigo.groupwork.Field;
import org.academiadecodigo.groupwork.FieldSection;

public class Target extends FieldSection {

//===============================PROPERTIES===============================//

    //Coordinates.
    //These are in the superclass, FieldSection

    //Status.
    private boolean isDead;

//===============================CONSTRUCTOR===============================//


    public Target(Field field) {
        super(field);
    }

    public Target(Field field, int x, int y) {
        super(field, x, y);
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
