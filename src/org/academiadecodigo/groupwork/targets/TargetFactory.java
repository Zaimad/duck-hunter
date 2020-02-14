package org.academiadecodigo.groupwork.targets;

import org.academiadecodigo.groupwork.Field;

public class TargetFactory {

    public static Target generate(Field field) {
        //teste
        final int DUCKWIDTH = 80;
        final int DUCKHEIGHT = 50;

        int alien = (int) Math.floor(Math.random()*4);

        return new Duck(field, (int) (Math.random()*field.getWidth()) - DUCKWIDTH, (int) (Math.random()*field.getHeight()) - DUCKHEIGHT);

    }

}
