package com.aniket.nearbyapp.activity;

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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aniket.nearbyapp.R;
import com.aniket.nearbyapp.models.Card;
import com.aniket.nearbyapp.models.Customer;
import com.aniket.nearbyapp.models.Store;
import com.aniket.nearbyapp.utils.FirebaseUtils;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;

public class StoreSignupActivity extends AppCompatActivity {

    TextView StoreSignupB;
    EditText StoreNameSignup,StoreEmailSingnup,StorePasswdSignup,StoreAddress;
    String SnameTC,SemailTC,SpasswdTC,SaddressTC;
    Intent i4;
    Store s;
    LocationManager lm;
    Location currentLocation;
    ArrayList<Store> storeListSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_signup);

        StoreSignupB=findViewById(R.id.TV_Store_Signup_Button);
        StoreNameSignup=findViewById(R.id.ET_Store_signup_name);
        StoreEmailSingnup=findViewById(R.id.ET_Store_signup_email);
        StorePasswdSignup=findViewById(R.id.ET_Store_signup_set_pswd);
        StoreAddress=findViewById(R.id.ET_Store_signup_address);
        storeListSignup=new ArrayList<>();

        lm=(LocationManager)getSystemService(Context.LOCATION_SERVICE);

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(StoreSignupActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
        else{
            Log.i("LOG", "in else of location update");
//            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,ll);
//            lm.requestSingleUpdate(LocationManager.GPS_PROVIDER,ll,null);
            currentLocation=lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (currentLocation==null){
                currentLocation=new Location("");
                currentLocation.setLatitude(35);
                currentLocation.setLongitude(140);
            }
            Log.i("LOG",currentLocation.toString());
        }

        StoreSignupB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    SnameTC=StoreNameSignup.getText().toString();
                    SemailTC=StoreEmailSingnup.getText().toString();
                    SaddressTC=StoreAddress.getText().toString();
                    SpasswdTC=StorePasswdSignup.getText().toString();
                    Log.i("LOG", currentLocation.toString());



                    ArrayList<Card> c=new ArrayList<>();
                    Card card=new Card();
                    c.add(card);
                    s=new Store(SnameTC,SemailTC,SaddressTC,Double.toString(currentLocation.getLatitude()),Double.toString(currentLocation.getLongitude()),SpasswdTC,c);

                    GenericTypeIndicator<ArrayList<Store>> t = new GenericTypeIndicator<ArrayList<Store>>() {
                    };
                    storeListSignup = SplashActivity.dataSnapshot.child("Stores").getValue(t);
                    storeListSignup.add(s);
                    Log.i("LOG", "About to add data");
                    FirebaseUtils.ref.child("Stores").setValue(storeListSignup);

                    Toast.makeText(StoreSignupActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                    Log.i("LOG", "Added data");

//                            Intent i3 = new Intent(getApplicationContext(), LoginActivity.class);
//                            startActivity(i3);
                } catch (Exception e) {
                    Log.i("LOG", "" + e);
                }
            }
        });



    }
}
