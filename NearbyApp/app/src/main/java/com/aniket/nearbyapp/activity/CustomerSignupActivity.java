package com.aniket.nearbyapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.aniket.nearbyapp.R;

public class CustomerSignupActivity extends AppCompatActivity {

    TextView CustSignupButton;
    EditText CustNameSignup,CustEmailSingnup,CustPasswdSignup;
    String nameTC,emailTC,passwdTC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_signup);

        CustSignupButton=findViewById(R.id.TV_Store_Signup_Button);
        CustNameSignup=findViewById(R.id.ET_Store_signup_name);
        CustEmailSingnup=findViewById(R.id.ET_Store_signup_email);
        CustPasswdSignup=findViewById(R.id.ET_Store_signup_set_pswd);
        CustSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTC=CustNameSignup.getText().toString();
                emailTC=CustEmailSingnup.getText().toString();
                passwdTC=CustPasswdSignup.getText().toString();
            }
        });
    }
}
