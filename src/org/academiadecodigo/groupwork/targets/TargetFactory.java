package org.academiadecodigo.groupwork.targets;

import org.academiadecodigo.groupwork.Field;

public class TargetFactory {

    public static Target generate(Field field) {
        //teste
        final int DUCKWIDTH = 80;
        final int DUCKHEIGHT = 50;

        int alien = (int) Math.floor(Math.random()*4);

        String path = "org/academiadecodigo/groupwork/images/";
        String[] image = new String[] {"alien1.png", "aliens2.png", "aliens3.png", "alien4.png" };

        return new Duck(field, (int) ( (Math.random()*(field.getWidth() - 100)) + 50), (int) ( (Math.random()*(field.getHeight() - 100)) +50), path+image[alien]);

    }

}
