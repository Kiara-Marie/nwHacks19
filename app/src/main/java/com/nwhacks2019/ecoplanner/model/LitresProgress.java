package com.nwhacks2019.ecoplanner.model;

public class LitresProgress implements Progress {
    public double litresSaved;

    public LitresProgress(double litres){
        this.litresSaved = litres;
    }

    @Override
    public void display() {
        // display somehow
    }
}
