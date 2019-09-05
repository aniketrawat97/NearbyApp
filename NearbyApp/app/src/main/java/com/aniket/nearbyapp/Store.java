package com.aniket.nearbyapp;

import java.util.ArrayList;

public class Store {
    public String name,email,address,GPS;
    public ArrayList<Card> cards;

    public Store(String name, String email, String address, String GPS) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.GPS = GPS;
    }
}
