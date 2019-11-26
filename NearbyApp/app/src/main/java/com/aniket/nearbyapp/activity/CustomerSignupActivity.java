package com.aniket.nearbyapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aniket.nearbyapp.R;
import com.aniket.nearbyapp.models.Customer;
import com.aniket.nearbyapp.models.Store;
import com.aniket.nearbyapp.utils.FirebaseUtils;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;

import static com.aniket.nearbyapp.activity.SplashActivity.storelist;

public class CustomerSignupActivity extends AppCompatActivity {

    TextView CustSignupButton;
    EditText CustNameSignup,CustEmailSingnup,CustPasswdSignup;
    String nameTC,emailTC,passwdTC;
    Intent i3;
    Customer customer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {


        setContentView(R.layout.activity_customer_signup);

        CustSignupButton = findViewById(R.id.TV_Cust_Signup_Button);
        CustNameSignup = findViewById(R.id.ET_Store_signup_name);
        CustEmailSingnup = findViewById(R.id.ET_Store_signup_email);
        CustPasswdSignup = findViewById(R.id.ET_Store_signup_set_pswd);
        CustSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTC = CustNameSignup.getText().toString();
                emailTC = CustEmailSingnup.getText().toString();
                passwdTC = CustPasswdSignup.getText().toString();

                customer = new Customer(nameTC, emailTC, passwdTC);

                CustSignupButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {

                            GenericTypeIndicator<ArrayList<Customer>> t = new GenericTypeIndicator<ArrayList<Customer>>() {
                            };
                            ArrayList<Customer> custList = SplashActivity.dataSnapshot.child("Customers").getValue(t);
                            custList.add(customer);
                            Log.i("LOG", "Acbout to add data");
                            FirebaseUtils.ref.child("Customers").setValue(custList);

                            Toast.makeText(CustomerSignupActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                            Log.i("LOG", "Added data");

//                            Intent i3 = new Intent(getApplicationContext(), LoginActivity.class);
//                            startActivity(i3);
                        } catch (Exception e) {
                            Log.i("LOG", "" + e);
                        }
                    }
                });

            }
        });
    }catch (Exception e){
            Log.i("LOG", "" + e);
        }
    }
}
