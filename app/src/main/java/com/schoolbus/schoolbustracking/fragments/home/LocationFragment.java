package com.schoolbus.schoolbustracking.fragments.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.schoolbus.schoolbustracking.R;

import static com.schoolbus.schoolbustracking.R.id.my_map;

/**
 * Created by yinqingjiang on 7/13/17.
 */

public class LocationFragment extends Fragment implements OnMapReadyCallback {
    private ImageView iv_plus;
    private ImageView iv_minus;
    private GoogleMap mMap;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View view=inflater.inflate(R.layout.fragment_location,container,false);
        iv_plus=view.findViewById(R.id.plus);
        iv_minus=view.findViewById(R.id.minus);
        // zoom in listener
        iv_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"zoom in",Toast.LENGTH_LONG).show();
                CameraUpdate zoom =CameraUpdateFactory.zoomIn();
                mMap.animateCamera(zoom);
            }
        });
        // zoom out listner
        iv_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CameraUpdateFactory.zoomOut();

            }
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(my_map);
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng sydney = new LatLng(12.91697, 77.614085);
        //LatLng sydney = new LatLng(41.9797770, -88.5337430);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Office")) ;
        //setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
//      googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        // marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        Circle circle = googleMap.addCircle(new CircleOptions()
                .center(sydney)
                .radius(500)
                .strokeColor(Color.parseColor("#4fb2ff"))
                .fillColor(Color.parseColor("#BBDEFB")));

        CameraUpdate center =
                CameraUpdateFactory.newLatLng(sydney);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(12);

        googleMap.moveCamera(center);
        googleMap.animateCamera(zoom);

    }
}
