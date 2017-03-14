package timur.task20.figures;

import timur.task20.Figure;

public class T implements Figure{

    private String form = "T";


    @Override
    public String draw() {
        return form;
    }
}
