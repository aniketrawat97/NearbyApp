package com.aniket.nearbyapp.models;

public class Customer {
    public String name,email,pass,email_pass;

    public Customer(String name, String email,String pass) {
        this.name = name;
        this.email = email;
        this.pass= pass;
        this.email_pass=email+"_"+pass;
    }

    public Customer() {
    }
}
