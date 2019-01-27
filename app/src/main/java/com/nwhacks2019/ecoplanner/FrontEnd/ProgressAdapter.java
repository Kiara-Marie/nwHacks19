package com.nwhacks2019.ecoplanner.FrontEnd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.nwhacks2019.ecoplanner.R;
import com.nwhacks2019.ecoplanner.model.Progress;

import java.util.ArrayList;

public class ProgressAdapter extends ArrayAdapter<Progress> {
    public ProgressAdapter(Context context, ArrayList<Progress> progs) {
        super(context, 0, progs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Progress prog = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_progress, parent, false);
        }
        // Lookup view for data population
        TableLayout progressView = (TableLayout) convertView.findViewById(R.id.progressView);
        // Populate the data into the template view using the data object
        if (prog.hasImg()){
            ImageView progImg = prog.getImage();
            progressView.addView(progImg);
        }
        TextView progText = new TextView(this.getContext());
        progText.setText(prog.words());
        progressView.addView(progText);

        // Return the completed view to render on screen
        return convertView;
    }

}
