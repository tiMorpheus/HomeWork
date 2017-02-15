package com.timorpheus.oop.comparator;

import com.timorpheus.oop.ingridients.Ingredient;

import java.util.Comparator;

public final class CaloriesComparator implements Comparator<Ingredient> {
    private static CaloriesComparator caloriesComparator;

    private CaloriesComparator() {

    }

    public static CaloriesComparator getInstance() {
        if (caloriesComparator == null) {
            caloriesComparator = new CaloriesComparator();
        }
        return  caloriesComparator;
    }

    @Override
    public int compare(Ingredient ingredient1, Ingredient ingredient2) {
        Float calories1 = ingredient1.getCalories();
        Float calories2 = ingredient2.getCalories();

        return calories1.compareTo(calories2);
    }
}