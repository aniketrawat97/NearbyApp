package com.aniket.nearbyapp.utils;

import androidx.annotation.NonNull;

import com.aniket.nearbyapp.models.Card;
import com.aniket.nearbyapp.models.Customer;
import com.aniket.nearbyapp.models.Store;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseUtils {

    static DatabaseReference ref;
    static Store st;
    static ArrayList<Store> stores;
    static ArrayList<Customer> cust;
    public static ArrayList<Store> downStoreList;

    public static void createStructure(){
        ref= FirebaseDatabase.getInstance().getReference();
        st=new Store("bazinga","aniketrawat97@gmail.com","asdfopbuwsfo","123.546.789","pass",null);
        st.cards=new ArrayList<>();
        st.cards.add(new Card("Chocolate","blabla desc1","blabla desc2","this is an offer","200","150"));
        st.cards.add(new Card("asdf","asdgasg","blabasdff  sc2","this is an offer","600","450"));
        stores=new ArrayList<>();
        stores.add(st);
        st.name="a";
        st.GPS="123.646.789";
        stores.add(st);
        st.name="b";
        st.GPS="223.746.789";
        stores.add(st);
        st.name="c";
        st.GPS="223.846.789";
        stores.add(st);
        cust=new ArrayList<>();
        cust.add(new Customer("Mark1","a","321.456.4894.4564","p"));
        cust.add(new Customer("Mark2","aniketrawat97@gmail.com2","321.456.3894.4564","pass2"));
        cust.add(new Customer("Mark3","aniketrawat97@gmail.com3","321.456.2894.4564","pass3"));
        cust.add(new Customer("Mark4","aniketrawat97@gmail.com4","321.456.1894.4564","pass4"));
        cust.add(new Customer("Mark5","aniketrawat97@gmail.com5","321.456.5894.4564","pass5"));
        cust.add(new Customer("Mark6","aniketrawat97@gmail.com6","321.456.6894.4564","pass6"));
        cust.add(new Customer("Mark7","aniketrawat97@gmail.com7","321.456.7894.4564","pass7"));
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
}
