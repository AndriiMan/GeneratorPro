package model;

import java.util.List;

public class Drink {

    private String name;
    private List<String> ingredients;
    private int caloriesPerStoGram;
    private int gram;
    private int pricePerStoGram;
    private int calories;
    private int price;

    public Drink() {

    }

    public Drink(String name, List<String> ingredients, int caloriesPerStoGram, int gram, int pricePerStoGram) {
        this.name = name;
        this.ingredients = ingredients;
        this.caloriesPerStoGram = caloriesPerStoGram;
        this.gram = gram;
        this.pricePerStoGram = pricePerStoGram;
        this.calories = (gram * caloriesPerStoGram) / 100;
        this.price = (pricePerStoGram * gram) / 100;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getCaloriesPerStoGram() {
        return caloriesPerStoGram;
    }

    public void setCaloriesPerStoGram(int caloriesPerStoGram) {
        this.caloriesPerStoGram = caloriesPerStoGram;
    }

    public int getGram() {
        return gram;
    }

    public void setGram(int gram) {
        this.gram = gram;
    }

    public int getPricePerStoGram() {
        return pricePerStoGram;
    }

    public void setPricePerStoGram(int pricePerStoGram) {
        this.pricePerStoGram = pricePerStoGram;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
