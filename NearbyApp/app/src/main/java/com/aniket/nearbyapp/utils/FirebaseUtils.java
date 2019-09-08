package com.aniket.nearbyapp.utils;

import com.aniket.nearbyapp.models.Card;
import com.aniket.nearbyapp.models.Customer;
import com.aniket.nearbyapp.models.Store;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FirebaseUtils {

    static DatabaseReference ref;
    static Store st;

    static ArrayList<Store> stores;
    static ArrayList<Customer> cust;

    public static void createStructure(){
        ref= FirebaseDatabase.getInstance().getReference();
        st=new Store("bazinga","aniketrawat97@gmail.com","asdfopbuwsfo","123.546.789","pass");
        st.cards=new ArrayList<>();
        st.cards.add(new Card("Chocolate","blabla desc1","blabla desc2","this is an offer","200","150"));
        st.cards.add(new Card("asdf","asdgasg","blabasdff  sc2","this is an offer","600","450"));
        stores=new ArrayList<>();
        stores.add(st);
        stores.add(st);
        stores.add(st);
        stores.add(st);
        cust=new ArrayList<>();
        cust.add(new Customer("Mark","aniketrawat97@gmail.com","321.456.7894.4564","pass"));
        cust.add(new Customer("Mark","aniketrawat97@gmail.com","321.456.7894.4564","pass"));
        cust.add(new Customer("Mark","aniketrawat97@gmail.com","321.456.7894.4564","pass"));
        cust.add(new Customer("Mark","aniketrawat97@gmail.com","321.456.7894.4564","pass"));
        cust.add(new Customer("Mark","aniketrawat97@gmail.com","321.456.7894.4564","pass"));
        cust.add(new Customer("Mark","aniketrawat97@gmail.com","321.456.7894.4564","pass"));
        cust.add(new Customer("Mark","aniketrawat97@gmail.com","321.456.7894.4564","pass"));
        ref.child("Stores").setValue(stores);
        ref.child("Customers").setValue(cust);
    }
}
