package com.nwhacks2019.ecoplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newGoalButton = (Button) findViewById(R.id.NewGoalButton);
        makeListener(newGoalButton,NewGoalActivity.class);

        Button seeGoalsButton = (Button) findViewById(R.id.SeeGoalsButton);
        makeListener(seeGoalsButton,SeeGoalsActivity.class);

        Button seeImpactButton = (Button) findViewById(R.id.SeeImpactButton);
        makeListener(seeImpactButton,SeeImpactActivity.class);

    }

    private void makeListener(Button b, final Class c){
        View.OnClickListener newGoalListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,c));
            }
        };
        if (b != null) {
            b.setOnClickListener(newGoalListener);
        }
    }


}
