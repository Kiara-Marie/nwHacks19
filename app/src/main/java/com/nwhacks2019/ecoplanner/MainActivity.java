package com.nwhacks2019.ecoplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void seeGoalsOnClick(View v) {
        startActivity(new Intent(MainActivity.this, SeeGoalsActivity.class));
    }

    public void newGoalOnClick(View v){
        startActivity(new Intent(MainActivity.this, NewGoalActivity.class));
    }

    public void seeImpactOnClick(View v){
        startActivity(new Intent(MainActivity.this, SeeImpactActivity.class));
    }

}
