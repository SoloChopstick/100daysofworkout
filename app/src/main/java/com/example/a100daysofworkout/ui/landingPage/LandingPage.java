package com.example.a100daysofworkout.ui.landingPage;
public class LandingPage {
    private int currentWeight;
    private int targetWeight;
    private int currentCalories;
    private int targetCalories;

    public LandingPage() {}

    public LandingPage(int currentWeight, int targetWeight, int currentCalories, int targetCalories) {
        this.currentWeight = currentWeight;
        this.targetWeight = targetWeight;
        this.currentCalories = currentCalories;
        this.targetCalories = targetCalories;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getTargetWeight() {
        return targetWeight;
    }

    public int getCurrentCalories() {
        return currentCalories;
    }

    public int getTargetCalories() {
        return targetCalories;
    }
}