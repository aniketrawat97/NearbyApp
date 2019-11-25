package com.aniket.nearbyapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.aniket.nearbyapp.R;
import com.aniket.nearbyapp.models.Card;
import com.aniket.nearbyapp.models.Store;

import java.util.ArrayList;

public class ProductDetailsActivity extends AppCompatActivity {
    Store store1;
    TextView finalPrice,beforePrice,Store_name,Prod_title,description1,description2;
    ImageView Image_prod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_product_details);
            ArrayList<Card> cardlist = new ArrayList();
            Card card1 = new Card("rabdi", "A very interesting sweet of india mostly popular at mavli railway station", "And is quite expensive", "Box ji halwai aj denge bilkul muft,I mean Rabdi", "800", "100");
            cardlist.add(card1);
            store1 = new Store("dvijay", "dvijay11nov1997@gmail.com", "sectore 14", "123,123,123,123","123,123,123,123", "bhaumik", cardlist);
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
        catch(Exception e){
            Log.i("EXVNDMGDGF", ""+e);
        }

    }
}
