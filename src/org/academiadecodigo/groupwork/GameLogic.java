package org.academiadecodigo.groupwork;

public class GameLogic {

    Field field;

    private int delay = 200; //5 actions per second @ 200

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        //field.init();

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
