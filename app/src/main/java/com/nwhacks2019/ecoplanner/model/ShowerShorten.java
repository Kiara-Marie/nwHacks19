package com.nwhacks2019.ecoplanner.model;

import com.nwhacks2019.ecoplanner.Exceptions.GoalFailedException;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ShowerShorten extends Goal {

    private int before; // in minutes
    private int after; // in minutes
    private double rate = 9.46; // in litres per minute

    public ShowerShorten(){

    }

    public void current(String current) throws GoalFailedException{
        try{
            this.before = Integer.parseInt(current);
        }
        catch(NumberFormatException e){
            throw new GoalFailedException();
        }
        if (this.before < 0){
            throw new GoalFailedException("Minutes must be greater than 0");
        }
    }
    public void future(String future) throws GoalFailedException{
        try{
            this.after = Integer.parseInt(future);
        }
        catch(NumberFormatException e){
            throw new GoalFailedException();
        }
        if (this.after < 0){
            throw new GoalFailedException("Minutes must be greater than 0");
        } else if (this.after < this.before){
            throw new GoalFailedException("Please make goal number of minutes less than current.");
        }
    }

    public Progress getProgress(){
        Date today = new Date();
        long diffInMillies = Math.abs(today.getTime() - this.startDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        double litresSaved = diff * (this.before - this.after) * this.rate;
        this.progress = new LitresProgress(litresSaved);
        return this.progress;
    }

}

