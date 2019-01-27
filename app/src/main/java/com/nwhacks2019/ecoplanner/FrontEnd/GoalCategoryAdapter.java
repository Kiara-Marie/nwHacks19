package com.nwhacks2019.ecoplanner.FrontEnd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nwhacks2019.ecoplanner.FrontEnd.GoalCategory;
import com.nwhacks2019.ecoplanner.R;

import java.util.ArrayList;

public class GoalCategoryAdapter extends ArrayAdapter<GoalCategory> {
    public GoalCategoryAdapter(Context context, ArrayList<GoalCategory> goalCats) {
        super(context, 0, goalCats);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        GoalCategory goalCat = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_goal_category, parent, false);
        }
        // Lookup view for data population
        TextView gcName = (TextView) convertView.findViewById(R.id.gcName);
        // Populate the data into the template view using the data object
        gcName.setText(goalCat.name);
        gcName.setTextColor(getContext().getResources().getColor(R.color.colorPrimaryDark));
        gcName.setTextSize(25);
        gcName.setBackgroundColor(getContext().getResources().getColor(R.color.colorAccentFade));
        gcName.setOnClickListener(goalCat.onClick);
        // Return the completed view to render on screen
        return convertView;
    }

}
