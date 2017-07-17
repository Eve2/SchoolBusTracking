package com.schoolbus.schoolbustracking.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.schoolbus.schoolbustracking.R;

/**
 * Created by yinqingjiang on 7/17/17.
 */

public class SettingFragment extends Fragment {
    private ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_setting,container,false);
        listView=view.findViewById(R.id.listView);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getContext(),R.layout.listview,getResources().getStringArray(R.array.setting));
        listView.setAdapter(ad);
       // listView.setAdapter(new ArrayAdapter<String>(,R.layout.fragment_setting,android.R.id.text1,getResources().getStringArray(R.array.setting)));
        return view;
    }
}
