package com.nwhacks2019.ecoplanner.FrontEnd;
import android.view.View;

import java.util.ArrayList;
import java.util.Set;

public class GoalCategory {

    public ArrayList<GoalType> goalsInCat;
    public String name;
    public View.OnClickListener onClick;

    public GoalCategory(String name, ArrayList<GoalType> goalsInCat, View.OnClickListener onClickListener){
        this.name = name;
        this.goalsInCat = goalsInCat;
        this.onClick = onClickListener;
    }
}
