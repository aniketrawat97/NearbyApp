package com.aniket.nearbyapp.activity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_signup);
        StoreSignupB=findViewById(R.id.textViewStoreSignupB);
        StoreNameSignup=findViewById(R.id.editTextNameStore);
        StoreEmailSingnup=findViewById(R.id.editTextSingupEmailStore);
        StorePasswdSignup=findViewById(R.id.editTextSingupPswdStore);
        StoreSignupB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SnameTC=StoreNameSignup.getText().toString();
                SemailTC=StoreEmailSingnup.getText().toString();
                SpasswdTC=StorePasswdSignup.getText().toString();
            }
        });
    }
}
