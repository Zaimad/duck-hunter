package org.academiadecodigo.groupwork;

import org.academiadecodigo.groupwork.graphics.Canvas;
import org.academiadecodigo.groupwork.graphics.Rectangle;
import org.academiadecodigo.groupwork.pictures.Picture;

public class Field {

    //===============================PROPERTIES===============================//


    //private Picture background;
    private Rectangle background;

    public final static int PADDING = 10;

    private int width;
    private int height;


    //===============================CONSTRUCTOR===============================//


    public Field(int width, int height, String backgroundImage){
        //background = new Picture(width, height, backgroundImage);
        background = new Rectangle(PADDING,PADDING,width,height);
        this.width = width;
        this.height = height;
    }


    //===============================METHODS===============================//


    public void init() {
        draw();
    }


    public void draw() {
        background.draw();
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

}
