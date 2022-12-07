package com.burtton.rapidfoodapp;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.burtton.rapidfoodapp.databinding.ActivityUbicacionRestauranteBinding;

public class UbicacionRestaurante extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityUbicacionRestauranteBinding binding;

    Button btnSatelital, btnNormal, btnTopografico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUbicacionRestauranteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btnSatelital = findViewById(R.id.btnSatelital);
        btnNormal = findViewById(R.id.btnNormal);
        btnTopografico = findViewById(R.id.btnTopografico);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnSatelital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });

        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        btnTopografico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        /*
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
         */
        incluirMarcadores(mMap);
        verificarPermisos(mMap);

        mMap.getUiSettings().setZoomControlsEnabled(true);
    }

    public void incluirMarcadores(GoogleMap googleMap) {

        mMap = googleMap;

        LatLng ubicacionRestaurante = new LatLng(4.810917425489949, -75.69296739634736);

        mMap.addMarker(new MarkerOptions().position(ubicacionRestaurante).title("Restaurante RapidFood").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacionRestaurante));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacionRestaurante, 15));
    }

    public void verificarPermisos(GoogleMap googleMap) {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            mMap = googleMap;
            mMap.setMyLocationEnabled(true);
        }
    }
}