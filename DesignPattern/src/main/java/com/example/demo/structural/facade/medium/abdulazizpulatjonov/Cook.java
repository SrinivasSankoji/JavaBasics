package com.example.demo.structural.facade.medium.abdulazizpulatjonov;

public class Cook {

    private Breakfast breakfast;
    private Lunch lunch;
    private Dinner dinner;

    public Cook() {
        this.breakfast = new Breakfast();
        this.lunch = new Lunch();
        this.dinner = new Dinner();
    }

    public String prepareBreakfast() {
        return breakfast.prepare();
    }

    public String prepareLunch() {
        return lunch.prepare();
    }

    public String prepareDinner() {
        return dinner.prepare();
    }
}
