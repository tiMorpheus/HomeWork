package timur.task20.figures;

import timur.task20.Figure;

public class F implements Figure {
    private String form = "F";


    @Override
    public String draw() {
        return form;
    }
}
