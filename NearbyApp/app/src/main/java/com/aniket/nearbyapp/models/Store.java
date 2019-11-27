package com.aniket.nearbyapp.models;

import java.util.ArrayList;
import java.io.Serializable;

public class Store implements Serializable{
    public String name,email,address,lat,lng,pass,email_pass;
    public ArrayList<Card> cards;

    public Store(String name, String email, String address, String lat,String lng,String pass,ArrayList<Card> cards) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.pass=pass;
        this.email_pass=email+"_"+pass;
        this.cards=cards;
    }
    public Store(){}
}
