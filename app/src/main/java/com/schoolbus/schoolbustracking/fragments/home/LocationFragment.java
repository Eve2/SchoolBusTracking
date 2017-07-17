package com.schoolbus.schoolbustracking.fragments.home;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.schoolbus.schoolbustracking.R;

import static com.schoolbus.schoolbustracking.R.id.my_map;

/**
 * Created by yinqingjiang on 7/13/17.
 */

public class LocationFragment extends Fragment implements OnMapReadyCallback {
    private static GoogleMap map;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private static LatLng bus=new LatLng(12.916514,77.609664);
    LatLng start = new LatLng(12.916514, 77.619664);
    LatLng end = new LatLng(12.916514, 77.604332);
    LatLng CityBank=new LatLng(12.91697,77.614085);
    LatLng Lara=new LatLng(12.916274,77.611081);
    LatLng BTM=new LatLng(12.916535,77.606800);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(my_map);
        mapFragment.getMapAsync(this);
       // googleMap=(MapFragment)((SupportMapFragment) getChildFragmentManager().findFragmentById(my_map)).getMapAsync(this);
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                map.clear();
                bus = new LatLng(location.getLatitude(), location.getLongitude());
                //Toast.makeText(getContext(), bus.longitude + "", Toast.LENGTH_LONG).show();

                map.addMarker(new MarkerOptions().position(bus)
                        .title("Bus")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.bus_24));
                map.addMarker(new MarkerOptions().position(start)
                        .title("Start Stop")) ;
               map.addMarker(new MarkerOptions().position(start)
                        .title("Start Stop")) ;
                map.addMarker(new MarkerOptions().position(end)
                        .title("End Stop")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.school)); ;
                map.addMarker(new MarkerOptions().position(CityBank)
                        .title("City Bank Stop")) ;
                map.addMarker(new MarkerOptions().position(Lara)
                        .title("Lara Technologies"));
               map.addMarker(new MarkerOptions().position(BTM)
                        .title("BTM Water Tank"));
                // add route to the map
                Polyline polyline1 = map.addPolyline(new PolylineOptions()
                        .clickable(true)
                        .add(start, CityBank, Lara, BTM, end));
                polyline1.setTag("Route 1");
                polyline1.setColor(Color.parseColor("#3F51B5"));
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
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.INTERNET
            }, 10);
        } else {
            locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
        }

        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        // bus stops
        map=googleMap;

        // add markers to the map
        googleMap.addMarker(new MarkerOptions().position(bus)
                .title("Bus")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.bus_24));
        googleMap.addMarker(new MarkerOptions().position(start)
                .title("Start Stop")) ;
        googleMap.addMarker(new MarkerOptions().position(start)
                .title("Start Stop")) ;
        googleMap.addMarker(new MarkerOptions().position(end)
                .title("End Stop")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.school)); ;
        googleMap.addMarker(new MarkerOptions().position(CityBank)
                .title("City Bank Stop")) ;
        googleMap.addMarker(new MarkerOptions().position(Lara)
                .title("Lara Technologies"));
        googleMap.addMarker(new MarkerOptions().position(BTM)
                .title("BTM Water Tank"));
        // add route to the map
        Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(start, CityBank, Lara, BTM, end));
        polyline1.setTag("Route 1");
        polyline1.setColor(Color.parseColor("#3F51B5"));

        CameraUpdate center =
                CameraUpdateFactory.newLatLng(start);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(13);
        googleMap.moveCamera(center);
        googleMap.animateCamera(zoom);
        //setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
//      googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        // marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
//        Circle circle = googleMap.addCircle(new CircleOptions()
//                .center(start)
//                .radius(500)
//                .strokeColor(Color.parseColor("#4fb2ff"))
//                .fillColor(Color.parseColor("#BBDEFB")));
    }
}
