package com.aniket.nearbyapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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
    public static Location locationInStart;
    LocationManager lm;
    LocationListener ll;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv=findViewById(R.id.warning);
        ref= FirebaseDatabase.getInstance().getReference();
        lm=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        ll=new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                locationInStart=location;
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        if (ContextCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(SplashActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},5);
        }
        else{
            try {
                lm.requestSingleUpdate(LocationManager.GPS_PROVIDER,ll,null);
            }catch (Exception e){
                Log.i("", "onCreate: e");
            }
        }


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
