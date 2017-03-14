package timur.task20.figures;

import timur.task20.Figure;

public class I implements Figure{

    private String form = "I";


    @Override
    public String draw() {
        return form;
    }
}
