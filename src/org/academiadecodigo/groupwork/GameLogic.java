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

    private final int YERROR = 35;

    private int delay = 25; //5 actions per second @ 200


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
        //targets.add(new Duck(field,100, 50));
        //targets.add(new Duck(field,200,450));

        generateStartingTargets();

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
                    System.out.println("\nMouse click resolution in progress.");
                    workingX = player.getMouseValueX();
                    workingY = player.getMouseValueY();
                    System.out.println("Click registered: x = "+workingX+", y = "+workingY);
                    for (Target t : targets) {
                        t.debugOutputPosition();
                        //System.out.println(t.compareHitbox(workingX,workingY));
                        /*
                        if (
                                (t.getHitboxTopLeftX() <= workingX) && (workingX <= t.getHitboxTopLeftX()+t.getHitboxWidth() )
                                && (t.getHitboxTopLeftY() <= workingY + YERROR) && (workingY <= t.getHitboxTopLeftY()+t.getHitboxHeight() + YERROR )
                        ) { //Target was hit
                            t.setDead();
                            System.out.println("Target "+t+" hit. (on normal calc)");
                        }
                        //*/
                        if (t.compareHitbox(workingX,workingY)) {
                            t.setDead();
                            System.out.println("Target "+t+" hit. (on compare hitbox)");
                        }
                    } //Resolved all possible targets
                    //System.out.println("Releasing mouse");
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

            else if (gameState == GameState.MENU) {
                //Menu logic

            }

            else if (gameState == GameState.GAMEOVER) {

            }

            //Pre-end-of-cycle setups such as change in GameState

        }

    }


    private void generateStartingTargets() {
        targets.add(TargetFactory.generate(field));
        targets.add(TargetFactory.generate(field));
        targets.add(TargetFactory.generate(field));
    }

    //Private enum to control game's logic flow
    private enum GameState {
        MENU,
        GAMEON,
        GAMEOVER;
    }


}
