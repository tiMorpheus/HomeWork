package com.timorpheus.oop.ingridients;

public abstract class Cheese  extends Ingredient{

    public Cheese(String name, float calories) {
        super(name, calories);
    }

    public Cheese(float calories) {
        super(calories);
    }
}
