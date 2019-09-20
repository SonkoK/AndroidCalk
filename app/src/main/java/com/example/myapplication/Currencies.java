package com.example.myapplication;

import android.media.Image;

public class Currencies {
    private String curensyName;
    private int image;
    private double rate;

    public Currencies(String curensyName, int image, double rate) {
        this.curensyName = curensyName;
        this.image = image;
        this.rate = rate;
    }
    public Currencies(){}

    public String getCurensyName() {
        return curensyName;
    }

    public void setCurensyName(String curensyName) {
        this.curensyName = curensyName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
