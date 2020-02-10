package org.academiadecodigo.groupwork;

public class Main {

    public static void main(String[] args) {

        GameLogic gl = new GameLogic();

        gl.init();

        try {
            gl.start();
        } catch (Exception e) {
            System.out.println("Process interrupted. Ending game...");
        } finally {
            System.out.println(" < Game Over > ");
        }


    }

}
