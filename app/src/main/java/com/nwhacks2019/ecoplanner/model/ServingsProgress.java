package com.nwhacks2019.ecoplanner.model;

import android.widget.ImageView;

import com.nwhacks2019.ecoplanner.FrontEnd.GoalType;

import java.util.ArrayList;
import java.util.HashMap;

public class ServingsProgress implements Progress {
    private double servingsNotEaten;
    private ArrayList<Progress> subs;
    public static enum Food{BEEF, CHICKEN,PORK,FISH,EGGS,DAIRY};

    private static final HashMap<GoalType.types,Double> litresPerServing = new HashMap();
    static{
        litresPerServing.put(GoalType.types.BEEF, new Double(10));
        litresPerServing.put(GoalType.types.CHICKEN,new Double(10) );
        litresPerServing.put(GoalType.types.DAIRY, new Double(10));
        litresPerServing.put(GoalType.types.EGGS,new Double(10));
        litresPerServing.put(GoalType.types.PORK,new Double(10));
    };

    public Food type;
    public ServingsProgress(double servingsNotEaten,ServingsProgress.Food type){
        this.servingsNotEaten = servingsNotEaten;
        this.type = type;
    }
    public String words(){
        this.makeSubs();
        String words = "";
        for (Progress p : subs){
            words.concat(p.words());
        }
        return words;
    }
    @Override
    public boolean hasImg() {
        return false;
    }

    public ImageView getImage(){
        return null;
    }
    
    private void makeSubs(){
        Double d = litresPerServing.get(this.type);
        double litresSaved = litresPerServing.get(this.type)*this.servingsNotEaten;
        LitresProgress lp = new LitresProgress(litresSaved);
        subs.add(lp);
    }

}
