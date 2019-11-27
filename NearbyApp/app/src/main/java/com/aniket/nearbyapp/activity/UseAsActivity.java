package com.aniket.nearbyapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.aniket.nearbyapp.R;

public class UseAsActivity extends AppCompatActivity {
    Button Customer,Store;
    Intent i;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_as);
        imageView=findViewById(R.id.logouseas);
        imageView.setImageResource(R.drawable.logo);

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
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Haraam Ke Jane , Aur lele BULLT?", Toast.LENGTH_SHORT).show();
    }
}
