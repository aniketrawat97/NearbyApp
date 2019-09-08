package com.aniket.nearbyapp.models;

public class Customer {
    public String name,email,GPS,pass,email_pass;

    public Customer(String name, String email, String GPS,String pass) {
        this.name = name;
        this.email = email;
        this.GPS = GPS;
        this.pass= pass;
        this.email_pass=email+"_"+pass;
    }
}
