package org.academiadecodigo.groupwork;

import org.academiadecodigo.groupwork.targets.Target;

import java.util.ArrayList;

public class GameLogic {

    Field field;
    ArrayList<Target> targets;

    private int delay = 200; //5 actions per second @ 200


    public GameLogic() {
        field = new Field(800,600,"NOIMAGEYET.png"); //TODO: implement background image
        targets = new ArrayList<>();


    }


    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        field.init();

        //cars = new Car[manufacturedCars];
        //collisionDetector = new CollisionDetector(cars);



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

            //resolveMouseEvents();

            //resolveKeyboardEvents();

            //moveAllTargets();

        }

    }

}
