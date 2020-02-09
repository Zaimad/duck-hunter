package org.academiadecodigo.groupwork.targets;

import org.academiadecodigo.groupwork.Field;

public class Duck extends Target {

	private int hitpoints;



    public Duck(Field field) {
        super(field);
    }

    public Duck(Field field, int x, int y) {
        super(field, x, y);
    }


    public void kill() {
    	setDead();
    }



}
