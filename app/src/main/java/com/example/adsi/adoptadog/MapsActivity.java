package com.example.adsi.adoptadog;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GPSTracker gpsTracker;
    private Location mLocation;
    double mLat, mLog;
    private GoogleMap mMap;

    private static final LatLng carrera13 = new LatLng(4.676778, -74.048290);
    private static final LatLng chapineroCentral = new LatLng(4.648943, -74.06165099999990);
    private static final LatLng simonBolivar = new LatLng(4.657815, -74.093407);
    private static final LatLng corferias = new LatLng(4.630271, -74.090962);
    private static final LatLng museoDelOro = new LatLng(4.601992, -74.072113);
    private static final LatLng casaNariño = new LatLng(4.595544, -74.077561);
    private static final LatLng salitrePlaza = new LatLng(4.652067, -74.110232);
    private Marker marcador;
    double lat = 0.0;
    double log = 0.0;

    private Marker mcarrera13;
    private Marker mchapineroCentral;
    private Marker msimonBolivar;
    private Marker mcorferias;
    private Marker mmuseoDelOro;
    private Marker mcasaNariño;
    private Marker msalitrePlaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        gpsTracker = new GPSTracker(getApplicationContext());
        mLocation = gpsTracker.getLocation();
        mLat = mLocation.getLatitude();
        mLog =  mLocation.getLongitude();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    //miUbicacion();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        LatLng ubicacion = new LatLng(mLat, mLog);
        mMap.addMarker(new MarkerOptions()
                .position(ubicacion)
                .title("Mi ubicacion")
                 .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom(ubicacion, 16);
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));
        mMap.animateCamera(miUbicacion);


        //Carrera 13
        mcarrera13 = mMap.addMarker(new MarkerOptions()
                .position(carrera13)
                .visible(true)
                .title("Carrera 13 entre 93A y 93B"));
        mcarrera13.setTag(0);

        //Chapinero Central
        mchapineroCentral = mMap.addMarker(new MarkerOptions()
                .position(chapineroCentral)
                .title("Avenida Calle 63, Chapinero Central"));
        mchapineroCentral.setTag(0);

        //Parque Simon Bolivar
        msimonBolivar = mMap.addMarker(new MarkerOptions()
                .position(simonBolivar)
                .title("Parque Simón Bolívar Bogotá"));
        msimonBolivar.setTag(0);

        //Corferias
        mcorferias = mMap.addMarker(new MarkerOptions()
                .position(corferias)
                .title("Carrera. 37 #24-67-Corferias"));
        mcorferias.setTag(0);

        //Museo Del Oro
        mmuseoDelOro = mMap.addMarker(new MarkerOptions()
                .position(museoDelOro)
                .title("Carrera.6 #15-88- Museo del Oro"));
        mmuseoDelOro.setTag(0);

        //Casa de Nariño
        mcasaNariño = mMap.addMarker(new MarkerOptions()
                .position(casaNariño)
                .title("Casa de Nariño-Bogotá"));
        mcasaNariño.setTag(0);

        //Salitre Plaza
        msalitrePlaza = mMap.addMarker(new MarkerOptions()
                .position(salitrePlaza)
                .title("Centro Comercial Salitre Plaza"));
        msalitrePlaza.setTag(0);

    }
}