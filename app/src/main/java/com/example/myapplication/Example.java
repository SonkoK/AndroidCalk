package com.example.myapplication;

public class Example {

    private String base;

    private Rates rates;

    private String date;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Example withBase(String base) {
        this.base = base;
        return this;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public Example withRates(Rates rates) {
        this.rates = rates;
        return this;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Example withDate(String date) {
        this.date = date;
        return this;
    }

}

