package com.aniket.nearbyapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aniket.nearbyapp.R;

public class StoreSignupActivity extends AppCompatActivity {

    TextView StoreSignupB;
    EditText StoreNameSignup,StoreEmailSingnup,StorePasswdSignup;
    String SnameTC,SemailTC,SpasswdTC;
    Intent i4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_signup);
        StoreSignupB=findViewById(R.id.TV_Store_Signup_Button);
        StoreNameSignup=findViewById(R.id.ET_Store_signup_name);
        StoreEmailSingnup=findViewById(R.id.ET_Store_signup_email);
        StorePasswdSignup=findViewById(R.id.ET_Store_signup_set_pswd);
        StoreSignupB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SnameTC=StoreNameSignup.getText().toString();
                SemailTC=StoreEmailSingnup.getText().toString();
                SpasswdTC=StorePasswdSignup.getText().toString();
                Intent i4=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i4);
            }
        });
    }
}
