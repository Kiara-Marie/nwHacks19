package com.nwhacks2019.ecoplanner.FrontEnd;

import android.view.View;

import com.nwhacks2019.ecoplanner.model.FoodReduce;
import com.nwhacks2019.ecoplanner.model.Goal;
import com.nwhacks2019.ecoplanner.model.ServingsProgress;
import com.nwhacks2019.ecoplanner.model.ShowerShorten;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Set;

public class GoalType {
    private static  enum types{
        SHOWER,BEEF, CHICKEN,PORK,FISH,EGGS,DAIRY};
    private static final HashMap<types,Class> classes = new HashMap();
    static{
         classes.put(types.SHOWER, ShowerShorten.class);
         classes.put(types.BEEF, FoodReduce.class);
        classes.put(types.CHICKEN, FoodReduce.class);
        classes.put(types.DAIRY, FoodReduce.class);
        classes.put(types.EGGS, FoodReduce.class);
        classes.put(types.PORK, FoodReduce.class);
    };
    private static final HashMap<types,Object> args = new HashMap();
    static{
        args.put(types.SHOWER, null);
        args.put(types.BEEF, ServingsProgress.Food.BEEF);
        args.put(types.CHICKEN,ServingsProgress.Food.CHICKEN);
        args.put(types.EGGS,ServingsProgress.Food.EGGS);
        args.put(types.DAIRY,ServingsProgress.Food.DAIRY);
        args.put(types.PORK,ServingsProgress.Food.PORK);
    };
    public String name;
    public View.OnClickListener onClick;

    public GoalType(String name){
        this.name = name;
    }

    public Goal construct(){
        Goal ret = null;
        try {
            if (args.get(this.name) == null) {
                Constructor<Goal> toCall = classes.get(this.name).getConstructor();
                ret = toCall.newInstance(new Goal[]{});
            } else{
                Object arg = args.get(this.name);
                Constructor<Goal> toCall = classes.get(this.name).getConstructor();
                ret = toCall.newInstance(new Goal[]{},arg);

            }
        } catch(Exception e){
            System.out.println("You made a mistake Kiara!");
        }
        return ret;
    }
}
