package com.aniket.nearbyapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aniket.nearbyapp.R;
import com.aniket.nearbyapp.models.Card;
import com.aniket.nearbyapp.models.Store;
import com.aniket.nearbyapp.utils.FirebaseUtils;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;

public class CardUpdateActivity extends AppCompatActivity {
    int index;
    Store store1;
    EditText cardTitle,finalPrice,beforePrice,description1,description2;
    TextView Upload;
    String cardTitle_TC,finalPrice_TC,beforePrice_TC,description1_TC,description2_TC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_details);

        ArrayList<Card> cardlist = new ArrayList();
        Card card1 = new Card("rabdi", "A very interesting sweet of india mostly popular at mavli railway station", "And is quite expensive", "Box ji halwai aj denge bilkul muft,I mean Rabdi", "800", "100");
        cardlist.add(card1);
        store1 = new Store("dvijay", "dvijay11nov1997@gmail.com", "sectore 14", "123,123,123,123","123,123,123,123", "bhaumik", cardlist);

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
                try{

                }catch (Exception e){

                }

                ArrayList<Card> c=new ArrayList<>();
                Card newcard=new Card(cardTitle_TC,description1_TC,description2_TC,"",beforePrice_TC,finalPrice_TC);
                c.add(newcard);
                GenericTypeIndicator<ArrayList<Store>> t = new GenericTypeIndicator<ArrayList<Store>>() {};
                ArrayList<Store>storeListproduct = SplashActivity.dataSnapshot.child("Stores").getValue(t);
                for(int i=0;i<storeListproduct.size();i++){
                    if(storeListproduct.get(i).email_pass==LoginActivity.storeEmailPass){
                        index=i;
                    }
                }

                Store newStore=storeListproduct.get(index);
                newStore.cards=c;
                storeListproduct.set(index,newStore);

                FirebaseUtils.ref.child("Stores").setValue(storeListproduct);

                Toast.makeText(CardUpdateActivity.this, " Successfully Changed ", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
