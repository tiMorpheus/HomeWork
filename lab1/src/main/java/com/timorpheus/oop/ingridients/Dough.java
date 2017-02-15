package com.timorpheus.oop.ingridients;

public abstract class Dough extends Ingredient{

    private float diametr;

    public Dough(float diametr) {
        this.diametr = diametr;
    }

    public Dough(float calories, float diametr) {
        super(calories);
        this.diametr = diametr;
    }


    public float getDiametr() {
        return diametr;
    }

    public void setDiametr(float diametr) {
        this.diametr = diametr;
    }
}
