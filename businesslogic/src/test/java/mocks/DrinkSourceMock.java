package mocks;

import model.Drink;
import service.DrinkSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DrinkSourceMock implements DrinkSource {
    @Override
    public Drink getDrink() {
        return randomDrink();
    }

    private Drink randomDrink() {
        List<String> cocacolaIngredients = Arrays.asList("Кофеїн", "Вода");
        List<String> tea1Ingredients = Arrays.asList("Обліпиха", "Вода");
        List<String> tea2Ingredients = Arrays.asList("Ромашка", "Вода");

        Drink cocacola = new Drink.DrinkBuilder()
                .name("Кока кола Standart")
                .ingredients(cocacolaIngredients)
                .caloriesPerStoGram(100)
                .gram(20)
                .pricePerStoGram(50)
                .build();

        Drink tea1 = new Drink.DrinkBuilder()
                .name("Чай обліпиховий")
                .ingredients(tea1Ingredients)
                .caloriesPerStoGram(100)
                .gram(20)
                .pricePerStoGram(57)
                .build();

        Drink tea2 = new Drink.DrinkBuilder()
                .name("Чай ромашковий")
                .ingredients(tea2Ingredients)
                .caloriesPerStoGram(109)
                .gram(10)
                .pricePerStoGram(50)
                .build();

        List<Drink> drinkList = Arrays.asList(cocacola, tea1, tea2);

        return getRandomDrink(drinkList);
    }

    private Drink getRandomDrink(List<Drink> drinkList) {
        Collections.shuffle(drinkList);
        return drinkList.stream()
                .findAny()
                .get();
    }
}
