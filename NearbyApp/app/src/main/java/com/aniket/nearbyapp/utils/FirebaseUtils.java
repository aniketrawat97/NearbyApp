package com.aniket.nearbyapp.utils;

import android.location.Location;

import androidx.annotation.NonNull;

import com.aniket.nearbyapp.models.Card;
import com.aniket.nearbyapp.models.Customer;
import com.aniket.nearbyapp.models.Store;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.lang.Math;
import java.util.*;
import java.lang.*;
import java.util.ArrayList;

public class FirebaseUtils {

    public static DatabaseReference ref;
    static Store st0,st1,st2,st3;
    static ArrayList<Store> stores;
    static ArrayList<Customer> cust;
    public static ArrayList<Store> downStoreList;

    public static void createStructure(){
        ref= FirebaseDatabase.getInstance().getReference();
        st0=new Store("qbaziqanga","s","asdfopbuwsfo","35","140.001","o",null);
        st0.cards=new ArrayList<>();
        st0.cards.add(new Card("Chocolate","blabla desc1","blabla desc2","this is an offer","200","150"));
        st0.cards.add(new Card("asdf","asdgasg","blabasdff  sc2","this is an offer","600","450"));

        st1=new Store("abazihnga","aniketrawat97@gmail.com","asdfopbuwsfo","35","139.999","pass",null);
        st1.cards=new ArrayList<>();
        st1.cards.add(new Card("Chocolate","blabla desc1","blabla desc2","this is an offer","200","150"));
        st1.cards.add(new Card("asdf","asdgasg","blabasdff  sc2","this is an offer","600","450"));

        st2=new Store("fbazasdfinga","aniketrawat97@gmail.com","asdfopbuwsfo","35","140.001","pass",null);
        st2.cards=new ArrayList<>();
        st2.cards.add(new Card("Chocolate","blabla desc1","blabla desc2","this is an offer","200","150"));
        st2.cards.add(new Card("asdf","asdgasg","blabasdff  sc2","this is an offer","600","450"));

        st3=new Store("tbaziasdnga","aniketrawat97@gmail.com","asdfopbuwsfo","35","140.002","pass",null);
        st3.cards=new ArrayList<>();
        st3.cards.add(new Card("Chocolate","blabla desc1","blabla desc2","this is an offer","200","150"));
        st3.cards.add(new Card("asdf","asdgasg","blabasdff  sc2","this is an offer","600","450"));


        stores=new ArrayList<>();
        stores.add(st0);
        stores.add(st1);
        stores.add(st2);
        stores.add(st3);
        cust=new ArrayList<>();
        cust.add(new Customer("Mark1","a","p"));
        cust.add(new Customer("Mark2","aniketrawat97@gmail.com2","pass2"));
        cust.add(new Customer("Mark3","aniketrawat97@gmail.com3","pass3"));
        cust.add(new Customer("Mark4","aniketrawat97@gmail.com4","pass4"));
        cust.add(new Customer("Mark5","aniketrawat97@gmail.com5","pass5"));
        cust.add(new Customer("Mark6","aniketrawat97@gmail.com6","pass6"));
        cust.add(new Customer("Mark7","aniketrawat97@gmail.com7","pass7"));
        ref.child("Stores").setValue(stores);
        ref.child("Customers").setValue(cust);

    }
    public static ArrayList<Store> DownloadStoreDetails(){
        ArrayList<Store> storeList=new ArrayList();
        ref= FirebaseDatabase.getInstance().getReference();
        ref.orderByKey().equalTo("Stores").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                downStoreList= (ArrayList<Store>)dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return storeList;
    }
    public static double dist(double x1,double y1,double x2 , double y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }

    public static double distance(double lat1,
                                  double lon1, double lat2,
                                  double lon2)
    {
        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        double r = 6378.137;
        return(c * r) * 1000;
    }
}
