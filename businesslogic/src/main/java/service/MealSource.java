package service;

import model.Meal;

import java.util.List;

public interface MealSource {
    Meal getMeal();

    List<Meal> getMeals();
}
