package com.aniket.nearbyapp.models;

import android.graphics.Bitmap;

public class Card {
    public String title,desc1,desc2,offer,beforePrice,finalPrice;
    public Bitmap image;

    public Card(String title, String desc1, String desc2, String offer, String beforePrice, String finalPrice) {
        this.title = title;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.offer = offer;
        this.beforePrice = beforePrice;
        this.finalPrice = finalPrice;
    }

    public Card() {
    }
}
