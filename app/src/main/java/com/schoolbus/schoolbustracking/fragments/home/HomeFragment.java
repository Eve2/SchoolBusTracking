package com.schoolbus.schoolbustracking.fragments.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.schoolbus.schoolbustracking.R;

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

            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return viewGroup;
    }
}