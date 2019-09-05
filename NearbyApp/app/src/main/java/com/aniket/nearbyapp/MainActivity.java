package com.aniket.nearbyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseReference ref;
    ArrayList<Store> stores;
    ArrayList<Customer> cust;
    TextView login;
    EditText email;
    int count=0;
    Store st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ref= FirebaseDatabase.getInstance().getReference();
        ref.setValue("Hello, World!");

        login=findViewById(R.id.LoginTextView);
        email=findViewById(R.id.editTextLoginEmail);
        Log.i("otpt", email.getText().toString());
















        st=new Store("bazinga","aniketrawat97@gmail.com","asdfopbuwsfo","123.546.789");
        st.cards=new ArrayList<>();
        st.cards.add(new Card("Chocolate","blabla desc1","blabla desc2","this is an offer","200","150"));
        st.cards.add(new Card("asdf","asdgasg","blabasdff  sc2","this is an offer","600","450"));
        stores=new ArrayList<>();
        stores.add(st);
        stores.add(st);
        stores.add(st);
        stores.add(st);
        cust=new ArrayList<>();
        cust.add(new Customer("Mark","aniketrawat97@gmail.com","321.456.7894.4564"));
        cust.add(new Customer("Mark","aniketrawat97@gmail.com","321.456.7894.4564"));
        cust.add(new Customer("Mark","aniketrawat97@gmail.com","321.456.7894.4564"));
        cust.add(new Customer("Mark","aniketrawat97@gmail.com","321.456.7894.4564"));
        cust.add(new Customer("Mark","aniketrawat97@gmail.com","321.456.7894.4564"));
        cust.add(new Customer("Mark","aniketrawat97@gmail.com","321.456.7894.4564"));
        cust.add(new Customer("Mark","aniketrawat97@gmail.com","321.456.7894.4564"));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("info", "onClick: ");
                ref.child("Stores").setValue(stores);
                ref.child("Customers").setValue(cust);
            }
        });
    }
}
