package com.aniket.nearbyapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.aniket.nearbyapp.R;
import com.aniket.nearbyapp.models.Card;
import com.aniket.nearbyapp.models.Store;
import com.aniket.nearbyapp.utils.FirebaseUtils;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;

public class ProductDetailActivity extends AppCompatActivity {
    Store store1;
    TextView finalPrice, beforePrice, Store_name, Prod_title, description1, description2;
    ImageView Image_prod;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_product_details);


            Store_name = findViewById(R.id.TV_Prod_details);
            Store_name.setText(store1.name);
            Image_prod = findViewById(R.id.IV_Prod_details);
            Image_prod.setImageBitmap(store1.cards.get(0).image);
            Prod_title = findViewById(R.id.TV_Prod_details_title);
            Prod_title.setText(store1.cards.get(0).title);
            finalPrice = findViewById(R.id.TV_Prod_details_final_price);
            finalPrice.setText(store1.cards.get(0).finalPrice);
            beforePrice = findViewById(R.id.TV_Prod_details_before_price);
            beforePrice.setText(store1.cards.get(0).beforePrice);
            description1 = findViewById(R.id.TV_Prod_details_description1);
            description1.setText(store1.cards.get(0).desc1);
            description2 = findViewById(R.id.TV_Prod_details_description2);
            description2.setText(store1.cards.get(0).desc2);


    }
}
