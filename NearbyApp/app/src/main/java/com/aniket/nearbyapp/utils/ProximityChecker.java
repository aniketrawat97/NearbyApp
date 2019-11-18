package com.aniket.nearbyapp.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.widget.Toast;

public class ProximityChecker extends AsyncTask {
    Context c;
    LocationManager lm;
    LocationListener ll;

    public ProximityChecker(Context c, LocationManager lm, LocationListener ll) {
        this.c = c;
        this.lm = lm;
        this.ll = ll;
    }

    public ProximityChecker() {
        super();
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        return;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }

}
