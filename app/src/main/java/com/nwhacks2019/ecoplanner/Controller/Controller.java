package com.nwhacks2019.ecoplanner.Controller;

import com.nwhacks2019.ecoplanner.Exceptions.GoalFailedException;
import com.nwhacks2019.ecoplanner.FrontEnd.GoalCategory;
import com.nwhacks2019.ecoplanner.FrontEnd.GoalType;
import com.nwhacks2019.ecoplanner.model.Goal;
import com.nwhacks2019.ecoplanner.model.User;

public class Controller {
    public static GoalCategory goalCat;
    public static GoalType goalType;
    public static Goal goal;
    public static User user = new User(1);

    public static void createGoal() throws GoalFailedException {
        goal = goalType.construct();
        user.setGoal(goal);
    }

    public static void updateGoalPlan(String futureSetting) throws GoalFailedException{
        goal.future(futureSetting);
    }
    public static void updateGoalCurr(String currSetting) throws GoalFailedException{
        goal.current(currSetting);
    }
}
