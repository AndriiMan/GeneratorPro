package service;

import model.Drink;
import model.Meal;
import model.MealType;
import model.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {

    public List<MenuItem> generate(MealType... types) {
        List<MenuItem> mealCategoriesList = new ArrayList<>();

        for (MealType meal : types) {
            mealCategoriesList.add(getMenuCategory(meal));
        }

        return mealCategoriesList;
    }

    private MenuItem getMenuCategory(MealType day) {
        List<Meal> meals = getGeneratedMeal();
        Drink drink = getGenerateDrink();
        return new MenuItem(day, meals, drink);
    }

    private Drink getGenerateDrink() {
        return returnRandomDrink();
    }

    private List<Meal> getGeneratedMeal() {
        return returnRandomMeal();
    }

    private Drink returnRandomDrink() {
        List<String> cocacolaIngredients = Arrays.asList("Кофеїн", "Вода");
        List<String> tea1Ingredients = Arrays.asList("Обліпиха", "Вода");
        List<String> tea2Ingredients = Arrays.asList("Ромашка", "Вода");

        Drink cocacola = new Drink("Кока кола Standart", cocacolaIngredients, 100, 20, 50);
        Drink tea1 = new Drink("Чай обліпиховий", tea1Ingredients, 100, 20, 57);
        Drink tea2 = new Drink("Чай ромашковий", tea2Ingredients, 100, 20, 50);
        List<Drink> drinkList = Arrays.asList(cocacola, tea1, tea2);

        return getRandomDrink(drinkList);
    }

    private List<Meal> returnRandomMeal() {
        List<String> ingredientsBorshch = Arrays.asList("Зелень", "Буряк", "Цибуля", "М'ясо");
        List<String> ingredientskasha1 = List.of("Гречка");
        List<String> ingredientssupgrechany = Arrays.asList("Зелень", "Гречка", "Цибуля", "Картопля");

        Meal borshch = new Meal("Борщ", ingredientsBorshch, 110, 60, 50, "Суп");
        Meal kasha1 = new Meal("Гречана каша", ingredientskasha1, 80, 120, 250, "Каша");
        Meal supgrechany = new Meal("Гречаний суп", ingredientssupgrechany, 115, 100, 150, "Суп");

        List<Meal> mealsList = Arrays.asList(borshch, kasha1, supgrechany);

        return Stream.concat(getMealsSup(mealsList).stream(), getMealsKasha(mealsList).stream())
                .collect(Collectors.toList());
    }

    private Drink getRandomDrink(List<Drink> drinkList) {
        Collections.shuffle(drinkList);
        return drinkList.stream()
                .findAny()
                .get();
    }

    private List<Meal> getMealsSup(List<Meal> mealsList) {
        Collections.shuffle(mealsList);
        return mealsList.stream().filter(name -> name.getType().equals("Суп"))
                .limit(1)
                .collect(Collectors.toList());
    }

    private List<Meal> getMealsKasha(List<Meal> mealsList) {
        Collections.shuffle(mealsList);
        return mealsList.stream().filter(name -> name.getType().equals("Каша"))
                .limit(1)
                .collect(Collectors.toList());
    }


    /* public List<MenuItem> getMenu(List<MealType> meals) {

         List<MenuItem> mealCategoriesList = new ArrayList<>();

         for (MealType meal : meals) {
             mealCategoriesList.add(getMenuCategory(meal));
         }

         return mealCategoriesList;
     }*/
}
