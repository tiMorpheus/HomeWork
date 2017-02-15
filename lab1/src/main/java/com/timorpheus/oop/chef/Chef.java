package com.timorpheus.oop.chef;

import com.timorpheus.oop.builder.PizzaBuilder;
import com.timorpheus.oop.pizza.Pizza;

public class Chef {

    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void createPizza() {

        pizzaBuilder.createPizza();
        pizzaBuilder.prepare();
        pizzaBuilder.bake();
        pizzaBuilder.cut();
        pizzaBuilder.box();
    }
}
