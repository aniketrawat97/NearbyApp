package com.aniket.nearbyapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.aniket.nearbyapp.R;
import com.aniket.nearbyapp.models.Store;
import com.aniket.nearbyapp.utils.FirebaseUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {
    DatabaseReference ref;
    int timeDelay=5000;
    public static boolean dataDownloaded=false;
    public static DataSnapshot dataSnapshot;
    public static ArrayList<Store> storelist;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv=findViewById(R.id.warning);
        ref= FirebaseDatabase.getInstance().getReference();


        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                while (!dataDownloaded){tv.setVisibility(View.VISIBLE);}
                Log.i("info intent", "Starting intent ");
                Intent i=new Intent(getApplicationContext(),UseAsActivity.class);
                startActivity(i);
            }
        },timeDelay);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                SplashActivity.dataSnapshot=dataSnapshot;
                storelist=(ArrayList<Store>)dataSnapshot.child("Store").getValue();
                dataDownloaded=true;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
