package com.timorpheus.oop.builder;

import com.timorpheus.oop.pizza.Pizza;

public abstract class PizzaBuilder {
    protected Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void createPizza() {
        pizza = new Pizza();
    }

    public abstract void prepare();


    public void bake() {
        System.out.println("Bake for 25 minutes at 250 degrees");
    }

    public void box() {
        System.out.println("Cutting the pizza into 8 same pieces");
    }


    public void cut() {
        System.out.println("Place pizza in box");
    }
}
