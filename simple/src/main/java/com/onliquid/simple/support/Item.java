package com.onliquid.simple.support;


public class Item {

    private String mCurrency;
    private String mName;
    private double mPrice;
    private String mType;

    public Item(String s, String s1, double d) {
        mName = s;
        mType = s1;
        mPrice = d;
        mCurrency = "€";
    }

    public String getCurrency() {
        return mCurrency;
    }

    public String getName() {
        return mName;
    }

    public double getPrice() {
        return mPrice;
    }

    public String getPriceCurrency() {
        return mPrice + mCurrency;
    }

    public String getType() {
        return mType;
    }

    public void setCurrency(String s) {
        mCurrency = s;
    }

    public void setName(String s) {
        mName = s;
    }

    public void setPrice(float f) {
        mPrice = f;
    }

    public void setType(String s) {
        mType = s;
    }
}
