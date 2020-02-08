package org.academiadecodigo.groupwork;

public class FieldSection {

    //===============================PROPERTIES===============================//

    private int xTopLeft, yTopLeft;
    private int width, height;
    private Field field;


    //===============================CONSTRUCTOR===============================//

    public FieldSection(Field field){
        this.field = field;
        xTopLeft = field.getX();
        yTopLeft = field.getY();
    }

    public FieldSection(Field field, int x, int y){
        this.field = field;
        xTopLeft = x + field.getX();
        yTopLeft = y + field.getY();
    }

    //===============================METHODS===============================//








}
