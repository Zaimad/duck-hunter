package org.academiadecodigo.groupwork;


import org.academiadecodigo.groupwork.keyboard.KeyboardEvent;
import org.academiadecodigo.groupwork.mouse.MouseEvent;
import org.academiadecodigo.groupwork.mouse.MouseHandler;
import org.academiadecodigo.groupwork.keyboard.KeyboardHandler;

public class PlayerInterface extends FieldSection implements MouseHandler, KeyboardHandler {


    //===============================PROPERTIES===============================//









    //===============================CONSTRUCTOR===============================//


    public PlayerInterface(Field field) {
        super(field);
    }

    public PlayerInterface(Field field, int x, int y) {
        super(field, x, y);
    }


    //===============================METHODS===============================//

    //Shoot.
    public boolean shoot(int x, int y){
        return false;
    }


    //Keyboard events.
    @Override
    public void keyPressed(KeyboardEvent e) {

    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }

    //Mouse events.
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
