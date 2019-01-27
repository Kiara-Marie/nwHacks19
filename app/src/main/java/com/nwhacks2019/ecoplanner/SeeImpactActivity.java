package com.nwhacks2019.ecoplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nwhacks2019.ecoplanner.Controller.Controller;
import com.nwhacks2019.ecoplanner.model.Goal;
import com.nwhacks2019.ecoplanner.model.Progress;

public class SeeImpactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_impact);
        if (Controller.user != null){
            for (Goal g: Controller.user.goals){
                g.getProgress().display();
            }
        }
    }
}
