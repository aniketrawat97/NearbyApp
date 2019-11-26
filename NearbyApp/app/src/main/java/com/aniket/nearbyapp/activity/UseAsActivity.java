package com.aniket.nearbyapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aniket.nearbyapp.R;

public class UseAsActivity extends AppCompatActivity {
    Button Customer,Store;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_as);

        Customer=findViewById(R.id.Button_Use_as_cust);
        Store=findViewById(R.id.Button_Use_as_store);
        Customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), LoginActivity.class);
                i.putExtra("status",true);
                startActivity(i);
            }
        });
        Store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), LoginActivity.class);
                i.putExtra("status",false);
                startActivity(i);
            }
        });
    }
}
