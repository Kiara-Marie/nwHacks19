package com.nwhacks2019.ecoplanner.model;

import com.nwhacks2019.ecoplanner.Exceptions.GoalFailedException;
import com.nwhacks2019.ecoplanner.FrontEnd.GoalType;

import java.util.Date;

public abstract class Goal {
    protected Progress progress;
    protected Date startDate;
    protected GoalType type;

    public Goal(){
        this.startDate = new Date();
    }
    public Progress getProgress(){
        return this.progress;
    }
    public abstract void future(String future) throws GoalFailedException;
    public abstract void current(String current) throws GoalFailedException;

}
