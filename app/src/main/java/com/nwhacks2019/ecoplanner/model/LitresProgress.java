package com.nwhacks2019.ecoplanner.model;


import android.widget.ImageView;

public class LitresProgress implements Progress {
    public double litresSaved;

    public LitresProgress(double litres){
        this.litresSaved = litres;
    }

    public String words(){
        return String.format("You have saved %fL of water!\n",litresSaved);
    }
    @Override
    public boolean hasImg() {
        return false;
    }

    public ImageView getImage(){
        return null;
    }
}
