package org.academiadecodigo.groupwork;

import org.academiadecodigo.groupwork.keyboard.Keyboard;
import org.academiadecodigo.groupwork.mouse.Mouse;
import org.academiadecodigo.groupwork.targets.Target;
import org.academiadecodigo.groupwork.targets.TargetFactory;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import java.io.File;
import java.util.ArrayList;

public class GameLogic {

    private Field field;
    private ArrayList<Target> targets;
    private ArrayList<Target> removalQueue;
    private PlayerInterface player;
    private Keyboard k;
    private Mouse m;
    private GameState gameState;
    private double timer = 500;

    int score = 0;
    UserInterfaceSection uiScore;
    UserInterfaceSection timeToLose;

    File music;

    AudioInputStream ais;
    Clip soundClip;



    private final int YERROR = 35;

    private int delay = 25; //5 actions per second @ 200


    public GameLogic() {
        field = new Field(800,600, "resources/background_final.jpg");
        targets = new ArrayList<>();
        player = new PlayerInterface(field);
        removalQueue = new ArrayList<>();

        gameState = GameState.MENU;

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

        //Music here!
        try {
            music = new File("resources/TheMoonDucktales.wav");
            ais = AudioSystem.getAudioInputStream(music);
            soundClip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, ais.getFormat()));
            soundClip.open(ais);
            soundClip.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } //End of music setup section...


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

        gameState = GameState.MENU;
        field.draw();

        uiScore = new UserInterfaceSection(field,field.getX()+25,field.getY()+25, "Score: "+String.valueOf(score));
        uiScore.draw();

        timeToLose = new UserInterfaceSection(field, field.getX()+25, field.getY()+50, "Time to lose: "+ (timer/20));
        timeToLose.draw();

        while (true) {


            // Pause for a while
            Thread.sleep(delay);


            if (gameState == GameState.GAMEON) {

                for (Target t : targets) {
                    t.draw();
                }

                timeToLose.update(String.valueOf("Time to lose: "+ (timer/20)));

                //resolveMouseEvents();
                if (player.getIsMouseClicked()) { //The mouse was clicked and thus must be resolved
                    //System.out.println("\nMouse click resolution in progress.");
                    workingX = player.getMouseValueX();
                    workingY = player.getMouseValueY();
                    //System.out.println("Click registered: x = "+workingX+", y = "+workingY);
                    for (Target t : targets) {
                        //t.debugOutputPosition();
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
                        if (t.compareHitbox(workingX,workingY-20)) {
                            t.setDead();
                            //play a death sound here?
                            removalQueue.add(t);
                            score++;
                            uiScore.update("Score: "+String.valueOf(score));
                            //System.out.println("Target "+t+" hit. (on compare hitbox)");
                        }
                    } //Resolved all possible targets
                    //System.out.println("Releasing mouse");
                    player.releaseClickLogic(); //Make the mouse click be consumed.
                }
                //resolveKeyboardEvents();

                //handle target removal
                while (removalQueue.size() > 0) {
                    targets.removeAll(removalQueue);
                    removalQueue.removeAll(removalQueue);
                }

                //Spawn targets if all dead
                if (targets.size() == 0) {
                    targets.add(TargetFactory.generate(field));
                    targets.add(TargetFactory.generate(field));
                    targets.add(TargetFactory.generate(field));
                    timer = 500;
                }


                //moveAllTargets();
                for (Target t : targets) {
                    if (!t.isDead()) {
                        t.move();
                    }
                } //All targets moved

                timer--;
                if (timer == 0) {
                    gameState = GameState.GAMEOVER;
                    field.drawGameOver();
                } else if (timer % 100 == 0) {
                    int ranSpawn = (int) (Math.floor(Math.random()*10));
                    if (ranSpawn == 0) targets.add(TargetFactory.generate(field));
                }

            } //End of GAMEON logic loop

            else if (gameState == GameState.MENU) {
                //Menu logic
                if (player.getGameFlag()) {
                    gameState = GameState.GAMEON;
                    field.killMenu();
                }
            }

            else if (gameState == GameState.GAMEOVER) {
                //Show some message? Lock the score?

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
