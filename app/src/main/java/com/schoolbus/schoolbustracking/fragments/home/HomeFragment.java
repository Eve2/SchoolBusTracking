package com.schoolbus.schoolbustracking.fragments.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.schoolbus.schoolbustracking.R;

/**
 * Created by Eve on 7/12/17.
 */

public class HomeFragment extends Fragment {

    ViewGroup viewGroup;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);


        return viewGroup;
    }
}