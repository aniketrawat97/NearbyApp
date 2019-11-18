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
    boolean isCustomer=true;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ref= FirebaseDatabase.getInstance().getReference();
        signupButton=findViewById(R.id.SignupTextView);
        loginButton=findViewById(R.id.LoginTextView);
        email=findViewById(R.id.editTextLoginEmail);
        passwd=findViewById(R.id.editTextLoginPassword);
        FirebaseUtils.createStructure();

        if(isCustomer){
            i=new Intent(getApplicationContext(),CustomerActivity.class);
        }else{
            i=new Intent(getApplicationContext(),StoreSignupActivity.class);
        }


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email_to_check=email.getText().toString();
                passwd_to_check=passwd.getText().toString();

                Query em=ref.child("Customers").orderByChild("email_pass").equalTo(email_to_check+"_"+passwd_to_check);
                em.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            Log.i("Info", "login successfull");
                            startActivity(i);
                        }
                        else{
                            Log.i("Info", "!!!UNSUCCESSFULL!!!");
                            Toast.makeText(LoginActivity.this, "Wrong Email or password", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
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
