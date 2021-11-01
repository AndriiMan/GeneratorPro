package model;

import java.util.List;

public class Drink {

    private String name;
    private List<String> ingredients;
    private int caloriesPerStoGram;
    private int gram;
    private int pricePerStoGram;

    public Drink() {

    }

    public Drink(DrinkBuilder drinkBuilder) {
        this.name = drinkBuilder.name;
        this.ingredients = drinkBuilder.ingredients;
        this.caloriesPerStoGram = drinkBuilder.caloriesPerStoGram;
        this.gram = drinkBuilder.gram;
        this.pricePerStoGram = drinkBuilder.pricePerStoGram;
    }

    public static class DrinkBuilder {

        private String name;
        private List<String> ingredients;
        private int caloriesPerStoGram;
        private int gram;
        private int pricePerStoGram;

        public DrinkBuilder() {
        }

        public DrinkBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DrinkBuilder ingredients(List<String> ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public DrinkBuilder caloriesPerStoGram(int caloriesPerStoGram) {
            this.caloriesPerStoGram = caloriesPerStoGram;
            return this;
        }

        public DrinkBuilder gram(int gram) {
            this.gram = gram;
            return this;
        }

        public DrinkBuilder pricePerStoGram(int pricePerStoGram) {
            this.pricePerStoGram = pricePerStoGram;
            return this;
        }

        public Drink build() {
            return new Drink(this);
        }

    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public int getCaloriesPerStoGram() {
        return caloriesPerStoGram;
    }

    public int getGram() {
        return gram;
    }

    public int getPricePerStoGram() {
        return pricePerStoGram;
    }
}
