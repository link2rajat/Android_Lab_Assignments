package com.example.rajatrathi.mylocationonmaps;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    private final LatLng LOCATION_UNIV = new LatLng(33.783768, -118.114336);
    private final LatLng LOCATION_ECS = new LatLng(33.782777, -118.111868);
private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMaps();
        map.addMarker(new MarkerOptions().position(LOCATION_ECS).title("Find Me Here !"));

    }

    public void onClick_ECS(View v)
    {
        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_UNIV, 14);
        map.animateCamera(update);
    }

    public void onClick_LongBeach(View v)
    {
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_ECS, 16);
        map.animateCamera(update);
    }

    public void onClick_City(View v)
    {
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_UNIV, 9);
        map.animateCamera(update);
    }
}
