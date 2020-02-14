package org.academiadecodigo.groupwork.targets;

import org.academiadecodigo.groupwork.Field;

public class Duck extends Target {

	private int hitpoints;


    /*
    public Duck(Field field) {
        //This is wrong should be in FieldSection
        this(field, (Math.random()>0.5 ? 0 : 720), (int) (350*Math.random()));//put -this here temporarly
        this.direction=TargetDirection.EAST;
    } */

    public Duck(Field field, int x, int y) {
        super(field, x, y);
        this.direction=TargetDirection.EAST;
    }


    public void kill() {
    	setDead();
    }

    @Override
    public void move() {
        super.move();
    }
}
