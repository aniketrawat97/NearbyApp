package com.aniket.nearbyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    TextView loginButton,signupButton;
    EditText email;
    EditText passwd;
    int count=0;
    String email_to_check,passwd_to_check;
    Store st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ref= FirebaseDatabase.getInstance().getReference();
        ref.setValue("Hello, World!");

        signupButton=findViewById(R.id.SignupTextView);
        loginButton=findViewById(R.id.LoginTextView);
        email=findViewById(R.id.editTextLoginEmail);
        passwd=findViewById(R.id.editTextLoginPassword);
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
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email_to_check=email.getText().toString();
                passwd_to_check=passwd.getText().toString();
                Log.i("info", "onClick: ");
                ref.child("Stores").setValue(stores);
                ref.child("Customers").setValue(cust);
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), CustomerSignupActivity.class);
                startActivity(i);
            }
        });
    }
}
