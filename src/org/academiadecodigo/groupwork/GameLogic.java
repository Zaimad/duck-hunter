package org.academiadecodigo.groupwork;

import org.academiadecodigo.groupwork.keyboard.Keyboard;
import org.academiadecodigo.groupwork.mouse.Mouse;
import org.academiadecodigo.groupwork.targets.Duck;
import org.academiadecodigo.groupwork.targets.Target;
import org.academiadecodigo.groupwork.targets.TargetFactory;

import java.util.ArrayList;

public class GameLogic {

    Field field;
    ArrayList<Target> targets;
    PlayerInterface player;
    Keyboard k;
    Mouse m;
    GameState gameState;

    private int delay = 200; //5 actions per second @ 200


    public GameLogic() {
        field = new Field(800,600,"/org/academiadecodigo/groupwork/images/background.png"); //TODO: implement background image
        targets = new ArrayList<>();
        player = new PlayerInterface(field);

        gameState = GameState.GAMEON; //TODO: change to menu once a menu is created

    }


    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        field.init();

        //generateStartingTargets();
        //collisionDetector = new CollisionDetector(cars);

        //New test targets below!
        targets.add(new Duck(field));
        targets.add(new Duck(field));


        //Player Interface
        player.initiateListeners();

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        player.draw();
        int workingX = 0;
        int workingY = 0;

        while (true) {

            // Pause for a while
            Thread.sleep(delay);


            if (gameState == GameState.GAMEON) {
                //resolveMouseEvents();
                if (player.getIsMouseClicked()) { //The mouse was clicked and thus must be resolved
                    workingX = player.getMouseValueX();
                    workingY = player.getMouseValueY();
                    for (Target t : targets) {
                        if (
                                (t.getHitboxTopLeftX() <= workingX) && (workingX <= t.getHitboxTopLeftX()+t.getHitboxWidth() )
                                && (t.getHitboxTopLeftY() <= workingY) && (workingY <= t.getHitboxTopLeftY()+t.getHitboxHeight() )
                        ) { //Target was hit
                            t.setDead();
                        }
                    } //Resolved all possible targets
                    player.releaseClickLogic(); //Make the mouse click be consumed.
                }
                //resolveKeyboardEvents();

                //moveAllTargets();
                for (Target t : targets) {
                    if (!t.isDead()) {
                        t.move();
                    }
                } //All targets moved

            } //End of GAMEON logic loop

            //Pre-end-of-cycle setups such as change in GameState

        }

    }


    private void generateStartingTargets() {
        TargetFactory.generate();
    }

    //Private enum to control game's logic flow
    private enum GameState {
        MENU,
        GAMEON,
        GAMEOVER;
    }


}
