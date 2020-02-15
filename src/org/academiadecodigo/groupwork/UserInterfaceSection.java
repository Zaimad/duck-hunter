package org.academiadecodigo.groupwork;

import org.academiadecodigo.groupwork.graphics.Color;
import org.academiadecodigo.groupwork.graphics.Text;

public class UserInterfaceSection extends FieldSection{

    String displaying;
    Text text;

    public UserInterfaceSection(Field field, int x, int y, String string) {
        super(field, x, y);
        displaying = string;
    }

    public void draw() {
        text = new Text(getTopLeftX(),getTopLeftY(),displaying);
        text.setColor(Color.GREEN);
        text.draw();
    }

    public void update(String contents) {
        text.setText(contents);
        text.setColor(Color.GREEN);
        text.draw();
    }

}
