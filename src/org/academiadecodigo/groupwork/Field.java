package org.academiadecodigo.groupwork;

import org.academiadecodigo.groupwork.graphics.Canvas;
import org.academiadecodigo.groupwork.graphics.Rectangle;
import org.academiadecodigo.groupwork.pictures.Picture;

public class Field {

    //===============================PROPERTIES===============================//


    private Picture background;
    //private Rectangle background;
    private Picture menuOverlay;

    public final static int PADDING = 10;

    private int width;
    private int height;


    //===============================CONSTRUCTOR===============================//


    public Field(int width, int height, String backgroundImage){
        background = new Picture(PADDING,PADDING, backgroundImage);
        //background = new Rectangle(PADDING,PADDING,width,height);
        this.width = width;
        this.height = height;

        menuOverlay = new Picture(PADDING,PADDING, "org/academiadecodigo/groupwork/images/start.png");

    }


    //===============================METHODS===============================//


    public void init() {
        draw();
    }


    public void draw() {
        background.draw();
        menuOverlay.draw();
    }

    //Getters.
    public int getHeight() {
        return height + PADDING;
    }

    public int getWidth() {
        return width + PADDING;
    }

    public int getX() {
        return PADDING;
    }

    public int getY() {
        return PADDING;
    }

    public void killMenu() {
        menuOverlay.delete();
    }


}
