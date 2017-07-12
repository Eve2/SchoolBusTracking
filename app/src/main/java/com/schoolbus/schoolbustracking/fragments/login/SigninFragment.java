package com.schoolbus.schoolbustracking.fragments.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.schoolbus.schoolbustracking.R;
import com.schoolbus.schoolbustracking.activities.HomeActivity;

/**
 * Created by Eve on 7/12/17.
 */

public class SigninFragment extends Fragment {

    ViewGroup viewGroup;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Button toHome;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_signin, container, false);

        fragmentManager = getFragmentManager();
        toHome = viewGroup.findViewById(R.id.toHome);

        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumpToHome();
            }
        });

        return viewGroup;
    }

    public void jumpToHome() {
        Intent i = new Intent(getActivity(), HomeActivity.class);
        startActivity(i);
    }
}
