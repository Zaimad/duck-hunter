package org.academiadecodigo.groupwork;


import org.academiadecodigo.groupwork.keyboard.Keyboard;
import org.academiadecodigo.groupwork.keyboard.KeyboardEvent;
import org.academiadecodigo.groupwork.mouse.Mouse;
import org.academiadecodigo.groupwork.mouse.MouseEvent;
import org.academiadecodigo.groupwork.mouse.MouseEventType;
import org.academiadecodigo.groupwork.mouse.MouseHandler;
import org.academiadecodigo.groupwork.keyboard.KeyboardHandler;
import org.academiadecodigo.groupwork.pictures.Picture;

public class PlayerInterface extends FieldSection implements MouseHandler, KeyboardHandler {


    //===============================PROPERTIES===============================//
    private Picture crossHair;
    private Keyboard k;
    private Mouse m;


    private boolean isMouseClicked;

    //===============================CONSTRUCTOR===============================//


    public PlayerInterface(Field field) {
        super(field);
        crosshair();
        this.m = new Mouse(this);
        this.k = new Keyboard(this);
    }

    public PlayerInterface(Field field, int x, int y) {
        super(field, x, y);
        crosshair();
    }


    //===============================METHODS===============================//

    //Shoot.
    public boolean shoot(int x, int y){
        return false;
    }

    public boolean getIsMouseClicked() {
        return isMouseClicked;
    }

    public boolean releaseClickLogic() {
        return isMouseClicked = false;
    }

    private void crosshair() {
        crossHair = new Picture();
        crossHair.load("/org/academiadecodigo/groupwork/images/crosshair.png");
        //crossHair.draw();
    }

    public void draw() {
        crossHair.draw();
    }

    public int getMouseValueX() {
        return this.getTopLeftX();
    }

    public int getMouseValueY() {
        return this.getTopLeftY();
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
        int a = crossHair.getX() ;
        int b = crossHair.getY() ;
        crossHair.translate(e.getX()-a-(crossHair.getWidth()/2),e.getY()-b-(crossHair.getHeight()*1.5));
    }

    public void initiateListeners() {
        m.addEventListener(MouseEventType.MOUSE_MOVED);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        //k.addEventListener(EVENT);
    }

}
