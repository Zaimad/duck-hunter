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

        generateStartingTargets();
        //collisionDetector = new CollisionDetector(cars);

        //New test targets below!
        targets.add(new Duck(field,10,10));
        targets.add(new Duck(field, 400, 300));

        //Player Interface
        player.initiateListeners();

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);


            if (gameState == GameState.GAMEON) {
                //resolveMouseEvents();

                //resolveKeyboardEvents();

                //moveAllTargets();
            }

            //Pre-end-of-cycle setups such as change in GameState

        }

    }


    private void generateStartingTargets() {
        TargetFactory.generate();
    }

    private enum GameState {
        MENU,
        GAMEON,
        GAMEOVER;
    }


}
