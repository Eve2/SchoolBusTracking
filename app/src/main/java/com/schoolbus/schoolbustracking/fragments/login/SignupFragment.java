package com.schoolbus.schoolbustracking.fragments.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.schoolbus.schoolbustracking.R;

/**
 * Created by Eve on 7/12/17.
 */

public class SignupFragment extends Fragment {

    ViewGroup viewGroup;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Button toLogin;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_signup, container, false);

        fragmentManager = getFragmentManager();

        toLogin = (Button) viewGroup.findViewById(R.id.toLogin);

        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumpToLogin();
            }
        });


        return viewGroup;
    }

    public void jumpToLogin() {

        SigninFragment signinFragment = new SigninFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.login_container, signinFragment).addToBackStack(null).commit();
    }


}
