package timur.task20.figures;

import timur.task20.Figure;

public class SuperFigure implements Figure {
    private String form = "SUPERFIGURE";


    @Override
    public String draw() {
        return form;
    }
}
