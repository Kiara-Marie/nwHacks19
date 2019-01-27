package com.nwhacks2019.ecoplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.nwhacks2019.ecoplanner.Controller.Controller;
import com.nwhacks2019.ecoplanner.FrontEnd.GoalCategory;
import com.nwhacks2019.ecoplanner.FrontEnd.GoalCategoryAdapter;
import com.nwhacks2019.ecoplanner.FrontEnd.GoalType;

import java.util.ArrayList;
import java.util.HashSet;

public class NewGoalActivity extends AppCompatActivity {

    public NewGoalActivity(){
        super();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_goal);
        // Construct the data source
        ArrayList<GoalCategory> goalCats = this.makeArray();
    // Create the adapter to convert the array to views
        GoalCategoryAdapter adapter = new GoalCategoryAdapter(this, goalCats);
    // Attach the adapter to a ListView
        ListView listView = findViewById(R.id.category_list);
        listView.setAdapter(adapter);
    }
    public class CategoryDecisionListener implements View.OnClickListener {
        public GoalCategory gc;
        public CategoryDecisionListener(){
        }
        public void onClick(View v) {
            Controller.goalCat = gc;
            startActivity(new Intent(NewGoalActivity.this, CategoryActivity.class));
        }
    }


    private ArrayList<GoalCategory> makeArray(){
        ArrayList<GoalCategory> goalCats = new ArrayList<GoalCategory>();

        GoalCategory diet = makeDiet();
        GoalCategory plastic = makePlastic();
        GoalCategory water = makeWater();

        goalCats.add(diet);
        goalCats.add(plastic);
        goalCats.add(water);
        return goalCats;
    }

    private GoalCategory makeWater(){
        ArrayList<GoalType> waterTypes = new ArrayList<>();
        View.OnClickListener waterListener = new CategoryDecisionListener();
        GoalType showerShorten = new GoalType("Shower Shorten");
        waterTypes.add(showerShorten);
        GoalCategory water = new GoalCategory("Water Use",waterTypes,waterListener);
        ((CategoryDecisionListener) waterListener).gc = water;
        return water;
    }

    private GoalCategory makePlastic(){
        ArrayList<GoalType> plasticTypes = new ArrayList<>();
        View.OnClickListener plasticListener = new CategoryDecisionListener();
        GoalCategory plastic = new GoalCategory("Plastic Use",plasticTypes,plasticListener);
        ((CategoryDecisionListener) plasticListener).gc = plastic;
        return plastic;
    }

    private GoalCategory makeDiet(){
        ArrayList<GoalType> dietTypes = new ArrayList<>();
        View.OnClickListener dietListener = new CategoryDecisionListener();
        GoalCategory diet = new GoalCategory("Diet",dietTypes,dietListener);
        ((CategoryDecisionListener) dietListener).gc = diet;
        return diet;
    }
}
