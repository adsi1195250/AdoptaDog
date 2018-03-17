package com.example.adsi.adoptadog;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

/**
 * Created by ADSI on 15/03/2018.
 */

public class GPSTracker extends Service implements LocationListener {

    private final Context context;
    Boolean isGPSEnabled = false;
    Boolean isNetworkEnabled = false;
    Boolean canGetLocation = false;
    Location location;
    protected LocationManager locationManager;


    public GPSTracker( Context context) {
        this.context = context;
    }

    public Location getLocation(){
        try {

            locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){

                if (isGPSEnabled){
                    if (location==null){
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 10, this);
                        if (locationManager!=null){
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            stopUsingGPS();
                        }
                    }
                }

                //si no encontro la ubicación por GPS entonces buscaria por la conexion
                if (location==null){
                    if (isNetworkEnabled){
                        if (location==null){

                            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 10, this);
                            if (locationManager!=null){
                                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                                stopUsingGPS();
                            }
                        }
                    }
                }

            }
        }catch (Exception ex){
            Toast.makeText(this, "ERROr , no ha activado la ubicación", Toast.LENGTH_SHORT).show();
        }
        return location;
    }

    //Método que remueve el gps en el momento que obtenemos la localización
    private void stopUsingGPS() {
        if (locationManager != null) {
            locationManager.removeUpdates(this);
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
