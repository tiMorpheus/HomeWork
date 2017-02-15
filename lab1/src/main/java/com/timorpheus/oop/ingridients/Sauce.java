package com.timorpheus.oop.ingridients;

public abstract class Sauce extends Ingredient {

    private boolean isHot;

    public Sauce() {
    }

    public Sauce(boolean isHot, float calories) {
        super(calories);
        this.isHot = isHot;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }
}
