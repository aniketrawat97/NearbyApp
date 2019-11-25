package com.aniket.nearbyapp.models;

import java.util.ArrayList;

public class Store {
    public String name,email,address,GPS,pass,email_pass;
    public ArrayList<Card> cards;

    public Store(String name, String email, String address, String GPS,String pass,ArrayList<Card> cards) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.GPS = GPS;
        this.pass=pass;
        this.email_pass=email+"_"+pass;
        this.cards=cards;
    }
    public Store(){}
}
