package com.nwhacks2019.ecoplanner;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.nwhacks2019.ecoplanner.Controller.Controller;
import com.nwhacks2019.ecoplanner.Exceptions.GoalFailedException;

public class GoalActivity extends AppCompatActivity {

    private  EditText enterCurr;
    private EditText enterGoal;
    private View mProgressView;
    private View mLoginFormView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        enterCurr = (EditText) findViewById(R.id.currHabit);
        enterGoal = (EditText) findViewById(R.id.newHabit);

        Button createGoalButton = (Button) findViewById(R.id.create_goal_button);
        createGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptCreateGoal();
            }
        });
    }

    private void attemptCreateGoal(){
        try {
            Controller.createGoal();
            Controller.updateGoalCurr(enterCurr.getText().toString());
            Controller.updateGoalPlan(enterGoal.getText().toString());
        } catch(GoalFailedException e){
/*            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            DialogInterface.OnClickListener positiveListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            };
            alertDialogBuilder.setPositiveButton(R.string.tryGoalAgain, positiveListener);
            if (!e.getMessage().equals("")){
                alertDialogBuilder.setMessage(e.getMessage());
            } else {
                alertDialogBuilder.setMessage("Something went wrong. Please try again");
            }
            alertDialogBuilder.create();
            alertDialogBuilder.show();*/
        }
        startActivity(new Intent(GoalActivity.this, MainActivity.class));
    }
}
