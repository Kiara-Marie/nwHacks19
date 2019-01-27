package com.nwhacks2019.ecoplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.nwhacks2019.ecoplanner.Controller.Controller;
import com.nwhacks2019.ecoplanner.FrontEnd.GoalAdapter;
import com.nwhacks2019.ecoplanner.FrontEnd.GoalType;
import com.nwhacks2019.ecoplanner.model.ShowerShorten;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    public CategoryActivity(){
        super();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // Construct the data source
        ArrayList<GoalType> goalTypes = Controller.goalCat.goalsInCat;
        // Create the adapter to convert the array to views
        for (GoalType gt : goalTypes){
            TypeDecisionListener curr = new TypeDecisionListener();
            gt.onClick = curr;
            curr.gt = gt;
        }
        GoalAdapter adapter = new GoalAdapter(this, goalTypes);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.goal_list);
        listView.setAdapter(adapter);
    }
    public class TypeDecisionListener implements View.OnClickListener {
        public GoalType gt;
        public TypeDecisionListener(){
        }
        public void onClick(View v) {
            Controller.goalType = gt;
            startActivity(new Intent(CategoryActivity.this, GoalActivity.class));
        }
    }
}