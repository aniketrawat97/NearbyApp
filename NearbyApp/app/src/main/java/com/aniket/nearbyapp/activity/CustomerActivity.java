package com.aniket.nearbyapp.activity;

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
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import com.aniket.nearbyapp.R;
import com.aniket.nearbyapp.models.CustomAdapter;
import com.aniket.nearbyapp.models.Store;
import com.aniket.nearbyapp.utils.FirebaseUtils;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;

import static com.aniket.nearbyapp.activity.SplashActivity.storelist;


public class CustomerActivity extends AppCompatActivity {
    String TAG="LOG ";
    LocationManager lm;
    LocationListener ll;
    public static Location currentLocation;
    double distanceThreshold=100;
    ArrayList<Store> nearByStoresList,temp;
    ListView lv;
    Intent i;
    CustomAdapter customAdapter;
    ImageView refreshButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        lv=findViewById(R.id.listView_customer);
        i=new Intent(this,ProductDetailActivity.class);

        refreshButton=findViewById(R.id.refreshButton);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i(TAG, "run: In RUN");
                temp=new ArrayList<>();

                if(SplashActivity.dataDownloaded){
                    GenericTypeIndicator<ArrayList<Store>> t = new GenericTypeIndicator<ArrayList<Store>>() {};
                    storelist=SplashActivity.dataSnapshot.child("Stores").getValue(t);
                }
                else {
                    Log.i(TAG, "storeList is NULL");
                }
                nearByStoresList=new ArrayList<>();
                if (ContextCompat.checkSelfPermission(CustomerActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(CustomerActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},5);
                }
                lm=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
                Location location=lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (location==null){

                }else {
                    currentLocation = location;
                    for (int i = 0; i < storelist.size(); i++) {

                        Log.i(TAG, currentLocation.toString());
                        Log.i(TAG, storelist.get(i).lat);
                        Log.i(TAG, storelist.get(i).lng);

                        double distance = FirebaseUtils.distance(currentLocation.getLatitude(), currentLocation.getLongitude(), Double.parseDouble(storelist.get(i).lat), Double.parseDouble(storelist.get(i).lng));

                        if (distance < distanceThreshold) {
                            temp.add(storelist.get(i));
                        }
                    }
                }

                Log.i(TAG, Integer.toString(temp.size()));
                customAdapter=new CustomAdapter(CustomerActivity.this,i,temp);
                lv.setAdapter(customAdapter);
            }
        });

        nearByStoresList=new ArrayList<>();

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(CustomerActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
        else{
            Log.i(TAG, "in else of location update");
        }

    }
    private void notifyAdapter()  {
        runOnUiThread(new Runnable()  {
            public void run() {
                nearByStoresList=temp;

                lv.setAdapter(null);
                if(customAdapter != null) {
                    customAdapter.notifyDataSetChanged();
                }
                lv.setAdapter(customAdapter);
            }
        });
    }
}
