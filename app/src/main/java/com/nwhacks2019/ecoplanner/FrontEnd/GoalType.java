package com.nwhacks2019.ecoplanner.FrontEnd;

import android.view.View;

import com.nwhacks2019.ecoplanner.model.Goal;
import com.nwhacks2019.ecoplanner.model.ShowerShorten;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Set;

public class GoalType {
    private static final HashMap<String,Class> classes = new HashMap();
    static{
         classes.put("Shower Shorten", ShowerShorten.class);
    };
    public String name;
    public View.OnClickListener onClick;

    public GoalType(String name){
        this.name = name;
    }

    public Goal construct(){
        Goal ret = null;
        try {
            Constructor<Goal> toCall = classes.get(this.name).getConstructor();
            ret = toCall.newInstance(new Goal[]{});
        } catch(Exception e){
            System.out.println("You made a mistake Kiara!");
        }
        return ret;
    }
}
