package com.schoolbus.schoolbustracking.fragments.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.schoolbus.schoolbustracking.R;
import com.schoolbus.schoolbustracking.fragments.HelpFragment;
import com.schoolbus.schoolbustracking.fragments.SettingFragment;

/**
 * Created by Eve on 7/12/17.
 */

public class HomeFragment extends Fragment {

    ViewGroup viewGroup;
    LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4, linearLayout5;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        linearLayout1 = (LinearLayout) viewGroup.findViewById(R.id.ll1);
        linearLayout2 = (LinearLayout) viewGroup.findViewById(R.id.ll2);
        linearLayout3 = (LinearLayout) viewGroup.findViewById(R.id.ll3);
        linearLayout4 = (LinearLayout) viewGroup.findViewById(R.id.ll4);
        linearLayout5 = (LinearLayout) viewGroup.findViewById(R.id.ll5);


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new LocationFragment()).addToBackStack(null).commit();
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new StudentsFragment()).addToBackStack(null).commit();
            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new NotificationFragment()).addToBackStack(null).commit();
            }
        });

        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new SettingFragment()).addToBackStack(null).commit();
            }
        });

        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_container, new HelpFragment()).addToBackStack(null).commit();
            }
        });

        return viewGroup;
    }
}