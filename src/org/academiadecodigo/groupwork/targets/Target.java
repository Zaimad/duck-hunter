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
        updatePosition(direction.getDx(),+direction.getDy());
        image.translate(direction.getDx(),direction.getDy());
        hitbox.translate(direction.getDx(),direction.getDy());

    }

    //A method to set the directions;
    public TargetDirection direction(){

        TargetDirection newDirection = direction;
        int yUpperEdge = 10; //Padding
        int yDownEdge=400;   //Bottom of the green
        int xLeftEdge=10;   //Padding
        int xRightEdge=720; //Field.width-image.getWidth;


        if(getX()<=xLeftEdge){ //Left border



            while(newDirection.getDx()==-10){ //must return direction that doesn't decrease X

                newDirection=TargetDirection.values()[(int) (Math.random() * TargetDirection.values().length)];

            }

            if (getY() <= yUpperEdge) {

                while (newDirection.getDy() == -10 && newDirection.getDx()==-10) { //must return direction that doesn't decrease X

                    newDirection = TargetDirection.values()[(int) (Math.random() * TargetDirection.values().length)];

                }
            }

            if (getY() >= yDownEdge) {

                while (newDirection.getDy() == 10 && newDirection.getDx()==-10) { //must return direction that doesn't decrease X

                    newDirection = TargetDirection.values()[(int) (Math.random() * TargetDirection.values().length)];

                }
            }


            return newDirection;

        }


        if(getX()>=xRightEdge){

            while(newDirection.getDx()==10){ //the direction can't increase 10

                newDirection=TargetDirection.values()[(int) (Math.random() * TargetDirection.values().length)];

            }

            if (getY() <= yUpperEdge) {

                while (newDirection.getDy() == -10 && newDirection.getDx()==10) { //must return direction that doesn't decrease X

                    newDirection = TargetDirection.values()[(int) (Math.random() * TargetDirection.values().length)];

                }
            }

            if (getY() >= yDownEdge) {

                while (newDirection.getDy() == 10 && newDirection.getDx()==10) { //must return direction that doesn't decrease X

                    newDirection = TargetDirection.values()[(int) (Math.random() * TargetDirection.values().length)];

                }
            }
           return newDirection;

        }

        if(getY()<=yUpperEdge){ //Upper corner

            while(newDirection.getDy()==-10){

                newDirection=TargetDirection.values()[(int) (Math.random() * TargetDirection.values().length)];

            }

            return newDirection;

        }

        if(getY()>=yDownEdge){ //Check Math

            while(newDirection.getDy()==10){

                newDirection=TargetDirection.values()[(int) (Math.random() * TargetDirection.values().length)];

            }

            return newDirection;

        }

        return newDirection;

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
