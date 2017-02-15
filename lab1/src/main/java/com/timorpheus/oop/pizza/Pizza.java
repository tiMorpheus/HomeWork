package com.timorpheus.oop.pizza;

import com.timorpheus.oop.comparator.CaloriesComparator;
import com.timorpheus.oop.ingridients.Cheese;
import com.timorpheus.oop.ingridients.Dough;
import com.timorpheus.oop.ingridients.Ingredient;
import com.timorpheus.oop.ingridients.Sauce;


import java.util.*;

public class Pizza {

    private Set<Ingredient> ingredients = new LinkedHashSet<>();

    public void setDough(Dough dough) {
        ingredients.add(dough);
    }

    public void setSauce(Sauce sauce) {
        ingredients.add(sauce);
    }

    public void setCheese(Cheese cheese) {
        ingredients.add(cheese);
    }

    public void addIngredients(Ingredient ingredient) {
        if (ingredient instanceof Dough || ingredient == null){
            throw new IllegalArgumentException();
        }

        ingredients.add(ingredient);
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public float getPizzaCalories() {
        float calories = 0.0f;

        for (Ingredient ingredient : ingredients) {
            calories += ingredient.getCalories();
        }

        return calories;
    }

    private Set<Ingredient> sort(Comparator<Ingredient> comparator) {
        Set<Ingredient> sorted = new TreeSet<>(comparator);
        sorted.addAll(ingredients);
        ingredients = sorted;

        return ingredients;
    }


    public Set<Ingredient> sortByCalories() {
        return sort(CaloriesComparator.getInstance());
    }

    public List<Ingredient> getIngredientsByRangeOfCalories(float from, float to) {
        if ((from < 0) || (to < 0) || from > to) {
            throw new IllegalArgumentException();
        }

        List<Ingredient> list = new ArrayList<>();

        for (Ingredient ingredient : ingredients) {
            float calories = ingredient.getCalories();
            if (calories <= to && calories >= from) {
                list.add(ingredient);
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "ingredients=" + ingredients +
                '}';
    }
}
