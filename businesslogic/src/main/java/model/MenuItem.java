package model;

import java.util.List;

public class MenuItem {
    private MealType typeOfDayMeal;
    private List<Meal> meals;
    private Drink drink;


    public List<Meal> getMeals() {
        return meals;
    }

    public MenuItem(MealType typeOfDayMeal, List<Meal> meals, Drink drink) {
        this.typeOfDayMeal = typeOfDayMeal;
        this.meals = meals;
        this.drink = drink;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public MealType getTypeOfDayMeal() {
        return typeOfDayMeal;
    }

    public void setTypeOfDayMeal(MealType typeOfDayMeal) {
        this.typeOfDayMeal = typeOfDayMeal;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }
}
