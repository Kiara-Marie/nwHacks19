package com.nwhacks2019.ecoplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.nwhacks2019.ecoplanner.Controller.Controller;
import com.nwhacks2019.ecoplanner.FrontEnd.ProgressAdapter;
import com.nwhacks2019.ecoplanner.model.Goal;
import com.nwhacks2019.ecoplanner.model.Progress;

import java.util.ArrayList;

public class SeeImpactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_impact);
        if (Controller.user != null){
            ArrayList<Progress> allP = new ArrayList<Progress>();
            for (Goal g: Controller.user.goals){
                allP.add(g.getProgress());
            }
           ProgressAdapter adapter = new ProgressAdapter(this, allP);
            // Attach the adapter to a ListView
            ListView listView = findViewById(R.id.impact_list);
            listView.setAdapter(adapter);
        }
    }
}
