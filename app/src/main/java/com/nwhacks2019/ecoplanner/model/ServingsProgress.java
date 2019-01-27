package com.nwhacks2019.ecoplanner.model;

public class ServingsProgress implements Progress {
    private double servingsNotEaten;
    public static enum Food{BEEF, CHICKEN,PORK,FISH,EGGS,DAIRY};

    public Food type;
    public ServingsProgress(double servingsNotEaten,ServingsProgress.Food type){
        this.servingsNotEaten = servingsNotEaten;
        this.type = type;
    }
    public void display(){
        // display somehow
    }
}
