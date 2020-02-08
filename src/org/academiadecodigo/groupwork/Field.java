package org.academiadecodigo.groupwork;

import org.academiadecodigo.groupwork.graphics.Canvas;
import org.academiadecodigo.groupwork.pictures.Picture;

public class Field {

    //===============================PROPERTIES===============================//


    private Picture background;

    public final static int PADDING = 10;

    private int width;
    private int height;


    //===============================CONSTRUCTOR===============================//


    public Field(int width, int height, String backgroundImage){
        background = new Picture(width, height, backgroundImage);
        this.width = width;
        this.height = height;
    }


    //===============================METHODS===============================//


    //Getters.
    public int getHeight() {
        return height + PADDING;
    }

    public int getWidth() {
        return width + PADDING;
    }
}
