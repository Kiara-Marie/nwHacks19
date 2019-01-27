package com.nwhacks2019.ecoplanner.model;

import java.util.Date;

public abstract class Goal {
    private Progress progress;
    private Date startDate;

    public Goal(){
        this.startDate = new Date();
    }
    public Progress getProgress(){
        return this.progress;
    }
}
