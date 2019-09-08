package com.aniket.nearbyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CustomerSignupActivity extends AppCompatActivity {

    TextView CustSignupB;
    EditText CustNameSignup,CustEmailSingnup,CustPasswdSignup;
    String nameTC,emailTC,passwdTC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_signup);
        CustSignupB=findViewById(R.id.textViewStoreSignupB);
        CustNameSignup=findViewById(R.id.editTextNameStore);
        CustEmailSingnup=findViewById(R.id.editTextSingupEmailStore);
        CustPasswdSignup=findViewById(R.id.editTextSingupPswdStore);
        CustSignupB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTC=CustNameSignup.getText().toString();
                emailTC=CustEmailSingnup.getText().toString();
                passwdTC=CustPasswdSignup.getText().toString();
            }
        });
    }
}
