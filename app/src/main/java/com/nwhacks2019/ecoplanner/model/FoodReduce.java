package com.nwhacks2019.ecoplanner.model;

import com.nwhacks2019.ecoplanner.Exceptions.GoalFailedException;

import org.json.JSONObject;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FoodReduce extends Goal {
    private int doubleBefore;
    private int doubleAfter;
    private ServingsProgress.Food type;
    public FoodReduce(ServingsProgress.Food type){
        this.type = type;
    }

    public Progress getProgress() {
        Date today = new Date();
        long diffInMillies = Math.abs(today.getTime() - this.startDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        double servingsNotEaten = (diff * (double)(this.doubleBefore - this.doubleAfter)) / 2 ;
        this.progress = new ServingsProgress(servingsNotEaten,this.type);
        return this.progress;
    }

    public void current(String current) throws GoalFailedException {
        try {
            this.doubleBefore = (int) (2 * Double.parseDouble(current));
        } catch (NumberFormatException e) {
            throw new GoalFailedException();
        }
        if (this.doubleBefore < 0) {
            throw new GoalFailedException("Servings must be greater than 0");
        }
    }

    public void future(String future) throws GoalFailedException {
        try {
            this.doubleAfter = (int) (2 * Double.parseDouble(future));
        } catch (NumberFormatException e) {
            throw new GoalFailedException();
        }
        if (this.doubleAfter < 0) {
            throw new GoalFailedException("Servings must be greater than 0");
        }
    }
}
