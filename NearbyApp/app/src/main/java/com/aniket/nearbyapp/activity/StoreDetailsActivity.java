package com.aniket.nearbyapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.aniket.nearbyapp.R;
import com.aniket.nearbyapp.models.Store;

public class StoreDetailsActivity extends AppCompatActivity {
    EditText cardTitle,finalPrice,beforePrice,description1,description2;
    TextView Upload;
    String cardTitle_TC,finalPrice_TC,beforePrice_TC,description1_TC,description2_TC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_details);
        cardTitle=findViewById(R.id.ET_Store_details_card_title);
        beforePrice=findViewById(R.id.ET_Store_details_Before_price);
        finalPrice=findViewById(R.id.ET_Store_details_Final_price);
        description1=findViewById(R.id.ET_Store_details_description1);
        description2=findViewById(R.id.ET_Store_details_description2);
        Upload=findViewById(R.id.TV_Store_details_upload);
        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardTitle_TC=cardTitle.getText().toString();
                beforePrice_TC=beforePrice.getText().toString();
                finalPrice_TC=finalPrice.getText().toString();
                description1_TC=description1.getText().toString();
                description2_TC=description2.getText().toString();
            }
        });
    }
}
