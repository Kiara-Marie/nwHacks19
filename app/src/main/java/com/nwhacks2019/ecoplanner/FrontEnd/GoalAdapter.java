package com.nwhacks2019.ecoplanner.FrontEnd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nwhacks2019.ecoplanner.R;

import java.util.ArrayList;

public class GoalAdapter extends ArrayAdapter<GoalType> {
    public GoalAdapter(Context context, ArrayList<GoalType> goals) {
        super(context, 0, goals);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        GoalType goalType = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_goal, parent, false);
        }
        // Lookup view for data population
        TextView goalName = (TextView) convertView.findViewById(R.id.goalName);
        // Populate the data into the template view using the data object
        goalName.setText(goalType.name);
        goalName.setOnClickListener(goalType.onClick);
        // Return the completed view to render on screen
        return convertView;
    }

}
