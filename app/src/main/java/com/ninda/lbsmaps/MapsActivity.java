package com.ninda.lbsmaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ninda.lbsmaps.R;
import com.ninda.lbsmaps.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        LatLng Place = new LatLng(-6.975702455283656, 108.47729551966015);
        mMap.addMarker(new MarkerOptions().position(Place).title("Fakultas Ilmu Komputer"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(Place));
        float zoomLevel = 17.0f;

        // menampilkan maps dengan satelit
        mMap.setMapType(googleMap.MAP_TYPE_SATELLITE);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Place, zoomLevel));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Place));

        // Menambahkan penanda di Place dengan judul dan ikon kustom
        mMap.addMarker(new MarkerOptions()
                .position(Place)
                .title("Kampus 2 Universitas Kuningan")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_uniku)));

    }
}