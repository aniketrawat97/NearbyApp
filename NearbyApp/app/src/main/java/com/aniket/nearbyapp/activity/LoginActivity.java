package com.aniket.nearbyapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aniket.nearbyapp.R;
import com.aniket.nearbyapp.models.Store;
import com.aniket.nearbyapp.utils.FirebaseUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class LoginActivity extends AppCompatActivity {
    DatabaseReference ref;
    TextView loginButton,signupButton;
    EditText email;
    EditText passwd;
    String email_to_check,passwd_to_check;
    Store st;
    public static boolean isCustomer=true;
    Intent i;
    public static String storeEmailPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ref= FirebaseDatabase.getInstance().getReference();
        signupButton=findViewById(R.id.TV_Login_signupB);
        loginButton=findViewById(R.id.TV_Login_loginB);
        email=findViewById(R.id.ET_Login_email);
        passwd=findViewById(R.id.ET_Login_pswd);
        FirebaseUtils.createStructure();
        isCustomer=getIntent().getBooleanExtra("status",true);

        if(isCustomer){
            i=new Intent(getApplicationContext(),CustomerActivity.class);
        }else{
            i=new Intent(getApplicationContext(), CardUpdateActivity.class);
        }


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email_to_check=email.getText().toString();
                passwd_to_check=passwd.getText().toString();
                if (isCustomer) {
                    Query em = ref.child("Customers").orderByChild("email_pass").equalTo(email_to_check + "_" + passwd_to_check);
                    em.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                Log.i("Info", "login successfull");
                                startActivity(i);
                            } else {
                                Log.i("Info", "!!!UNSUCCESSFULL!!!");
                                Toast.makeText(LoginActivity.this, "Wrong Email or password", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }else{
                    Query em = ref.child("Stores").orderByChild("email_pass").equalTo(email_to_check + "_" + passwd_to_check);
                    em.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                Log.i("Info", "login successfull");
                                storeEmailPass=email_to_check + "_" + passwd_to_check;
                                startActivity(i);
                            } else {
                                Log.i("Info", "!!!UNSUCCESSFULL!!!");
                                Toast.makeText(LoginActivity.this, "Wrong Email or password", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCustomer){
                    Intent i=new Intent(getApplicationContext(), CustomerSignupActivity.class);
                    startActivity(i);

                }else{
                    Intent i=new Intent(getApplicationContext(), StoreSignupActivity.class);
                    startActivity(i);

                }

            }
        });
    }
}
