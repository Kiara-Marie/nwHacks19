package com.nwhacks2019.ecoplanner.model;

import com.nwhacks2019.ecoplanner.FrontEnd.GoalType;

import java.util.Date;

public abstract class Goal {
    private Progress progress;
    private Date startDate;
    private GoalType type;

    public Goal(){
        this.startDate = new Date();
    }
    public Progress getProgress(){
        return this.progress;
    }
    public abstract void future(String future);
    public abstract void current(String current);

}
