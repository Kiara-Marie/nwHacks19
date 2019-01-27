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
    public static  enum types{
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
    private static final HashMap<types,String> toDisplay = new HashMap();
    static{
        toDisplay.put(types.SHOWER, "Shower Shorten");
        toDisplay.put( types.BEEF,"Reduce beef consumption");
        toDisplay.put(types.CHICKEN,"Reduce chicken consumption");
        toDisplay.put(types.EGGS,"Reduce egg consumption");
        toDisplay.put(types.DAIRY,"Reduce dairy consumption");
        toDisplay.put(types.PORK,"Reduce pork consumption");
    };
    public String name;
    public types type;
    public View.OnClickListener onClick;

    public GoalType(GoalType.types type){
        this.type = type;
        this.name = toDisplay.get(type);
    }

    public Goal construct(){
        Goal ret = null;
        try {
            if (args.get(this.type) == null) {
                Constructor<Goal> toCall = classes.get(this.type).getConstructor();
                ret = toCall.newInstance(new Goal[]{});
            } else{
                Object arg = args.get(this.type);
                Class myClass = classes.get(this.type);
                Constructor<Goal> myConstr = myClass.getConstructor(arg.getClass());
                Constructor<Goal> toCall = classes.get(this.type).getConstructor(arg.getClass());
                ret = toCall.newInstance(arg);

            }
        } catch(Exception e){
            System.out.println("You made a mistake Kiara!");
        }
        return ret;
    }
}
