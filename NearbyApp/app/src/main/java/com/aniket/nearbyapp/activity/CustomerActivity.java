package com.aniket.nearbyapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;
import com.aniket.nearbyapp.R;
import com.aniket.nearbyapp.models.Store;
import com.aniket.nearbyapp.utils.FirebaseUtils;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;

import static com.aniket.nearbyapp.activity.SplashActivity.storelist;


public class CustomerActivity extends AppCompatActivity {
    String TAG="LOG ";
    LocationManager lm;
    LocationListener ll;
    Location currentLocation;
    double distanceThreshold=100;
    ArrayList<Store> nearByStoresList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        nearByStoresList=new ArrayList<>();
        Log.i(TAG+"  ANSWER ", Double.toString(FirebaseUtils.distance(35,140,35,141)));


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},5);
        }


        lm=(LocationManager)getSystemService(Context.LOCATION_SERVICE);


        ll=new LocationListener() {
            @Override
            public void onLocationChanged(final Location location) {
                    currentLocation=location;
                    Log.i(TAG, "onLocationChanged: ");
                    Log.i(TAG,location.getLatitude() +"  " +location.getLongitude());

                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                            Log.i(TAG, "run: In RUN");
                            if(SplashActivity.dataDownloaded){
                                GenericTypeIndicator<ArrayList<Store>> t = new GenericTypeIndicator<ArrayList<Store>>() {};
                                storelist=SplashActivity.dataSnapshot.child("Stores").getValue(t);
                                //Log.i(TAG,storelist.get(0).GPS);
                            }
                            else {
                                Log.i(TAG, "storeList is NULL");
                            }
                            for (int i = 0; i < storelist.size(); i++) {

                                Log.i(TAG, currentLocation.toString());
                                Log.i(TAG, storelist.get(i).lat);
                                Log.i(TAG, storelist.get(i).lng);

                                double distance=FirebaseUtils.distance(currentLocation.getLatitude(),currentLocation.getLongitude(),Double.parseDouble(storelist.get(i).lat),Double.parseDouble(storelist.get(i).lng));

                                    if(distance<distanceThreshold){
                                        nearByStoresList.add(storelist.get(i));

                                    }
                                }
                            }
                            catch (Exception e){
                                Log.i(TAG, "EXCEPTION "+e);
                            }
                        }
                    });
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
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(CustomerActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
        else{
            Log.i(TAG, "in else of location update");
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0,ll);
        }

    }
}
